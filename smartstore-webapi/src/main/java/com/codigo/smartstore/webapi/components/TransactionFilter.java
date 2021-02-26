package com.codigo.smartstore.webapi.components;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Order(1)
@Slf4j
public class TransactionFilter
	implements Filter {

	private static Logger log = Logger.getLogger(TransactionFilter.class);

	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {

		final HttpServletRequest req = (HttpServletRequest) request;
		log.info("Starting a transaction for req : {}" + req.getRequestURI());

		chain.doFilter(request, response);
		log.info("Committing a transaction for req : {}" + req.getRequestURI());
	}
}
