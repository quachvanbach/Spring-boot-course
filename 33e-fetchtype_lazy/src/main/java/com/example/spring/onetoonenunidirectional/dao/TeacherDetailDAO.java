package com.example.spring.onetoonenunidirectional.dao;

import com.example.spring.onetoonenunidirectional.entity.Teacher;
import com.example.spring.onetoonenunidirectional.entity.TeacherDetail;

public interface TeacherDetailDAO {
    public void save(TeacherDetail teacherDetail);
    public TeacherDetail findTeacherDetailById(int id);
    public void deleteTeacherDetailById(int id);
}
