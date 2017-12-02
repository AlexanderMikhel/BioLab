package com.bio.config;

import com.bio.BiolabApplication;
import com.bio.domain.Profile;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class StringToProfileConverter implements Converter<String,Profile>{

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Profile convert(String source) {
        try {
            Profile profile = objectMapper.readValue(source, Profile.class);

            setProfileIdIfEmpty(profile);

            return profile;
        } catch (IOException ex) {
            throw new RuntimeException("Unable to convert user. Reason: " + ex.getMessage(), ex);
        }
    }

    private void setProfileIdIfEmpty(Profile profile) {
        if (profile.getId() == null) {
            RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
            if (requestAttributes instanceof ServletRequestAttributes) {
                String profileId = ((ServletRequestAttributes) requestAttributes).getRequest().getHeader(BiolabApplication.PROFILE_ID_HEADER);
                profile.setId(Integer.parseInt(profileId));
            }
        }
    }
}
