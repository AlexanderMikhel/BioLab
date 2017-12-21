package com.bio.domain;

import java.util.List;

public class UserProfile {

    private Integer userId;
    private Integer profileId;
    private Integer AgencyId;
    private String Type;
    private List<String> roles;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

    public Integer getAgencyId() {
        return AgencyId;
    }

    public void setAgencyId(Integer agencyId) {
        AgencyId = agencyId;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
