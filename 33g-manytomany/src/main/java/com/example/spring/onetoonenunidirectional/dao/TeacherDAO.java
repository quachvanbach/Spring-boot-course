package com.example.spring.onetoonenunidirectional.dao;

import com.example.spring.onetoonenunidirectional.entity.Teacher;

public interface TeacherDAO {
    public void save(Teacher teacher);

    public Teacher findTeacherById(int id);

    public void deleteTeacherById(int id);

    public void update(Teacher teacher);

    public Teacher findTeacherByIdJoinFetch(int teacherId);
}
