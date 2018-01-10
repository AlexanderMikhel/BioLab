package com.bio.service;

import com.bio.dao.DirectoryDAO;
import com.bio.domain.Directory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Mikhel Alexander on 05.01.2018 email mikhelas@altarix.ru .
 */
@Component
public class DirectoryService {

    @Autowired
    private DirectoryDAO directoryDAO;

    public List<Directory> getList(Long userId,List<Long> ids, Long parentDirectoryId){
        return directoryDAO.getList(userId,ids,parentDirectoryId);
    }

    public Directory get(Long id){
      return directoryDAO.get(id);
    }

    public Directory add(Directory directory){
        Long id = directoryDAO.add(directory);
        return directoryDAO.get(id);
    }

    public void delete(Long id){
       directoryDAO.delete(id);
    }

    public Directory update(Directory directory){
        directoryDAO.update(directory);
        return directoryDAO.get(directory.getId());
    }

}
