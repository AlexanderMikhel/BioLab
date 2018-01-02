package com.bio.controlles;

import com.bio.domain.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AttachmentControler {

    @Autowired
    AttachmentsRepository attachmentsRepository;

    @Autowired
    private MessageService messageService;

    @ApiOperation(value = "Получить список доступных файлов", response = Attachment.class, responseContainer = "List")
    @RequestMapping(method = RequestMethod.GET)
    List<Attachment> get(@RequestHeader(value = USER_HEADER) UserProfile user,
                         @RequestParam(value = "for_messages", required = false) Boolean forMessages,
                         @RequestParam(value = "ids", required = false) String ids) {
        List<Integer> attachmentIds = new ArrayList<>();
        if (isNotBlank(ids)) {
            Arrays.stream(ids.split(",")).forEach(id -> attachmentIds.add(Integer.valueOf(id)));
        }
        return attachmentIds.isEmpty() ? attachmentsRepository.getAttachments(user.getId(), forMessages)
                : attachmentsRepository.getAttachmentsById(attachmentIds);
    }

    @ApiOperation(value = "Загрузить файл", response = Attachment.class)
    @RequestMapping(method = RequestMethod.POST)
    Attachment create(@RequestHeader(value = USER_HEADER) UserProfile user,
                      @RequestParam(value = "for_messages", defaultValue = "false") Boolean forMessages,
                      @RequestPayload MultipartFile file) {
        if (file == null) {
            throw new RestException(messageService.getMessage("error.not-found.create-attachment"));
        }
        return attachmentsRepository.create(file, user.getId(), forMessages);

    }

    @ApiOperation(value = "Удалить файл")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    void delete(@RequestHeader(value = USER_HEADER) UserProfile user,
                @PathVariable("id") Integer id) {
        attachmentsRepository.deleteAttachment(id, user.getId());
    }

}
