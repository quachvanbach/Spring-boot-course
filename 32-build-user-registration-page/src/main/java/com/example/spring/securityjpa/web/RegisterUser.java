package com.example.spring.securityjpa.web;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

public class RegisterUser {
    @NotBlank(message = "Thông tin bắt buộc")
    @Size(min=1, message = "Độ dài tối thiểu là 1")
    private String username;
    @NotBlank(message = "Thông tin bắt buộc")
    @Size(min=8, message = "Độ dài tối thiểu là 8")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[@#$%^&+=!])(?!.*\\s).*$",
    message = "Mật khẩu phải bao gồm ít nhất một chữ cái, một số và một ký tự đặc biệt")
    private String password;
    @NotBlank(message = "Thông tin bắt buộc")
    private String firstName;
    @NotBlank(message = "Thông tin bắt buộc")
    private String lastName;
    @NotBlank(message = "Thông tin bắt buộc")
    @Email(message = "Email không hợp lệ")
    private String email;

    public RegisterUser() {
    }

    public RegisterUser(Long id, String username, String password, String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public RegisterUser(String username, String password, String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
