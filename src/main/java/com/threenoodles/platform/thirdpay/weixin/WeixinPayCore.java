package com.threenoodles.platform.thirdpay.weixin;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpStatus;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.threenoodles.platform.thirdpay.ThirdpayUtils;
import com.threenoodles.platform.thirdpay.weixin.model.WeixinPayOrderQueryParams;
import com.threenoodles.platform.thirdpay.weixin.model.WeixinPayOrderQueryResult;
import com.threenoodles.platform.thirdpay.weixin.model.WeixinPayUnifiedOrderParams;
import com.threenoodles.platform.thirdpay.weixin.model.WeixinPayUnifiedOrderResult;
import com.threenoodles.utils.MD5;
import com.threenoodles.utils.http.HttpClientUtils;
import com.threenoodles.utils.http.Request;
import com.threenoodles.utils.http.Response;

public class WeixinPayCore {
	private static Log logger = LogFactory.getLog(WeixinPayCore.class);

	private final static String UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

	private final static String ORDER_QUERY_URL = "https://api.mch.weixin.qq.com/pay/orderquery";

	/**
	 * 请求微信后台，生成预付单信息
	 * 
	 * @param params
	 */
	public static WeixinPayUnifiedOrderResult unifiedOrder(
			WeixinPayUnifiedOrderParams params) {
		logger.info("WeixinPayCore:unifiedOrder outTradeNo="
				+ params.getOutTradeNo() + ",totalFee=" + params.getTotalFee()
				+ ",spbillCreateIp=" + params.getSpbillCreateIp()
				+ ",tradeType=" + params.getTradeType());
		Request request = new Request();
		request.setUrl(UNIFIED_ORDER_URL);

		request.setEntityString(genProductArgs(params));

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Accept", "application/json");
		headers.put("Content-type", "application/json");
		request.setHeaders(headers);
		Response response = null;
		try {
			response = HttpClientUtils.postInvoke(request);
			logger.info("WeixinPayCore:unifiedOrder http post statusCode="
					+ response.getResponseStatusCode());
		} catch (KeyManagementException | NoSuchAlgorithmException
				| IOException | URISyntaxException e) {
			logger.error("WeixinPayCore:unifiedOrder http post error", e);
			return null;
		}
		WeixinPayUnifiedOrderResult result = null;
		if (response.getResponseStatusCode() == HttpStatus.SC_OK) {
			result = xmlToUnifiedOrderResult(response);
			logger.info("WeixinPayCore:unifiedOrder returnCode="
					+ result.getReturnCode() + ",resultCode="
					+ result.getResultCode());
		}
		return result;
	}

	public static WeixinPayOrderQueryResult orderQuery(
			WeixinPayOrderQueryParams params) {
		logger.info("WeixinPayCore:orderQuery outTradeNo="
				+ params.getOutTradeNo() + ",transactionId="
				+ params.getTransactionId());
		Request request = new Request();
		request.setUrl(ORDER_QUERY_URL);

		request.setEntityString(genOrderQueryArgs(params));

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Accept", "application/json");
		headers.put("Content-type", "application/json");
		request.setHeaders(headers);
		Response response = null;
		try {
			response = HttpClientUtils.postInvoke(request);
			logger.info("WeixinPayCore:orderQuery http post statusCode="
					+ response.getResponseStatusCode());
		} catch (KeyManagementException | NoSuchAlgorithmException
				| IOException | URISyntaxException e) {
			logger.error("WeixinPayCore:orderQuery http post error", e);
		}
		WeixinPayOrderQueryResult result = null;
		if (response.getResponseStatusCode() == HttpStatus.SC_OK) {
			result = xmlToOrderQueryResult(response);
			logger.info("WeixinPayCore:orderQuery returnCode="
					+ result.getReturnCode() + ",resultCode="
					+ result.getResultCode());
		}
		return result;
	}

	private static String genOrderQueryArgs(WeixinPayOrderQueryParams params) {
		try {
			Map<String, String> packageParams = new HashMap<String, String>();
			packageParams.put("appid", WeixinPayConfig.APP_ID);
			packageParams.put("mch_id", WeixinPayConfig.MCH_ID);
			packageParams.put("transaction_id", params.getTransactionId());
			packageParams.put("out_trade_no", params.getOutTradeNo());
			packageParams.put("nonce_str", genNonceStr());

			packageParams.put("sign", genPackageSign(packageParams));

			String xmlstring = toXml(packageParams);
			return xmlstring;
		} catch (Exception e) {
			return null;
		}
	}

