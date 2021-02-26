package com.codigo.smartstore.webapi.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
// import
// org.springframework.samples.mvc.convert.MaskFormatAnnotationFormatterFactory;
// import org.springframework.samples.mvc.data.custom.CustomArgumentResolver;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.context.request.async.TimeoutCallableProcessingInterceptor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

// DispatcherServlet context:defines Spring MVC infrastructure/and web
// application components

@Configuration
@ComponentScan(basePackages = "org.springframework.samples.mvc")
@EnableWebMvc
@EnableScheduling
public class WebMvcConfig
	implements WebMvcConfigurer {

	// @Override
	// public void addFormatters(final FormatterRegistry registry) {
	//
	// registry.addFormatterForFieldAnnotation(new
	// MaskFormatAnnotationFormatterFactory());
	// }
	//
	// @Override
	// public void addArgumentResolvers(final List<HandlerMethodArgumentResolver>
	// resolvers) {
	//
	// resolvers.add(new CustomArgumentResolver());
	// }

	// Handle HTTP GET requests for /resources/** by efficiently serving
	// static resources under ${webappRoot}/resources/

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/resources/");
	}

	@Override
	public void addViewControllers(final ViewControllerRegistry registry) {

		registry.addViewController("/")
				.setViewName("home");
	}

	// @Override
	// public void configureViewResolvers(final ViewResolverRegistry registry) {
	//
	// registry.jsp("/WEB-INF/views/", ".jsp");
	// }

	@Override
	public void configurePathMatch(final PathMatchConfigurer configurer) {

		final UrlPathHelper pathHelper = new UrlPathHelper();
		pathHelper.setRemoveSemicolonContent(false); // For @MatrixVariable's
		configurer.setUrlPathHelper(pathHelper);
	}

	@Override
	public void configureAsyncSupport(final AsyncSupportConfigurer configurer) {

		configurer.setDefaultTimeout(3000);
		configurer.registerCallableInterceptors(new TimeoutCallableProcessingInterceptor());
	}

	// @Bean
	// public FilterRegistrationBean<RequestResponseLoggingFilter> loggingFilter() {
	//
	// final FilterRegistrationBean<RequestResponseLoggingFilter> registrationBean =
	// new FilterRegistrationBean<>();
	//
	// registrationBean.setFilter(new RequestResponseLoggingFilter());
	// registrationBean.addUrlPatterns("/users/*");
	//
	// return registrationBean;
	// }

	// @Bean()
	// public ConfigurableServletWebServerFactory
	// jettyEmbeddedServletContainerFactory() {
	//
	// final JettyServletWebServerFactory jettyContainer = new
	// JettyServletWebServerFactory();
	// jettyContainer.setPort(9000);
	// jettyContainer.setContextPath("/smartstore");
	// return jettyContainer;
	// }

	// @Bean
	// public MultipartResolver multipartResolver() {
	//
	// return new CommonsMultipartResolver();
	// }

}