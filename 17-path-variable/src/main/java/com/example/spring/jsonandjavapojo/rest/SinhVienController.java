package com.example.spring.jsonandjavapojo.rest;

import com.example.spring.jsonandjavapojo.entity.SinhVien;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/danhsachsinhvien")
public class SinhVienController {
    public List<SinhVien> danhSach;

    @PostConstruct
    public void createDanhSach() {
        danhSach = new ArrayList<SinhVien>();

        danhSach.add(new SinhVien(1, "nguyen van a", 20, "Cong nghe thong tin", 9));
        danhSach.add(new SinhVien(2, "nguyen thi b", 20, "Quan tri kinh doanh", 10));
        danhSach.add(new SinhVien(3, "tran van c", 20, "Ke toan", 8));
        danhSach.add(new SinhVien(4, "tran thi d", 20, "Cong nghe may", 9.5));
        danhSach.add(new SinhVien(5, "pham van e", 20, "Cong nghe thong tin", 7.5));
    }

    @GetMapping("/")
    public List<SinhVien> getDanhSach() {
        return danhSach;
    }

    @GetMapping("/{id}")
    public SinhVien getSinhVien(@PathVariable int id) {
        for (SinhVien sv : danhSach) {
            if (sv.getId() == id) {
                return sv;
            }
        }
        return null;
    }

    @GetMapping("/index/{index}")
    public SinhVien getSinhVienByIndex(@PathVariable int index) {
        SinhVien sinhVien = danhSach.get(index);
        return sinhVien;
    }
}
