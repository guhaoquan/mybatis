package com.abc;

import com.abc.dao.StudentDao;
import com.abc.domain.Student;
import com.abc.utils.MyBatisUtils;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class AppTest {

    @Test
    public void test01(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("张三");
        student.setAge(18);
        List<Student> students = mapper.selectStudentids(student);
        for (Student student1 : students) {
            System.out.println("数据为:" + student1);
        }
    }

    @Test
    public void test02(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("李四");
        student.setAge(30);
        List<Student> students =mapper.selectStudenrWhere(student);
        for(Student student1 : students){
            System.out.println(student1);
        }

    }

    @Test
    public void test03(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        PageHelper.startPage(2,3);
        List<Student> students = mapper.selectStudents();
        for (Student student : students) {
            System.out.println(student);
        }

    }


}
