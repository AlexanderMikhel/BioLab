package com.bio.service;


import com.bio.dao.AgencyDAO;
import com.bio.domain.Agency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyService {

    @Autowired
    private AgencyDAO agencyDAO;

    public Agency getAgencyById(Long id) {
        return agencyDAO.getAgencyById(id);
    }

    public List<Agency> getList(Long profileId) {
        return agencyDAO.getList(profileId);
    }

    public void add(Agency agency) {
        agencyDAO.add(agency);
    }

    public Agency update(Agency agency) {
        agencyDAO.update(agency);
        return getAgencyById(agency.getId());
    }

    public void delete(Long id) {
        agencyDAO.delete(id);
    }
}
