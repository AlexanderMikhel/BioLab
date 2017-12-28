package com.bio.config;

import com.bio.BiolabApplication;
import com.bio.domain.Profile;
import com.bio.domain.UserProfile;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.springframework.core.convert.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;

/**
 * This class use to convert String to Profile.class in @requestHeader in controllers
 */
@Service
public class StringToProfileConverter implements Converter<String, UserProfile> {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public UserProfile convert(String source) {
        try {
            return objectMapper.readValue(source, UserProfile.class);
        } catch (IOException ex) {
            throw new RuntimeException("Unable to convert user. Reason: " + ex.getMessage(), ex);
        }
    }
}
