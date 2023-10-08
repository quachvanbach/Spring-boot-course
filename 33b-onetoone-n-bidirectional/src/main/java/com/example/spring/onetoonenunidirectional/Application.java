package com.example.spring.onetoonenunidirectional;

import com.example.spring.onetoonenunidirectional.dao.TeacherDAO;
import com.example.spring.onetoonenunidirectional.dao.TeacherDetailDAO;
import com.example.spring.onetoonenunidirectional.entity.Teacher;
import com.example.spring.onetoonenunidirectional.entity.TeacherDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(TeacherDAO teacherDAO, TeacherDetailDAO teacherDetailDAO) {
        return runner -> {
//          createTeacher(teacherDAO);
//            findTeacherById(teacherDAO, 1);
            findTeacherDetailById(teacherDetailDAO, 1);
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

    private void findTeacherById(TeacherDAO teacherDAO, int id) {
        Teacher teacher = teacherDAO.findTeacherById(id);
        System.out.println("Teacher: " + teacher);
        System.out.println("Teacher detail: " + teacher.getTeacherDetail());
    }

    private void findTeacherDetailById(TeacherDetailDAO teacherDetailDAO, int id) {
        TeacherDetail teacherDetail = teacherDetailDAO.findTeacherDetailById(id);
        System.out.println("Teacher detail: " + teacherDetail);
        System.out.println("Teacher: " + teacherDetail.getTeacher());
    }
}
