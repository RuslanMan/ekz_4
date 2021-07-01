package ru.ruslan.project.avito.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.ruslan.project.avito.models.User;
import ru.ruslan.project.avito.repositories.UsersRepository;
import ru.ruslan.project.avito.security.details.UserDetailsImpl;
import ru.ruslan.project.avito.services.ProfileService;
import ru.ruslan.project.avito.services.SignUpService;
import ru.ruslan.project.avito.services.UsersService;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private UsersService usersService;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/profile")
    public String getProfilePage(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        model.addAttribute("user", usersService.find(user.getUsername()));
        return "profile_page";
    }
    @PostMapping("/profile")
    public String postProfilePage(@RequestParam("file") MultipartFile file) throws IOException {
        if (file != null) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }



            file.transferTo(new File(uploadPath + "/" + file.getOriginalFilename()));

            profileService.update(file.getOriginalFilename());
        }
        return "redirect:/profile";
    }
}
