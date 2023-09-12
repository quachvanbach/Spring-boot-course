package com.example.spring.jsonandjavapojo.exception;

import com.example.spring.jsonandjavapojo.entity.SinhVien;
import com.example.spring.jsonandjavapojo.entity.ThongBaoLoi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler()
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
