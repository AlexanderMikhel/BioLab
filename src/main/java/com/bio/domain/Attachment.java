package com.bio.domain;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.Date;

public class Attachment {

    private String fileFileName;
    private String fileContentType;
    private Long fileFileSize;
    private Date fileUpdatedAt;
    private Integer userId;
    private Integer resourceId;
    private String resourceType;
    private String type;
    private Integer subjectId;
    private Integer classLevelId;
    private Integer educationLevelId;
    private String topic;
    private String keywords;
    private String genre;
    private String path;

    public String getFileFileName() {
        return fileFileName;
    }


    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public Long getFileFileSize() {
        return fileFileSize;
    }

    public void setFileFileSize(Long fileFileSize) {
        this.fileFileSize = fileFileSize;
    }

    public Date getFileUpdatedAt() {
        return fileUpdatedAt;
    }

    public void setFileUpdatedAt(Date fileUpdatedAt) {
        this.fileUpdatedAt = fileUpdatedAt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getClassLevelId() {
        return classLevelId;
    }

    public void setClassLevelId(Integer classLevelId) {
        this.classLevelId = classLevelId;
    }

    public Integer getEducationLevelId() {
        return educationLevelId;
    }

    public void setEducationLevelId(Integer educationLevelId) {
        this.educationLevelId = educationLevelId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
