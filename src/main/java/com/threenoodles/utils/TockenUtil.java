package com.threenoodles.utils;

import java.util.UUID;

/**
 * 生成用户的tocken，统一调用工具类，方便后续修改生成策略
 * 
 * @author zhangjiayu
 *
 */
public class TockenUtil {

	public static String generateTocken() {
		return UUID.randomUUID().toString();
	}

}
