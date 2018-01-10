package com.bio.domain;
import java.util.Date;

public class Attachment {
    private Long id;
    private String fileFileName;
    private String fileContentType;
    private Long fileFileSize;
    private Long directoryId;
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getDirectoryId() {
        return directoryId;
    }

    public void setDirectoryId(Long directoryId) {
        this.directoryId = directoryId;
    }
}
