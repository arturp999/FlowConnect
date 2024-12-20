package com.flow.connect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan(basePackages = "com.flow.connect") 
public class FlowConnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowConnectApplication.class, args);
	}

}
