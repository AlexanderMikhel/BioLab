package com.bio.utils;

import com.bio.domain.Attachment;
import com.bio.domain.Directory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Mikhel Alexander on 05.01.2018 email mikhelas@altarix.ru .
 */
@Component
@EnableConfigurationProperties
public class AttachmentProcessorBean {

    @Value("${attachment.filenamePattern}")
    private String filenamePattern;

    /*public void processAttachment(Directory directory) {
        String idWithPadding = String.format("%09d", attachment.getId())+methodName;
        String[] splitted = idWithPadding.split("(?<=\\G.{3})");
        String filePath = String.format(filenamePattern, splitted[0], splitted[1], splitted[2], attachment.getFileFileName());
        attachment.setPath(filePath);
        attachment.setPath(filePath);
    }*/
}

