package com.MiniProject;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry reg) {
		reg
		.addResourceHandler("/gbr/**").addResourceLocations("file:C:/Bootcamp Java/mini-project-batch-263/BayuHutama/MiniProject/uploadingDir/")
		.setCachePeriod(0);
	}
}
