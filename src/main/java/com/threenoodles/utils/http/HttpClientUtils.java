package com.threenoodles.utils.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * @author threenoodles
 *
 */
public class HttpClientUtils {

	// /**
	// * 连接超时时间 毫秒
	// */
	// private static final int CONNECTION_TIMEOUT_MS = 360000;
	//
	// /**
	// * 读取数据超时时间
	// */
	// private static final int SO_TIMEOUT_MS = 360000;

	private final static int CONN_REQUEST_TIMEOUT = 3000;

	private final static int CONN_TIMEOUT = 3000;

	private final static int SOCKET_TIMEOUT = 3000;

	/**
	 * http get请求，支持传入参数、设置Cookie
	 * 
	 * @param httpReq
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 */
	public static Response getInvoke(Request request)
			throws ClientProtocolException, IOException, URISyntaxException,
			KeyManagementException, NoSuchAlgorithmException {
		HttpClient client = buildHttpClient(request.isUsingPoolClient(),
				request.isHttpsRequest());

		HttpGet get = buildHttpGet(request);
		get.setConfig(generateRequestConfig(request));

		HttpResponse httpResponse = client.execute(get);

		HttpEntity entity = httpResponse.getEntity();
		if (entity != null) {
			String returnStr = EntityUtils.toString(entity,
					request.getCharset());
			Response response = new Response();
			response.setStringResult(returnStr);
			response.setResponseStatusCode(httpResponse.getStatusLine()
					.getStatusCode());
			return response;
		}
		return null;
	}

	/**
	 * http post请求，支持设置参数的提交形式（form/string类型）
	 * 
	 * @param httpReq
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 */
	public static Response postInvoke(Request request)
			throws ClientProtocolException, IOException, URISyntaxException,
			KeyManagementException, NoSuchAlgorithmException {
		HttpClient client = buildHttpClient(request.isUsingPoolClient(),
				request.isHttpsRequest());

		HttpPost post = buildHttpPost(request);
		post.setConfig(generateRequestConfig(request));

		HttpResponse httpResponse = client.execute(post);

		HttpEntity entity = httpResponse.getEntity();

		if (entity != null) {
			String returnStr = EntityUtils.toString(entity,
					request.getCharset());
			Response response = new Response();
			response.setStringResult(returnStr);
			response.setResponseStatusCode(httpResponse.getStatusLine()
					.getStatusCode());
			return response;
		}
		return null;
	}

	/**
	 * http delete请求
	 * 
	 * @param request
	 * @return
	 * @throws KeyManagementException
	 * @throws NoSuchAlgorithmException
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static Response deleteInvoke(Request request)
			throws KeyManagementException, NoSuchAlgorithmException,
			ClientProtocolException, IOException {
		HttpClient client = buildHttpClient(request.isUsingPoolClient(),
				request.isHttpsRequest());

		HttpDelete delete = buildHttpDelete(request);
		delete.setConfig(generateRequestConfig(request));

		HttpResponse httpResponse = client.execute(delete);

		HttpEntity entity = httpResponse.getEntity();

		if (entity != null) {
			String returnStr = EntityUtils.toString(entity,
					request.getCharset());
			Response response = new Response();
			response.setStringResult(returnStr);
			response.setResponseStatusCode(httpResponse.getStatusLine()
					.getStatusCode());
			return response;
		}
		return null;
	}

	private static RequestConfig generateRequestConfig(Request request) {
		// 设置连接请求超时
		int connectionReqTimeout = CONN_REQUEST_TIMEOUT;
		if (request.getConnectionReqTimeout() > 0) {
			connectionReqTimeout = request.getConnectionReqTimeout();
		}
		// 设置连接超时
		int connectionTimeout = CONN_TIMEOUT;
		if (request.getConnectionTimeout() > 0) {
			connectionTimeout = request.getConnectionTimeout();
		}
		// 设置回应超时
		int socketTimeout = SOCKET_TIMEOUT;
		if (request.getSocketTimeout() > 0) {
			socketTimeout = request.getSocketTimeout();
		}
		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectionRequestTimeout(connectionReqTimeout)
				.setConnectTimeout(connectionTimeout)
				.setSocketTimeout(socketTimeout).build();
		return requestConfig;
	}

	/**
	 * 创建HttpClient
	 * 
	 * @param isMultiThread
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 */
	private static HttpClient buildHttpClient(boolean isMultiThread,
			boolean isHttps) throws KeyManagementException,
			NoSuchAlgorithmException {

		CloseableHttpClient client;

		if (isHttps) {
			client = buildSSLHttpClient();
			return client;
		}

		if (isMultiThread)
			client = HttpClientBuilder
					.create()
					.setConnectionManager(
							new PoolingHttpClientConnectionManager()).build();
		else
			client = HttpClientBuilder.create().build();
		return client;

	}

