package com.alamin_tanveer.supplychain.controller;


import com.alamin_tanveer.supplychain.entities.Attachment;
import com.alamin_tanveer.supplychain.repositories.AttachmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.util.Optional;

@Controller
@RequestMapping("/page/v1/user")
public class FileController {
    @Autowired
    private AttachmentRepo attachmentRepo;

    @GetMapping("/image-manual-response/{filename}")
    public void getImageAsByteArray(@PathVariable("filename") String filename, HttpServletResponse response) throws IOException {

        Optional<Attachment> attachment = attachmentRepo.findById(Long.valueOf(filename));

        File file = new File(attachment.get().getAttachmentPath());
        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }

        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
        response.setContentLength((int) file.length());
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }
}
