package com.bio.domain;

import java.util.List;

/**
 * @author Mikhel Alexander on 03.01.2018 email mikhelas@altarix.ru .
 */
public class Directory {

    private Long id;
    private String name;
    private Long parentId;
    private Long userId;

    private List<Spectra> spectras;
    private List<Attachment> attachments;


    public List<Spectra> getSpectras() {
        return spectras;
    }

    public void setSpectras(List<Spectra> spectras) {
        this.spectras = spectras;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
