package com.threenoodles.platform.thirdpay.weixin.model;

public class WeixinPayOrderQueryParams {
	private String transactionId; // 微信的订单号，优先使用

	private String outTradeNo; // 商户系统内部的订单号，当没提供transaction_id时需要传这个

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

}
