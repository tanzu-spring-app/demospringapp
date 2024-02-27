package com.vmware.jmxclient.jmxconnector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Configuration
@EnableScheduling
public class JmxconnectorApplication {

	public static void main(String[] args) {

		SpringApplication.run(JmxconnectorApplication.class, args);
	}

}
