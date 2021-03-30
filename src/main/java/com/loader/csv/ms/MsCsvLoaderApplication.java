package com.loader.csv.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsCsvLoaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCsvLoaderApplication.class, args);
	}

}
