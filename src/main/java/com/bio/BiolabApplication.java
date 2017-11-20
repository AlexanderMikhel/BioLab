package com.bio;

import com.bio.config.DataConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BiolabApplication {

	public static void main(String[] args) {
		SpringApplication.run(new Class[]{
				BiolabApplication.class,
				DataConfig.class
		}, args);
	}
}
