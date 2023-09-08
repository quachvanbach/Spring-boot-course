package com.example.spring.hibernatejpa.common;

import com.example.spring.hibernatejpa.dao.SinhVienDAOImpl;
import com.example.spring.hibernatejpa.entity.SinhVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Scanner;

@Configuration
public class MyConfiguration {
    @Bean
    @Autowired
    public CommandLineRunner getRunner(SinhVienDAOImpl sinhVienDAOImpl) {
        return runner -> {
            Scanner sc = new Scanner(System.in);
            while (true) {
                inMenu();
                int luaChon = sc.nextInt();
                sc.nextLine();
                if (luaChon == 1) {
                    themSinhVien(sinhVienDAOImpl, sc);
                } else if (luaChon == 2) {
                    timSinhVien(sinhVienDAOImpl, sc);
                } else if (luaChon == 3) {
                    timSinhVienTheoTen(sinhVienDAOImpl, sc);
                } else if (luaChon == 4) {
                    inTatCaSinhVien(sinhVienDAOImpl, sc);
                } else if (luaChon == 5) {
                    capNhatSinhVienTheoId(sinhVienDAOImpl, sc);
                } else if (luaChon == 6) {
                    capNhatToanBoTenSinhVien(sinhVienDAOImpl, sc);
                } else if (luaChon == 7) {
                    xoaSinhVienTheoId(sinhVienDAOImpl, sc);
                }
            }
        };

    }

    private static void themSinhVien(SinhVienDAOImpl sinhVienDAO, Scanner sc) {
        System.out.println("Nhập họ đệm: ");
        String hoDem = sc.nextLine();
        System.out.println("Nhập tên: ");
        String ten = sc.nextLine();
        System.out.println("Nhập email: ");
        String email = sc.nextLine();
        SinhVien sinhVien = new SinhVien(hoDem, ten, email);

        sinhVienDAO.save(sinhVien);
    }

    private void timSinhVien(SinhVienDAOImpl sinhVienDAOImpl, Scanner sc) {
        System.out.println("Nhập mã Sinh Viên");
        int id = sc.nextInt();
        SinhVien sinhVien = sinhVienDAOImpl.getById(id);
        if (sinhVien == null) {
            System.out.println("Không tìm thấy!");
        } else {
            System.out.println(sinhVien);
        }
    }

    private void timSinhVienTheoTen(SinhVienDAOImpl sinhVienDAOImpl, Scanner sc) {
        System.out.println("Nhập tên sinh viên");
        String ten = sc.nextLine();
        List<SinhVien> sinhVienList = sinhVienDAOImpl.getByTen(ten);
        if (sinhVienList.size() == 0) {
            System.out.println("Không tìm thấy!");
        } else {
            sinhVienList.forEach(sinhVien -> {
                System.out.println(sinhVien);
            });
        }
    }

    private void inTatCaSinhVien(SinhVienDAOImpl sinhVienDAOImpl, Scanner sc) {
        List<SinhVien> sinhVienList = sinhVienDAOImpl.getAll();
        sinhVienList.forEach(sinhVien -> {
            System.out.println(sinhVien);
        });
    }

    private void capNhatSinhVienTheoId(SinhVienDAOImpl sinhVienDAOImpl, Scanner sc) {
        System.out.println("Nhập mã Sinh viên: ");
        int id = sc.nextInt();
        sc.nextLine();
        SinhVien sinhVien = sinhVienDAOImpl.getById(id);
        if (sinhVien == null) {
            System.out.println("Không tìm thấy sinh viên");
        } else {
            System.out.println("Nhập họ đệm: ");
            String hoDem = sc.nextLine();
            System.out.println("Nhập tên: ");
            String ten = sc.nextLine();
            System.out.println("Nhập email: ");
            String email = sc.nextLine();
            sinhVien.setHoDem(hoDem);
            sinhVien.setTen(ten);
            sinhVien.setEmail(email);
            sinhVienDAOImpl.update(sinhVien);
        }

    }

    private void capNhatToanBoTenSinhVien(SinhVienDAOImpl sinhVienDAOImpl, Scanner sc) {
        System.out.println("Nhập tên Sinh viên");
        String ten = sc.nextLine();
        int rows = sinhVienDAOImpl.updateAllTen(ten);
        System.out.println("Có " + rows + " đã bị thay đổi tên");
    }

    private void xoaSinhVienTheoId(SinhVienDAOImpl sinhVienDAOImpl, Scanner sc) {
        System.out.println("Nhập id Sinh viên: ");
        int id = sc.nextInt();
        sinhVienDAOImpl.deleteSinhVien(id);
    }

    public void inMenu() {
        System.out.println("================================================");
        System.out.println("Menu: \n"
                + "1. Thêm sinh viên\n"
                + "2. Tìm sinh viên theo id\n"
                + "3. Tìm sinh viên theo tên\n"
                + "4. Hiển thị toàn bộ danh sách sinh viên\n"
                + "5. Cập nhật sinh viên theo id\n"
                + "6. Cập nhật toàn bộ tên của sinh viên\n"
                + "7. Xoá sinh viên theo Id\n"
                + "Lựa chọn: ");
    }
}
