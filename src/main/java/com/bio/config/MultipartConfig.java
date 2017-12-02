package com.bio.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.servlet.MultipartConfigElement;

/**
 * This class use for MultipartFile
 */
@Configuration
public class MultipartConfig {
    @Bean
    MultipartConfigElement multipartConfigElement() {
        return new MultipartConfigFactory().createMultipartConfig();
    }
}
