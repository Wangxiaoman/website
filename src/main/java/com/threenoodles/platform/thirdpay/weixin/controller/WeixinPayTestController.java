package com.threenoodles.platform.thirdpay.weixin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.threenoodles.platform.thirdpay.weixin.WeixinPayCore;
import com.threenoodles.platform.thirdpay.weixin.model.WeixinPayUnifiedOrderParams;
import com.threenoodles.platform.thirdpay.weixin.model.WeixinPayUnifiedOrderResult;
import com.threenoodles.utils.JSONUtil;

@Controller
@RequestMapping("weixin_pay")
public class WeixinPayTestController {

	@RequestMapping("/unifiedOrder.do")
	public JSONObject unifiedOrder(WeixinPayUnifiedOrderParams params) {
		// TODO 必填参数检测
		WeixinPayUnifiedOrderResult result = WeixinPayCore.unifiedOrder(params);
		if (result == null || "FAIL".equals(result.getReturnCode())
				|| "FAIL".equals(result.getResultCode())) {
			return JSONUtil.getFailuerJson(500, "请求出错");
		}
		return JSONUtil.parseObject(JSONUtil.toJSONString(result));
	}
}
