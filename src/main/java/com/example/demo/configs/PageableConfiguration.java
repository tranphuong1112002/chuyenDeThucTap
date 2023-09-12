package com.example.demo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;

@Configuration
public class PageableConfiguration {

	@Bean
	public PageableHandlerMethodArgumentResolverCustomizer paginationCustomizer() {
		return pageableResolver -> pageableResolver.setMaxPageSize(Integer.MAX_VALUE); // default is 2000
	}
}
