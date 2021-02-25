package com.codigo.smartstore.webapi.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig
		extends
		WebMvcConfig

{

	/**
	 * https://www.javadevjournal.com/spring/rest/swagger-2-spring-rest-api/
	 * @return Docket
	 */
	@Bean
	public Docket employeeApi() {

		return new Docket(DocumentationType.SWAGGER_2).groupName("smart-api")
				.apiInfo(this.getApiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.codigo.smartstore.webapi.controllers"))
				.paths(PathSelectors.ant("/api/**"))
				.build();

		// .globalResponseMessage(RequestMethod.GET,
		// new ArrayList(new ResponseMessageBuilder().code(500)
		// .message("500 message")
		// .responseModel(new ModelRef("Error"))
		// .build()));

	}

	private ApiInfo getApiInfo() {

		return new ApiInfo("Smartstore Api Documentation", "How to generate Swagger documentation for your Rest API",
				"1.0.1", "urn:tos",
				new Contact("Java Dev Journal", "www.javadevjournal.com", "codigo-technology@com.pl"), "Apache 2.0",
				"http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
	}

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {

		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

}