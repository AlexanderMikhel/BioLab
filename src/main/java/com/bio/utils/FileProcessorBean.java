/*
package com.bio.utils;

import com.bio.dao.FileProcessorBeanDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

*/
/**
 * @author Mikhel Alexander on 05.01.2018 email mikhelas@altarix.ru .
 *//*

@Component
@EnableConfigurationProperties
public class FileProcessorBean {

    @Value("${filePathPattern}")
    private String filenamePattern;

    @Autowired
    private FileProcessorBeanDAO fileProcessorBeanDAO;


    public String getDirectoryPath(Long directoryId,Long userId, String name){
        return filenamePattern+userId+"/"+fileProcessorBeanDAO.getPath(directoryId);
    }
}
*/

