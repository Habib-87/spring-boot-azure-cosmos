package com.habib.sample.cosmosdb.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.ListVendorExtension;
import springfox.documentation.service.ObjectVendorExtension;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
	 

	@Bean
	public Docket swaggerV1() {
      

		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("v1")
				.apiInfo(portalApiInfo("V1"))
				.select().apis(RequestHandlerSelectors.basePackage("com.habib"))
				.paths(PathSelectors.regex("/worker/refdata/v1/.*")).build();
	}
	

	    private ApiInfo portalApiInfo(String version) {

	        String description;
	        try {
	            InputStream resourceAsStream = SwaggerConfig.class.getResourceAsStream("/description.md");
	            description = IOUtils.toString(resourceAsStream);
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }

	        return new ApiInfoBuilder()
	                .title("Worker Reference Data")
	                .description(description)
	                .version(version)
	           .build();
	    }

}
 