	private static WeixinPayUnifiedOrderResult xmlToUnifiedOrderResult(
			Response response) {
		String resultStr = response.getStringResult();
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(resultStr);
		} catch (DocumentException e) {
			logger.error("WeixinPayCore:xmlToResultObject xml convert error", e);
			return null;
		}
		Element rootEle = doc.getRootElement();
		WeixinPayUnifiedOrderResult result = new WeixinPayUnifiedOrderResult();
		result.setReturnCode(rootEle.element("return_code").getText());
		result.setReturnMsg(rootEle.element("return_msg").getText());
		if (rootEle.element("appid") != null) {
			result.setAppId(rootEle.element("appid").getText());
		}
		if (rootEle.element("mch_id") != null) {
			result.setMchId(rootEle.element("mch_id").getText());
		}
		if (rootEle.element("nonce_str") != null) {
			result.setNonceStr(rootEle.element("nonce_str").getText());
		}
		if (rootEle.element("sign") != null) {
			result.setSign(rootEle.element("sign").getText());
		}
		if (rootEle.element("result_code") != null) {
			result.setResultCode(rootEle.element("result_code").getText());
		}
		if (rootEle.element("prepay_id") != null) {
			result.setPrepayId(rootEle.element("prepay_id").getText());
		}
		if (rootEle.element("trade_type") != null) {
			result.setTradeType(rootEle.element("trade_type").getText());
		}
		if (rootEle.element("err_code") != null) {
			result.setErrorCode(rootEle.element("err_code").getText());
		}
		if (rootEle.element("err_code_des") != null) {
			result.setErrorCodeDesc(rootEle.element("err_code_des").getText());
		}
		return result;
	}

	private static WeixinPayOrderQueryResult xmlToOrderQueryResult(
			Response response) {
		String resultStr = response.getStringResult();
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(resultStr);
		} catch (DocumentException e) {
			logger.error(
					"WeixinPayCore:xmlToOrderQueryResult xml convert error", e);
			return null;
		}
		Element rootEle = doc.getRootElement();
		WeixinPayOrderQueryResult result = new WeixinPayOrderQueryResult();
		result.setReturnCode(rootEle.element("return_code").getText());
		result.setReturnMsg(rootEle.element("return_msg").getText());
		if (rootEle.element("appid") != null) {
			result.setAppId(rootEle.element("appid").getText());
		}
		if (rootEle.element("mch_id") != null) {
			result.setMchId(rootEle.element("mch_id").getText());
		}
		if (rootEle.element("nonce_str") != null) {
			result.setNonceStr(rootEle.element("nonce_str").getText());
		}
		if (rootEle.element("sign") != null) {
			result.setSign(rootEle.element("sign").getText());
		}
		if (rootEle.element("result_code") != null) {
			result.setResultCode(rootEle.element("result_code").getText());
		}
		if (rootEle.element("err_code") != null) {
			result.setErrorCode(rootEle.element("err_code").getText());
		}
		if (rootEle.element("err_code_des") != null) {
			result.setErrorCodeDesc(rootEle.element("err_code_des").getText());
		}
		if (rootEle.element("openid") != null) {
			result.setOpenid(rootEle.element("openid").getText());
		}
		if (rootEle.element("is_subscribe") != null) {
			result.setIsSubscribe(rootEle.element("is_subscribe").getText());
		}
		if (rootEle.element("trade_type") != null) {
			result.setTradeType(rootEle.element("trade_type").getText());
		}
		if (rootEle.element("trade_state") != null) {
			result.setTradeState(rootEle.element("trade_state").getText());
		}
		if (rootEle.element("bank_type") != null) {
			result.setBankType(rootEle.element("bank_type").getText());
		}
		if (rootEle.element("total_fee") != null) {
			result.setTotalFee(Integer.parseInt(rootEle.element("total_fee")
					.getText()));
		}
		if (rootEle.element("cash_fee") != null) {
			result.setCashFee(Integer.parseInt(rootEle.element("cash_fee")
					.getText()));
		}
		if (rootEle.element("transaction_id") != null) {
			result.setTransactionId(rootEle.element("transaction_id").getText());
		}
		if (rootEle.element("out_trade_no") != null) {
			result.setOutTradeNo(rootEle.element("out_trade_no").getText());
		}
		if (rootEle.element("time_end") != null) {
			result.setTimeEnd(rootEle.element("time_end").getText());
		}

		if (rootEle.element("trade_state_desc") != null) {
			result.setTradeStateDesc((rootEle.element("trade_state_desc")
					.getText()));
		}
		return result;
	}

	private static String genProductArgs(WeixinPayUnifiedOrderParams params) {
		try {
			Map<String, String> packageParams = new HashMap<String, String>();
			packageParams.put("appid", WeixinPayConfig.APP_ID);
			packageParams.put("body", params.getBody());
			packageParams.put("mch_id", WeixinPayConfig.MCH_ID);
			packageParams.put("nonce_str", genNonceStr());
			packageParams.put("notify_url", WeixinPayConfig.NOTIFY_URL);
			packageParams.put("out_trade_no", params.getOutTradeNo());
			packageParams.put("spbill_create_ip", params.getSpbillCreateIp());
			packageParams
					.put("total_fee", String.valueOf(params.getTotalFee()));
			packageParams.put("trade_type", params.getTradeType());

			packageParams.put("sign", genPackageSign(packageParams));

			String xmlstring = toXml(packageParams);
			return xmlstring;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 生成签名
	 */
	private static String genPackageSign(Map<String, String> params) {
		Map<String, String> filteredParams = ThirdpayUtils.paraFilter(params);
		String paramsStr = ThirdpayUtils.createLinkString(filteredParams);
		paramsStr += "&key=" + WeixinPayConfig.KEY;
		String packageSign = MD5.getMD5Code(paramsStr).toUpperCase();
		return packageSign;
	}

	private static String genNonceStr() {
		Random random = new Random();
		return MD5.getMD5Code(String.valueOf(random.nextInt(10000)));
	}

	private static String toXml(Map<String, String> params) {
		StringBuilder sb = new StringBuilder();
		sb.append("<xml>");
		for (Entry<String, String> entry : params.entrySet()) {
			sb.append("<" + entry.getKey() + ">");
			sb.append(entry.getValue());
			sb.append("</" + entry.getKey() + ">");
		}
		sb.append("</xml>");
		return sb.toString();
	}

}
