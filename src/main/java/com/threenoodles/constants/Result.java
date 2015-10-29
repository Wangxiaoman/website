package com.threenoodles.constants;

/**
 * 程序处理返回结果 code:程序业务处理结果返回码 msg:返回信息 data:返回数据
 *
 * @param <T>
 */
public class Result<T> {

	private int code;
	private String msg;
	private T data;

	public Result() {

	}

	public Result(int code) {
		this.code = code;
	}

	public Result(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Result(int code, T data) {
		this.code = code;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
