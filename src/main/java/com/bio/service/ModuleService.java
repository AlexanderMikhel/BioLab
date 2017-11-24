package com.bio.service;

import com.bio.dao.ModuleDAO;
import com.bio.domain.Module;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {

    @Autowired
    private ModuleDAO moduleDAO;

    public List<Module> getList(Long projectId) {
        return moduleDAO.getList(projectId);
    }

    public Module getById(Long id) {
        return moduleDAO.getById(id);
    }

    public void add(Module module) {
        moduleDAO.add(module);
    }

    public Module update(Module module) {
        moduleDAO.update(module);
        return getById(module.getId());
    }

    public void delete(Long id){moduleDAO.delete(id);}

}
