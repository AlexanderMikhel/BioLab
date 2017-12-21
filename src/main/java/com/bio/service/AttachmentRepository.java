package com.bio.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class AttachmentRepository {

    @Transactional
    public Attachment create(MultipartFile file, Integer userId, Boolean forMessages) {

        Attachment attachment = new Attachment();
        attachment.setFileFileName(file.getOriginalFilename());
        attachment.setId(attachmentsDAO.getAttachmentId());
        attachment.setFileContentType(file.getContentType());
        attachment.setFileFileSize(file.getSize());
        attachment.setUserId(userId);

        attachmentProcessorBean.processAttachment(attachment);

        if (forMessages != null && forMessages) {
            attachment.setResourceType("Mailboxer::Notification");
        }

        attachmentsDAO.createAttachment(attachment);
        Integer idFileStorage = attachmentsDAO.getFileStorage(userId);
        if (idFileStorage == null) {
            idFileStorage = attachmentsDAO.getFileStorageId();
            attachmentsDAO.createFileStorage(idFileStorage, userId);
        }
        attachmentsDAO.createFileStorageEntries(attachment.getId(), idFileStorage);

        File outputFile = new File(filestorage + attachment.getPath());
        outputFile.mkdirs();

        try (BufferedInputStream reader = new BufferedInputStream(file.getInputStream())) {
            Files.copy(reader, Paths.get(filestorage + attachment.getPath()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RestException("Произошла ошибка при сохранении файла", e);
        }

        return attachment;
    }


    public List<Attachment> getAttachments(Integer userId, Boolean forMessages) {
        List<Attachment> attachments = attachmentsDAO.getAttachments(userId, forMessages);
        for (Attachment attachment : attachments) {
            attachmentProcessorBean.processAttachment(attachment);
        }
        return attachments;
    }

    public void deleteAttachment(Integer id, Integer userId) {
        Attachment attachment = attachmentsDAO.getAttachmentById(id);
        attachmentProcessorBean.processAttachment(attachment);
        attachmentsDAO.deleteFileStorageEntries(id, userId);
        if (!attachmentsDAO.existenceOfLink(id)) {
            File fileToDelete = new File(filestorage + attachment.getPath());
            FileSystemUtils.deleteRecursively(fileToDelete.getParentFile().getParentFile());
            attachmentsDAO.deleteAttachment(id);
        }
    }

    public List<Attachment> getAttachmentsById(List<Integer> ids) {
        List<Attachment> attachments = attachmentsDAO.getAttachmentsById(ids);
        for (Attachment attachment : attachments) {
            attachmentProcessorBean.processAttachment(attachment);
        }
        return attachments;
    }
}
