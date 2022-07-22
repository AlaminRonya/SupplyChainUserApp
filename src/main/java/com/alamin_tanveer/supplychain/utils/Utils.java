package com.alamin_tanveer.supplychain.utils;

import com.alamin_tanveer.supplychain.entities.Attachment;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class Utils {


    public static Attachment saveImage(MultipartFile file, String path) throws IOException {

        if (!file.isEmpty()){
            String filePath = path + file.getOriginalFilename();
            file.transferTo(new File(filePath));
            Attachment attachment = new Attachment();
            attachment.setAttachmentName(file.getOriginalFilename());
            attachment.setAttachmentPath(filePath);
            attachment.setAttachmentType(file.getContentType());
            return attachment;
        }else {
            return null;
        }
    }

    public static Attachment saveFile(MultipartFile file, String path) throws IOException {

        if (!file.isEmpty()){
            String filePath = path + file.getOriginalFilename();

            try {
                Files.write(Path.of(filePath), file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
//            file.transferTo(new File(filePath));
            Attachment attachment = new Attachment();
            attachment.setAttachmentName(file.getOriginalFilename());
            attachment.setAttachmentPath(filePath);
            attachment.setAttachmentType(file.getContentType());
            return attachment;
        }else {
            return null;
        }
    }




}
