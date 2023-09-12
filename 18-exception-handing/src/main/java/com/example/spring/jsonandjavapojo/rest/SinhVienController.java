package com.example.spring.jsonandjavapojo.rest;

import com.example.spring.jsonandjavapojo.entity.ThongBaoLoi;
import com.example.spring.jsonandjavapojo.entity.SinhVien;
import com.example.spring.jsonandjavapojo.exception.SinhVienException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        SinhVien result = null;
        for (SinhVien sv : danhSach) {
            if (sv.getId() == id) {
                return sv;
            }
        }
        if (result == null)
            throw new SinhVienException("Khong tim thay sinh vien co id la " + id);
        return result;
    }

    @GetMapping("/index/{index}")
    public SinhVien getSinhVienByIndex(@PathVariable int index) {
        SinhVien result;
        try {
            result = danhSach.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new SinhVienException("Khong tim thay sinh vien co index la " + index);
        }
        return result;
    }

    @ExceptionHandler
    public ResponseEntity<ThongBaoLoi> catchNotFoundError(SinhVienException ex) {
        ThongBaoLoi thongBaoLoi = new ThongBaoLoi(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(thongBaoLoi);
    }
    @ExceptionHandler
    public ResponseEntity<ThongBaoLoi> catchBadRequestError(Exception ex) {
        ThongBaoLoi thongBaoLoi = new ThongBaoLoi(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(thongBaoLoi);
    }
}