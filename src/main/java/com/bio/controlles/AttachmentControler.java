package com.bio.controlles;

import com.bio.domain.Attachment;
import com.bio.domain.UserProfile;
import com.bio.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AttachmentControler {

    @Autowired
    AttachmentService attachmentService;

    @RequestMapping(method = RequestMethod.GET)
    List<Attachment> get(@RequestHeader(value = "Profile") UserProfile user,
                         @RequestParam(value = "ids", required = false) List<Integer> ids) {
        List<Integer> attachmentIds = new ArrayList<>();
        return attachmentIds.isEmpty() ? attachmentService.getAttachments(user.getId(), forMessages)
                : attachmentService.getAttachmentsById(attachmentIds);
    }

    @RequestMapping(method = RequestMethod.POST)
    Attachment create(@RequestHeader(value = "Profile") UserProfile user,
                      @RequestParam("files") List<MultipartFile> files) {
        if (files == null) {
            throw new RuntimeException();
        }
        return attachmentService.saveSpectraDataFromFiles(files, user.getUserId());

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    void delete(@RequestHeader(value = "Profile") UserProfile user,
                @PathVariable("id") Integer id) {
        attachmentService.deleteAttachment(id, user.getUserId());
    }

}
