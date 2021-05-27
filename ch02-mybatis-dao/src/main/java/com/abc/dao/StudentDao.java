package com.abc.dao;

import com.abc.domain.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> selectStudents();

    public int insertStudents(Student student);
}
