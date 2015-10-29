package com.threenoodles.utils;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JSONUtil {

	private static Logger logger = Logger.getLogger(JSONUtil.class);

	private static JSONObject successJson = initSuccessJson();

	/**
	 * 解析返回对象的list
	 * 
	 * @param content
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> parseList(String content, Class<T> clazz) {
		if (StringUtils.isBlank(content)) {
			return Collections.emptyList();
		}
		List<T> results = null;
		try {
			results = JSON.parseArray(content, clazz);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return (results == null ? Collections.EMPTY_LIST : results);
	}

	/**
	 * 解析返回对象
	 * 
	 * @param content
	 * @param clazz
	 * @return
	 */
	public static <T> T parse(String content, Class<T> clazz) {
		if (StringUtils.isBlank(content)) {
			return null;
		}
		T result = null;
		try {
			result = JSON.parseObject(content, clazz);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 解析JsonObject
	 * 
	 * @param content
	 * @return
	 */
	public static JSONObject parseObject(String content) {
		if (StringUtils.isBlank(content)) {
			return null;
		}
		JSONObject result = null;
		try {
			result = JSON.parseObject(content);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 将对象解析成JSON
	 * 
	 * @param content
	 * @return
	 */
	public static String toJSONString(Object object) {
		if (object == null) {
			return null;
		}
		String result = null;
		try {
			result = JSON.toJSONString(object);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 初始化successJson
	 * 
	 * @return
	 */
	private static JSONObject initSuccessJson() {
		JSONObject successJson = new JSONObject();
		successJson.put("code", 0);
		successJson.put("msg", StringUtils.EMPTY);
		return successJson;
	}

	/**
	 * 获取成功的json object
	 * 
	 * @return
	 */
	public static JSONObject getSuccessJson() {
		return successJson;
	}

	/**
	 * 获取失败的json object
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	public static JSONObject getFailuerJson(int code, String msg) {
		JSONObject failureJson = new JSONObject();
		failureJson.put("code", code);
		failureJson.put("msg", msg);
		return failureJson;
	}
}
