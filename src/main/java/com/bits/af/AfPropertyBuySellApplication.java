package com.bits.af;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class AfPropertyBuySellApplication extends WebMvcAutoConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(AfPropertyBuySellApplication.class, args);
	}

}
