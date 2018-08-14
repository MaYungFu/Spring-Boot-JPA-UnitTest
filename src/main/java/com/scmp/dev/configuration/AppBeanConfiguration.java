package com.scmp.dev.configuration;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.scmp.dev.reporsitory")
@Configuration
public class AppBeanConfiguration {
	
	@Resource
	private Environment env;;
	
	
}
