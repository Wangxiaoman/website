package com.threenoodles.platform.thirdpay.weixin.model;

/**
 * 微信支付生成预订单接口调用返回结果
 * 
 * @author zhangjiayu
 *
 */
public class WeixinPayUnifiedOrderResult {

	private String returnCode;

	private String returnMsg;

	/** 以下字段在return_code为SUCCESS的时候有返回 */

	private String appId;

	private String mchId;

	private String nonceStr;

	private String sign;

	private String resultCode; // 业务结果

	private String errorCode;

	private String errorCodeDesc;
	/** 以上字段在return_code为SUCCESS的时候有返回 */

	/** 以下字段在return_code 和result_code都为SUCCESS的时候有返回 */
	private String prepayId; // 微信生成的预支付会话标识，用于后续接口调用中使用，该值有效期为2小时

	private String tradeType;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorCodeDesc() {
		return errorCodeDesc;
	}

	public void setErrorCodeDesc(String errorCodeDesc) {
		this.errorCodeDesc = errorCodeDesc;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getPrepayId() {
		return prepayId;
	}

	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

}
