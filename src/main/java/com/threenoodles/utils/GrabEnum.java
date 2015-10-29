/**
 * 
 */
package com.threenoodles.utils;

/**
 * @author libing
 *
 */
public enum GrabEnum {
	Kr(1, "36kr", "36kr.com"), Huxiu(2, "huxiu", "huxiu.com"),Ifeve(3,"ifeve","ifeve.com"),WeiXin(4,"weixin","mp.weixin.qq.com");
	private int index;
	private String value;
	private String domain;

	GrabEnum(int index, String value, String domain) {
		this.index = index;
		this.value = value;
		this.domain = domain;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index
	 *            the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * @param domain
	 *            the domain to set
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}

}
