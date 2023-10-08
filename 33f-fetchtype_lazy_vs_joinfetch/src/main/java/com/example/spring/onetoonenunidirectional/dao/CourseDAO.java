package com.example.spring.onetoonenunidirectional.dao;

import com.example.spring.onetoonenunidirectional.entity.Course;

import java.util.List;

public interface CourseDAO {
    public void save(Course course);
    public List<Course> findCourseByTeacherId(int teacherId);
}
