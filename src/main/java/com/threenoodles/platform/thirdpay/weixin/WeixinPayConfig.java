package com.threenoodles.platform.thirdpay.weixin;

import com.threenoodles.platform.config.SystemGlobals;

public class WeixinPayConfig {
	// 微信分配的公众账号ID
	public final static String APP_ID = SystemGlobals
			.getPreference("weixin.appId");

	// 微信支付分配的商户号
	public final static String MCH_ID = SystemGlobals
			.getPreference("weixin.mchId");

	// 私钥
	public final static String KEY = SystemGlobals.getPreference("weixin.key");

	// 用于处理微信支付返回结果的接口地址
	public final static String NOTIFY_URL = SystemGlobals
			.getPreference("weixin.notifyUrl");

}
