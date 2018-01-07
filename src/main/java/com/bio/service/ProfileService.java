package com.bio.service;

import com.bio.dao.ProfileDAO;
import com.bio.domain.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private ProfileDAO profileDAO;

    public Profile getProfileById(Long id) {
        return profileDAO.getProfileById(id);
    }

    public List<Profile> getList(){return profileDAO.getList();}

    public void add (Profile profile){ profileDAO.add(profile);}

    public Profile update(Profile profile){
        profileDAO.update(profile);
        return getProfileById(profile.getId());
    }

    public void delete(Long id){profileDAO.delete(id);}

}
