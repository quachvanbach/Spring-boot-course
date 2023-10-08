package com.example.spring.onetoonenunidirectional;

import com.example.spring.onetoonenunidirectional.dao.CourseDAO;
import com.example.spring.onetoonenunidirectional.dao.TeacherDAO;
import com.example.spring.onetoonenunidirectional.dao.TeacherDetailDAO;
import com.example.spring.onetoonenunidirectional.entity.Course;
import com.example.spring.onetoonenunidirectional.entity.Teacher;
import com.example.spring.onetoonenunidirectional.entity.TeacherDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(TeacherDAO teacherDAO, TeacherDetailDAO teacherDetailDAO, CourseDAO courseDAO) {
        return runner -> {
//            createTeacher(teacherDAO);
//            findTeacherById(teacherDAO, 1);
//            findTeacherDetailById(teacherDetailDAO, 1);
//            createCourse(teacherDAO, courseDAO);

//            findTeacherWithCourse(teacherDAO, 1);
//            findTeacherWithCourse(teacherDAO, 3);

//            findTeacherWithCourse_lazy(teacherDAO, courseDAO, 1);
//            System.out.println("*****************************************************");
//            findTeacherWithCourse_lazy(teacherDAO, courseDAO, 3);

            findTeacherWithCourse_lazy_joinFetch(teacherDAO, 1);
            findTeacherWithCourse_lazy_joinFetch(teacherDAO, 2);
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

    private void createCourse(TeacherDAO teacherDAO, CourseDAO courseDAO) {
        Teacher teacher = new Teacher();
        teacher.setFirstName("Bang");
        teacher.setLastName("Nguyen Luong");
        teacher.setEmail("Nguyenluongbang@gmail.com");

        TeacherDetail teacherDetail = new TeacherDetail();
        teacherDetail.setGender(true);
        teacherDetail.setAddress("Hai Duong");
        teacherDetail.setYoutubeChannel("@nlb_tv");
        teacher.setTeacherDetail(teacherDetail);

        List<Course> courses = new ArrayList<>();
        Course course1 = new Course("Spring Hibernate", "Description", null, null);
        Course course2 = new Course("Java core", "Description", null, null);
        Course course3 = new Course("Fullstack", "Description", null, null);

//        courses.add(course1);
//        courses.add(course2);
//        courses.add(course3);

        teacher.addCourse(course1);
        teacher.addCourse(course2);
        teacher.addCourse(course3);

        System.out.println("Updating teacher...");
        teacherDAO.update(teacher);
        System.out.println("Done..");
    }

    private void findTeacherWithCourse(TeacherDAO teacherDAO, int id) {
        Teacher teacher = teacherDAO.findTeacherById(id);
        System.out.println("Teacher's information: ");
        System.out.println(teacher);
        System.out.println("List of course: ");
        System.out.println(teacher.getCourses());
    }

    private void findTeacherWithCourse_lazy(TeacherDAO teacherDAO, CourseDAO courseDAO, int id) {
        System.out.println(" ------ Teacher's information ------");
        Teacher teacher = teacherDAO.findTeacherById(id);
        System.out.println(teacher);

        System.out.println("------ List of course ------");
        List<Course> courses = courseDAO.findCourseByTeacherId(id);
        teacher.setCourses(courses);
        System.out.println(teacher.getCourses());
    }

    private void findTeacherWithCourse_lazy_joinFetch(TeacherDAO teacherDAO, int id) {
        Teacher teacher = teacherDAO.findTeacherByIdJoinFetch(id);
        System.out.println("Teacher's information: ");
        System.out.println(teacher);
        System.out.println("List of course: ");
        System.out.println(teacher.getCourses());
    }
}
