package com.whereistango.web.temp.app;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan({ "com.whereistango.web.temp.app", "com.whereistango.web.temp.service",
		"com.whereistango.web.temp.controller", "com.whereistango.web.temp.validator" })
public class TmpSpringWebConfig extends WebMvcConfigurerAdapter {

	private final Log logger = LogFactory.getLog(TmpSpringWebConfig.class);

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		if (logger.isTraceEnabled()) {
			logger.trace(">>>>>>>>>>>>>>entered addResourceHandlers()");
		}

		registry.addResourceHandler("/src/**").addResourceLocations("/src/");
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		if (logger.isTraceEnabled()) {
			logger.trace(">>>>>>>>>>>>>>entered viewResolver()");
		}

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/page");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		if (logger.isTraceEnabled()) {
			logger.trace(">>>>>>>>>>>>>>entered messageSource()");
		}

		ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
		rb.setBasenames(new String[] { "messages/messages", "messages/validation" });
		return rb;
	}

}