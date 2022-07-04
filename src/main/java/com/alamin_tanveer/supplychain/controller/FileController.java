package com.alamin_tanveer.supplychain.controller;

import com.alamin_tanveer.supplychain.utils.Constant;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/api/page/v1")
public class FileController {
    @Autowired
    private ServletContext servletContext;

    @GetMapping("/image-manual-response/{filename}")
    public void getImageAsByteArray(@PathVariable("filename") String filename, HttpServletResponse response) throws IOException {
        InputStream in = servletContext.getResourceAsStream(Constant.USER_UPLOAD_PROFILE +filename);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }
}
