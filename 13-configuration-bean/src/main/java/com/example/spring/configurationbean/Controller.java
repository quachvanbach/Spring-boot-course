package com.example.spring.configurationbean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private Calculator myCalculator;

    public Controller(@Qualifier("getCalculator") Calculator myCalculator) {
        this.myCalculator = myCalculator;
    }

    @GetMapping("/canbachai")
    public String tinhCanBacHai(@RequestParam("value") double x) {
        return "Can bac hai cua " + x + " la: " + myCalculator.canBacHai(x);
    }
    @GetMapping("/binhphuong")
    public String tinhBinhPhuong(@RequestParam("value") double x) {
        return "Binh phuong cua " + x + " la: " + myCalculator.binhPhuong(x);
    }
}
