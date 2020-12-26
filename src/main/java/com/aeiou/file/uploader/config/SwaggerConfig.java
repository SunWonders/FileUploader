
package com.aeiou.file.uploader.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// TODO: Auto-generated Javadoc
/**
 * The Class SwaggerConfig.
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

	/**
	 * Content api.
	 *
	 * @return the docket
	 */
	@Bean
	public Docket contentApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.aeiou.file.uploader")).paths(regex("/v1/.*"))
				.build().apiInfo(apiInfo());
	}

	/**
	 * Api info.
	 *
	 * @return the api info
	 */
	private ApiInfo apiInfo() {
		return new ApiInfo("Image Uploader Service", "Image Uploader Service Used for Upload , Read and Share", "1.0", null,
				new Contact("aeiou", "http://www.aeiou.co.in", null), null, null, Collections.emptyList());

	}

}
