package com.example.spring.onetoonenunidirectional;

import com.example.spring.onetoonenunidirectional.dao.TeacherDAO;
import com.example.spring.onetoonenunidirectional.dao.TeacherDetailDAO;
import com.example.spring.onetoonenunidirectional.entity.Teacher;
import com.example.spring.onetoonenunidirectional.entity.TeacherDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(TeacherDAO teacherDAO, TeacherDetailDAO teacherDetailDAO) {
        return runner -> {
          createTeacher(teacherDAO);
        };
    }

    private void createTeacher(TeacherDAO teacherDAO) {
        Teacher teacher = new Teacher();
        teacher.setFirstName("Tong");
        teacher.setLastName("Tran Thai");
        teacher.setEmail("Tranthaitong@gmail.com");

        TeacherDetail teacherDetail = new TeacherDetail();
        teacherDetail.setGender(true);
        teacherDetail.setAddress("Hanoi");
        teacherDetail.setYoutubeChannel("@3T_tv");

        // associate the object
        teacher.setTeacherDetail(teacherDetail);

        // save
        System.out.println("Saving teacher...");
        teacherDAO.save(teacher);
        System.out.println("Done!");
    }
}
