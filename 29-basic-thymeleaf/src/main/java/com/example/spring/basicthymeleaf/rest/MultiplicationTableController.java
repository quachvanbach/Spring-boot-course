package com.example.spring.basicthymeleaf.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MultiplicationTableController {

    @GetMapping("/hien-thi/{x}")
    public String hienThiBangCuuChuong(@PathVariable int x, Model model){
        model.addAttribute("number", x);

        // return tên file Thymeleaf
        return "bang-cuu-chuong";
    }
}
