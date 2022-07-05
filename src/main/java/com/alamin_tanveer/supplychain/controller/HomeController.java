package com.alamin_tanveer.supplychain.controller;

import com.alamin_tanveer.supplychain.entities.Attachment;
import com.alamin_tanveer.supplychain.registration.RegistrationRequest;
import com.alamin_tanveer.supplychain.registration.RegistrationService;
import com.alamin_tanveer.supplychain.repositories.AttachmentRepo;
import com.alamin_tanveer.supplychain.utils.Constant;
import com.alamin_tanveer.supplychain.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;


@Controller
@RequestMapping("/api/page/v1")
public class HomeController {

    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private AttachmentRepo attachmentRepo;

    @GetMapping("/home")
    public String page(){
        return "home";
    }

    @GetMapping("/user/add")
    public String getRegistration(@ModelAttribute("registrationRequest")RegistrationRequest registrationRequest){
        return "registration";
    }
    @PostMapping("/user/add")
    public String userRegistration( @ModelAttribute("registrationRequest")RegistrationRequest registrationRequest, @RequestParam("profile") MultipartFile profile,
                                    @RequestParam("upload_file") MultipartFile document, HttpSession session) throws IOException {
        final String realPath = session.getServletContext().getRealPath("/");
        String profilePath = realPath+Constant.USER_UPLOAD_PROFILE;

        Attachment attachment = Utils.saveFile(profile, profilePath);
        final Attachment save = attachmentRepo.save(attachment);


        final String email = registrationService.register(registrationRequest);
        System.out.println("==========> "+email);
        return "redirect:/api/page/v1/home";
    }

    @GetMapping("/show/{id}")
    public String getShow(Model model, @PathVariable("id")String id) throws FileNotFoundException {
        final Optional<Attachment> byId = attachmentRepo.findById(Long.parseLong(id));
        if (byId.isPresent()){
            model.addAttribute("attachment",byId);
        }

        return "show";
    }
}