	/**
	 * 构造https请求的client，暂不支持poolClient
	 * 
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 */
	private static CloseableHttpClient buildSSLHttpClient()
			throws NoSuchAlgorithmException, KeyManagementException {
		X509TrustManager x509mgr = new X509TrustManager() {
			@Override
			public void checkClientTrusted(X509Certificate[] xcs, String string) {
			}

			@Override
			public void checkServerTrusted(X509Certificate[] xcs, String string) {
			}

			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};

		SSLContext sslContext = SSLContext.getInstance("TLS");
		sslContext.init(null, new TrustManager[] { x509mgr }, null);
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
				sslContext,
				SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

		return HttpClients.custom().setSSLSocketFactory(sslsf).build();
	}

	/**
	 * http delete请求
	 * 
	 * @param request
	 * @return
	 */
	private static HttpDelete buildHttpDelete(Request request) {
		HttpDelete delete = new HttpDelete(request.getUrl());
		Map<String, String> headers = request.getHeaders();
		if (headers != null) {
			for (Entry<String, String> entry : headers.entrySet()) {
				delete.addHeader(entry.getKey(), entry.getValue());
			}
		}
		return delete;
	}

	/**
	 * 构建httpPost对象
	 * 
	 * @param url
	 * @param headers
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws URISyntaxException
	 */
	private static HttpPost buildHttpPost(Request request)
			throws UnsupportedEncodingException, URISyntaxException {
		HttpPost post = new HttpPost(request.getUrl());
		// setCommonHttpMethod(post);
		HttpEntity entity = null;
		Map<String, String> params = request.getParameters();
		if (params != null) {
			List<NameValuePair> paris = new ArrayList<NameValuePair>();
			for (String key : params.keySet()) {
				paris.add(new BasicNameValuePair(key, params.get(key)));
			}
			entity = new UrlEncodedFormEntity(paris, request.getCharset());
			post.setEntity(entity);
		}
		if (request.getEntityString() != null) {
			post.setEntity(new StringEntity(request.getEntityString(), request
					.getCharset()));
		}
		Map<String, String> headers = request.getHeaders();
		if (headers != null) {
			for (Entry<String, String> entry : headers.entrySet()) {
				post.addHeader(entry.getKey(), entry.getValue());
			}
		}
		return post;
	}

	/**
	 * 构建httpGet对象
	 * 
	 * @param url
	 * @param headers
	 * @return
	 * @throws URISyntaxException
	 */
	private static HttpGet buildHttpGet(Request request)
			throws URISyntaxException {
		HttpGet get = new HttpGet(buildGetUrl(request.getUrl(),
				request.getParameters(), request.getCharset()));
		Map<String, String> headers = request.getHeaders();
		if (headers != null) {
			for (Entry<String, String> entry : headers.entrySet()) {
				get.addHeader(entry.getKey(), entry.getValue());
			}
		}
		if (request.getCookies() != null) {
			get.setHeader("Cookie", request.getCookies());
		}
		return get;
	}

	/**
	 * build getUrl str
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	private static String buildGetUrl(String url, Map<String, String> params,
			String charset) {
		StringBuffer uriStr = new StringBuffer(url);
		if (params != null) {
			List<NameValuePair> ps = new ArrayList<NameValuePair>();
			for (String key : params.keySet()) {
				ps.add(new BasicNameValuePair(key, params.get(key)));
			}
			uriStr.append("?");
			uriStr.append(URLEncodedUtils.format(ps, charset));
		}
		return uriStr.toString();
	}

	// /**
	// * 设置HttpMethod通用配置
	// *
	// * @param httpMethod
	// */
	// public static void setCommonHttpMethod(HttpRequestBase httpMethod) {
	// httpMethod.setHeader(HTTP.CONTENT_ENCODING, UTF8_CHARSET);// setting
	// // contextCoding
	// // httpMethod.setHeader(HTTP.CHARSET_PARAM,
	// // CONTENT_CHARSET);
	// // httpMethod.setHeader(HTTP.CONTENT_TYPE, CONTENT_TYPE_JSON_CHARSET);
	// // httpMethod.setHeader(HTTP.CONTENT_TYPE, CONTENT_TYPE_XML_CHARSET);
	// }

}
