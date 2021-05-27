package com.abc;

import static org.junit.Assert.assertTrue;

import com.abc.dao.StudentDao;
import com.abc.dao.impl.StudentDaoImpl;
import com.abc.domain.Student;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void test01(){
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> students = studentDao.selectStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void test02(){
        StudentDao studentDao = new StudentDaoImpl();
        Student student = new Student();
        student.setId(1005);
        student.setName("关羽");
        student.setEmail("asdasd@qq.com");
        student.setAge(40);
        int i = studentDao.insertStudents(student);
        System.out.println("成功添加的数据:" + i);

    }
}
