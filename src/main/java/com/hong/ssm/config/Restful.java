package com.hong.ssm.config;

import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

/**
 * Restful连接工具类
 */
public class Restful extends RestTemplate {
	public Restful() {
		int connectionRequestTimeout = 1000, connectTimeout = 1000, readTimeout = 30 * 1000;
		super.setRequestFactory(factory(connectionRequestTimeout, connectTimeout, readTimeout));
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		List<HttpMessageConverter<?>> messageConverters = this.getMessageConverters();
		messageConverters.add(converter);
		this.setMessageConverters(messageConverters);
	}

	public Restful(int connectionRequestTimeout, int connectTimeout, int readTimeout) {
		super.setRequestFactory(factory(connectionRequestTimeout, connectTimeout, readTimeout));
	}

	private HttpComponentsClientHttpRequestFactory factory(int connectionRequestTimeout, int connectTimeout,
			int readTimeout) {
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectionRequestTimeout(connectionRequestTimeout);
		requestFactory.setConnectTimeout(connectTimeout);
		requestFactory.setReadTimeout(readTimeout);
		return requestFactory;
	}
}
