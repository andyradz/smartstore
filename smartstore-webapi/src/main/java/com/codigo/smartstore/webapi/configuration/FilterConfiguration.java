package com.codigo.smartstore.webapi.configuration;

import java.util.Collections;

import javax.servlet.DispatcherType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.codigo.smartstore.webapi.components.TransactionFilter;

public class FilterConfiguration {

	private final TransactionFilter dateLoggingFilter;

	@Autowired
	public FilterConfiguration(final TransactionFilter dateLoggingFilter) {

		this.dateLoggingFilter = dateLoggingFilter;
	}

	@Bean
	public FilterRegistrationBean<TransactionFilter> dateLoggingFilterRegistration() {

		final FilterRegistrationBean<TransactionFilter> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(this.dateLoggingFilter);
		filterRegistrationBean.setUrlPatterns(Collections.singletonList("/*"));
		filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST);
		filterRegistrationBean.setOrder(1);

		return filterRegistrationBean;
	}

}
