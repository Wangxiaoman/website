/**
 * 
 */
package com.threenoodles.utils;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author libing
 *
 */
public class UrlUtils {
	public static String getDomainName(String url) throws MalformedURLException {
		if (!url.startsWith("http") && !url.startsWith("https")) {
			url = "http://" + url;
		}
		URL netUrl = new URL(url);
		String host = netUrl.getHost();
		if (host.startsWith("www")) {
			host = host.substring("www".length() + 1);
		}
		return host;
	}
}
