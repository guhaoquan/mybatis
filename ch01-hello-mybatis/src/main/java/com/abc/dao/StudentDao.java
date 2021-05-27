package com.abc.dao;

import com.abc.domain.Student;

import java.util.List;

public interface StudentDao {

     List<Student> selectStudents();

     int intsertStudent(Student student);
}
