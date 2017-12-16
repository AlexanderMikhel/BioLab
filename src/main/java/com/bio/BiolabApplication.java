package com.bio;

import com.bio.config.DataConfig;
import com.bio.config.JacksonConfig;
import com.bio.config.MultipartConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BiolabApplication {

	public static final String PROFILE_ID_HEADER = "Profile-Id";

	public static void main(String[] args) {
		SpringApplication.run(new Class[]{
				BiolabApplication.class,
				DataConfig.class,
				JacksonConfig.class,
				MultipartConfig.class
		}, args);
	}
}
