package com.example.spring.account_ms.controller;

import com.example.spring.account_ms.Utils.DateUtils;
import com.example.spring.account_ms.entity.*;
import com.example.spring.account_ms.service.ManagedAccountService;
import com.example.spring.account_ms.service.GmailService;
import com.example.spring.account_ms.service.PhonenumberService;
import com.example.spring.account_ms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class AppController {
    private final UserService userService;
    private ManagedAccountService managedAccountService;
    private PhonenumberService phonenumberService;
    private GmailService gmailService;

    @Autowired
    public AppController(UserService userService, ManagedAccountService managedAccountService, GmailService gmailService) {
        this.userService = userService;
        this.managedAccountService = managedAccountService;
        this.gmailService = gmailService;
    }

    @GetMapping("/account_list")
    public String accountList(Principal principal, Model model) {
        User user = userService.getByUsername(principal.getName());
        List<ManagedAccount> accountList = user.getManagedAccount();
        model.addAttribute("accountList", accountList);
        return "app/account_management";
    }

    @GetMapping("/add_new")
    public String addNew(Principal principal, Model model) {
        User user = userService.getByUsername(principal.getName());
        ManagedAccount managedAccount = new ManagedAccount();
        model.addAttribute("managedAccount", managedAccount);
        return "/app/account-form";
    }

    @PostMapping("/save")
    public String save(Principal principal, @ModelAttribute("managedAccount") ManagedAccount managedAccount
    ) {
        System.out.println("Id cua tai khoan la: " + managedAccount.getId());
        System.out.println("Id cua tai khoan la: " + managedAccount.getUsername());
        User user = userService.getByUsername(principal.getName());
        managedAccount.setUser(user);
        if (managedAccount.getId() == null) {
            managedAccountService.save(managedAccount);
        } else {
            managedAccountService.update(managedAccount);
        }

        return "redirect:/app/account_list";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") Integer id, Model model) {
        ManagedAccount managedAccount = managedAccountService.getById(id);
        model.addAttribute("managedAccount", managedAccount);
        return "/app/account-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        managedAccountService.deleteById(id);
        return "redirect:/app/account_list";
    }
}
