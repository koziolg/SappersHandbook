package pl.handbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.handbook.entity.Admin;
import pl.handbook.repository.AdminRepository;
import pl.handbook.security.UserPrincipal;

import javax.validation.Valid;

@Component
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @GetMapping("/register")
    public String register(Model m) {
        m.addAttribute("admin", new Admin());
        return "admin/register";
    }

    @PostMapping("/register")
    public String saveAdmin(@Valid Admin admin, BindingResult result) {
        if (result.hasErrors()) {
            return "user/register";
        }
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminRepository.save(admin);
        return "redirect:/";

    }
//
    @GetMapping("/login")
    public String index() {
        return "admin/login";
    }

//    @PostMapping("/login")
//    public String login(@ModelAttribute Admin admin) {
//        if (admin.getName().length() > 0 && admin.getPassword().length() > 0) {
//            Admin adminLog = adminRepository.findByName(admin.getName());
//            if (adminLog.getName() != null && adminLog.getPassword() == passwordEncoder.encode(admin.getPassword()));{
//
//
//            }
//        }
//        return "redirect:/";
//    }

    @GetMapping("/test")

    public String testAdmin(@AuthenticationPrincipal UserPrincipal admin){
        return "redirect:/";
    }
}
