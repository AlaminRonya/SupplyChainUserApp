package com.alamin_tanveer.supplychain.service;

import com.alamin_tanveer.supplychain.entities.Attachment;
import com.alamin_tanveer.supplychain.repositories.AttachmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttachmentService {
    @Autowired
    private AttachmentRepo attachmentRepo;

    public Attachment addAttachment(Attachment attachment){
        return insert(attachment);
    }

    private Attachment insert(Attachment attachment){
        return attachmentRepo.save(attachment);
    }

    private Attachment searchById(Long id){
        return attachmentRepo.findById(id).orElse(null);
    }

    public void updateAttachmentById(Long id, String attachmentName){
        attachmentRepo.updateAttachmentById(id, attachmentName);
    }

}
