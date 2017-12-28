package com.bio.controlles;

import com.bio.domain.Attachment;
import com.bio.domain.UserProfile;
import com.bio.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/attachments")
public class AttachmentControler {

    @Autowired
    AttachmentService attachmentService;

    @RequestMapping(method = RequestMethod.POST)
    void create(@RequestHeader(value = "Profile") UserProfile user,
                @RequestParam("files") List<MultipartFile> files) {
        if (files == null) {
            throw new RuntimeException();
        }
        try {
            attachmentService.saveSpectraDataFromFiles(files, user.getProfileId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
