package com.abc.dao;

import com.abc.domain.Student;

import java.util.List;

public interface StudentDao {

    //使用动态sql参数必须是java对象
    List<Student> selectStudentids(Student student);

    //where
    List<Student> selectStudenrWhere(Student student);

    List<Student> selectStudents();
}
