package com.bio.controlles;

import com.bio.domain.Attachment;
import com.bio.domain.Spectra;
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
public class AttachmentController {

    /*@Autowired
    AttachmentService attachmentService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Attachment get(@RequestHeader(value = "Profile") UserProfile user,
                   @PathVariable Long id) throws IOException {
        return attachmentService.get(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    void add(@RequestHeader(value = "Profile") UserProfile user,
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

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@RequestHeader(value = "Profile") UserProfile user,
                      @PathVariable Long id){
        return attachmentService.delete(id);
    }*/

}
