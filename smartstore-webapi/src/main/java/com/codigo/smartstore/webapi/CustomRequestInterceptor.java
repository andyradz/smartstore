package com.codigo.smartstore.webapi;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class CustomRequestInterceptor
		extends
		HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(CustomRequestInterceptor.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response,
			final Object handler) {

		final long startTime = Instant.now()
				.toEpochMilli();

		logger.info("Request URL::" + request.getRequestURL()
				.toString()
				+ ":: Start Time="
				+ Instant.now());

		request.setAttribute("startTime", startTime);

		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response,
			final Object handler, final Exception ex) {

		final long startTime = Long.class.cast(request.getAttribute("startTime"));

		logger.info("Request URL::" + request.getRequestURL()
				.toString()
				+ ":: Time Taken="
				+ (Instant.now()
						.toEpochMilli() - startTime));
	}
}