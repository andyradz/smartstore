package com.codigo.smartstore.webapi.configuration;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.codigo.smartstore.webapi.CustomRequestInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan({ "com.codigo.smartstore.webapi" })
public class RequestAppConfig
	implements WebMvcConfigurer {

	@Autowired
	private CustomRequestInterceptor customRequestInterceptor;

	@Override
	public void addInterceptors(final InterceptorRegistry registry) {

		registry.addInterceptor(this.customRequestInterceptor)
				.addPathPatterns("/**/log-incoming-request/**/");

	}

	public RequestAppConfig() {

		super();
	}

	//

	@Override
	public void configureMessageConverters(final List<HttpMessageConverter<?>> messageConverters) {

		final Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		builder.indentOutput(true)
				.dateFormat(new SimpleDateFormat(
						"dd-MM-yyyy hh:mm"));

	}

	@Override
	public void configureContentNegotiation(final ContentNegotiationConfigurer configurer) {

		configurer.defaultContentType(MediaType.APPLICATION_JSON);
	}

	@Override
	public void addCorsMappings(final CorsRegistry registry) {

		registry.addMapping("/**");
	}
}