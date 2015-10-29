package com.threenoodles.platform.thirdpay.weixin.model;

/**
 * 微信支付生成预订单接口参数
 * 
 * @author zhangjiayu
 *
 */
public class WeixinPayUnifiedOrderParams {

	/*** 以下为必填参数 ***/
	private String body; // 商品描述

	private String outTradeNo; // 商品订单号

	private int totalFee; // 总金额，接口中参数支付金额单位为【分】，参数值不能带小数

	private String spbillCreateIp; // 终端IP，APP和网页支付提交用户端IP，Native支付填调用微信支付API的机器IP

	private String tradeType; // 交易类型，取值如下：JSAPI，NATIVE，APP，WAP
	/*** 以上为必填参数 ***/

	private String openid; // 用户标识，trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识。下单前需要调用【网页授权获取用户信息】接口获取到用户的Openid

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public int getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(int totalFee) {
		this.totalFee = totalFee;
	}

	public String getSpbillCreateIp() {
		return spbillCreateIp;
	}

	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

}
