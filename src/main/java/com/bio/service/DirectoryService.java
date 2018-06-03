/*
package com.bio.service;

import com.bio.dao.DirectoryDAO;
import com.bio.domain.Directory;
import com.bio.utils.FileProcessorBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

*/
/**
 * @author Mikhel Alexander on 05.01.2018 email mikhelas@altarix.ru .
 *//*

@Service
public class DirectoryService {

    @Autowired
    private DirectoryDAO directoryDAO;

    @Autowired
    private FileProcessorBean fileProcessorBean;

    public List<Directory> getList(Long userId,List<Long> ids, Long parentDirectoryId){
        return directoryDAO.getList(userId,ids,parentDirectoryId);
    }

    public Directory get(Long id){
      return directoryDAO.get(id);
    }

    public Directory add(Directory directory){
        Long id = directoryDAO.add(directory);
        String path = fileProcessorBean.getDirectoryPath(id,directory.getUserId(),directory.getName());
        File outputFile = new File(path);
        outputFile.mkdirs();
        return directoryDAO.get(id);
    }

    */
/**
     * дорабатывать
     * @param id
     *//*

    public void delete(Long id){
       directoryDAO.delete(id);

    }


    public Directory update(Directory directory){
        directoryDAO.update(directory);
        String path = fileProcessorBean.getDirectoryPath(directory.getId(),directory.getUserId(),directory.getName());
        File file = new File(path);
        file.renameTo(new File(directory.getName()));
        return directoryDAO.get(directory.getId());
    }

}
*/
