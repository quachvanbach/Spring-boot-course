package com.example.spring.securityjpa.controller;

import com.example.spring.securityjpa.dao.RoleRepository;
import com.example.spring.securityjpa.entity.Role;
import com.example.spring.securityjpa.entity.User;
import com.example.spring.securityjpa.service.UserService;
import com.example.spring.securityjpa.web.RegisterUser;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Controller
@RequestMapping("/register")
public class RegisterController {
    UserService userService;
    RoleRepository roleRepository;

    @Autowired
    public RegisterController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/showRegisterForm")
    public String showRegisterForm(Model model) {
        RegisterUser ru = new RegisterUser();
        model.addAttribute("registerUser", ru);
        return "register/form";
    }

    @InitBinder
    public void initBinder(WebDataBinder data) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        data.registerCustomEditor(String.class, stringTrimmerEditor);

    }

    @PostMapping("/process")
    public String process(@Valid @ModelAttribute RegisterUser registerUser,
                          BindingResult result,
                          Model model,
                          HttpSession session) {
        String username = registerUser.getUsername();

        // Form validation
        if (result.hasErrors()) {
            return "register/form";
        }

        // Kiểm tra user đã tồn tại:
        User userExisting = userService.findByUsername(username);
        if (userExisting != null) {
            model.addAttribute("registerUser", new RegisterUser());
            model.addAttribute("my_error", "Tài khoản đã tồn tại");
            return "register/form";
        }

        // Nếu chưa tồn tại thì lưu xuống:
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        User user = new User();
        user.setUsername(registerUser.getUsername());
        user.setPassword(bcrypt.encode(registerUser.getPassword()));
        user.setFirstName(registerUser.getFirstName());
        user.setLastName(registerUser.getLastName());
        user.setEmail(registerUser.getEmail());

        Role defaultRole = roleRepository.findByName("ROLE_USER");
        Collection<Role> roles = new ArrayList<>();
        roles.add(defaultRole);
        user.setRoles(roles);

        userService.save(user);

        // Thông báo đăng ký thành công:
        session.setAttribute("myUser", user);
        return "register/confirmation";
    }
}
