package com.bio.service;

import com.bio.dao.ScienceGroupDAO;
import com.bio.domain.ScienceGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScienceGroupService {

    @Autowired
    private ScienceGroupDAO scienceGroupDAO;

    public List<ScienceGroup> getList() {
        List<ScienceGroup> L = scienceGroupDAO.getList();
        return L;
    }

    public ScienceGroup getById(Long id) {
        return scienceGroupDAO.getScienceGroupById(id);
    }

    public void add(ScienceGroup project) {
        scienceGroupDAO.add(project);
    }

    public ScienceGroup update(ScienceGroup project) {
        scienceGroupDAO.update(project);
        return getById(project.getId());
    }

    public void delete(Long id) {
        scienceGroupDAO.delete(id);
    }
}
