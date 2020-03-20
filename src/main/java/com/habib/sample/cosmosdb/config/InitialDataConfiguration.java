package com.habib.sample.cosmosdb.config;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class InitialDataConfiguration {
	
	
	@Bean
	public FilterRegistrationBean correlationHeaderFilter() {
		FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
		filterRegBean.setFilter(new CorrelationIDHeaderFilter());
		filterRegBean.setUrlPatterns(Arrays.asList("/*"));
		return filterRegBean;
	}

	
	
	

}
