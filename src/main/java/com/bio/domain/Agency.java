package com.bio.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Agency {

    private Long id;
    private String name;
    private String address;
    private String phone;
    private String country;
    private String city;
    private Integer scienceGroupId;
    private ScienceGroup scienceGroup;

    public Integer getScienceGroupId() {
        return scienceGroupId;
    }

    public void setScienceGroupId(Integer scienceGroupId) {
        this.scienceGroupId = scienceGroupId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ScienceGroup getScienceGroup() {
        return scienceGroup;
    }

    public void setScienceGroup(ScienceGroup scienceGroup) {
        this.scienceGroup = scienceGroup;
    }

}
