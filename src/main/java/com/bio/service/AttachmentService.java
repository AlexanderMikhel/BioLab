package com.bio.service;

import com.bio.dao.AttachmentDAO;
import com.bio.domain.Attachment;
import com.bio.domain.Spectra;
import com.bio.utils.AttachmentProcessorBean;
import com.bio.utils.SpectraFileReader;
import com.bio.utils.StringConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class AttachmentService {

   /* @Autowired
    private AttachmentDAO attachmentDAO;

    @Autowired
    private AttachmentProcessorBean attachmentProcessorBean;


    @Transactional
    public Attachment create(MultipartFile file, Long directoryId,Long userId) {

        Attachment attachment = new Attachment();
        attachment.setFileFileName(file.getOriginalFilename());
        attachment.setId(attachmentDAO.getAttachmentId());
        attachment.setFileContentType(file.getContentType());
        attachment.setFileFileSize(file.getSize());
        attachment.setDirectoryId(directoryId);
        attachmentDAO.add(attachment);
        attachmentProcessorBean.processAttachment(attachment);

        File outputFile = new File(attachment.getPath());
        outputFile.mkdirs();

        try (BufferedInputStream reader = new BufferedInputStream(file.getInputStream())) {
            Files.copy(reader, Paths.get(filestorage + attachment.getPath()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RestException("Произошла ошибка при сохранении файла", e);
        }

        return attachment;
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
    }*/
}
