package com.bio.controlles;

import com.bio.domain.Spectra;
import com.bio.domain.UserProfile;
import com.bio.service.AttachmentService;
import com.bio.service.SpectraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author Mikhel Alexander on 03.01.2018 email mikhelas@altarix.ru .
 */

@RestController
@RequestMapping("/spectras")
public class SpectraController {

    @Autowired
    SpectraService spectraService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Spectra get(@RequestHeader(value = "Profile") UserProfile user,
                @PathVariable Long id) throws IOException {
        return spectraService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    List<Spectra> getList(@RequestHeader(value = "Profile") UserProfile user,
                    @RequestParam("ids") List<Long> ids) throws IOException {
        return spectraService.getList(ids);
    }

    @RequestMapping(method = RequestMethod.POST)
    void create(@RequestHeader(value = "Profile") UserProfile user,
                @RequestParam("files") List<MultipartFile> files) {
        if (files == null) {
            throw new RuntimeException();
        }
        try {
            spectraService.saveSpectraDataFromFiles(files, user.getProfileId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
