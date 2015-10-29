package com.threenoodles.platform.thirdpay.weixin.model;

/**
 * 微信支付查询订单接口调用返回结果
 * 
 * @author zhangjiayu
 *
 */
public class WeixinPayOrderQueryResult {

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

	private String openid; // 用户在商户appid下的唯一标识

	private String isSubscribe; // 用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效

	private String tradeType; // 调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP，MICROPAY

	private String tradeState; // SUCCESS—支付成功,REFUND—转入退款,NOTPAY—未支付,CLOSED—已关闭,REVOKED—已撤销,USERPAYING--用户支付中,PAYERROR--支付失败(其他原因，如银行返回失败)

	private String bankType; // 银行类型，采用字符串类型的银行标识

	private int totalFee; // 订单总金额，单位为分

	private int cashFee; // 现金支付金额订单现金支付金额

	private String transactionId; // 微信支付订单号

	private String outTradeNo; // 商户系统的订单号，与请求一致

	private String timeEnd; // 订单支付时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010

	private String tradeStateDesc; // 对当前查询订单状态的描述和下一步操作的指引

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

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getIsSubscribe() {
		return isSubscribe;
	}

	public void setIsSubscribe(String isSubscribe) {
		this.isSubscribe = isSubscribe;
	}

	public String getTradeState() {
		return tradeState;
	}

	public void setTradeState(String tradeState) {
		this.tradeState = tradeState;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public int getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(int totalFee) {
		this.totalFee = totalFee;
	}

	public int getCashFee() {
		return cashFee;
	}

	public void setCashFee(int cashFee) {
		this.cashFee = cashFee;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getTradeStateDesc() {
		return tradeStateDesc;
	}

	public void setTradeStateDesc(String tradeStateDesc) {
		this.tradeStateDesc = tradeStateDesc;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

}
