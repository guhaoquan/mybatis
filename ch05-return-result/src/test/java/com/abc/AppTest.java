package com.abc;


import com.abc.dao.StudentDao;
import com.abc.domain.Student;
import com.abc.utils.MyBatisUtils;
import com.abc.vo.QueryParam;
import com.abc.vo.ViewStudent;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest {


    @Test
    public void test04() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Student student = mapper.selectStudents(1002);
        System.out.println("查询结果为:" + student);
    }

    @Test
    public void test01(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Student student = mapper.selectStudents(1002);
        System.out.println(student);
    }

    @Test
    public void test05() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        List<Student> students = mapper.selectStudentParam(1001, "张三");
        System.out.println("查询结果为:" + students);
        sqlSession.close();
    }

    @Test
    public void test08(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        QueryParam param = new QueryParam();
        param.setParamName("刘备");
        param.setParamId(1002);
        List<Student> students = mapper.selectQueryParam(param);
        System.out.println(students);
        sqlSession.close();
    }

    @Test
    public void test03(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("李四");
        student.setAge(30);
        List<Student> students = mapper.selectStudentparam(student);
        for (Student student1 : students) {
            System.out.println("查询结果为:" + sqlSession);
        }
    }

    @Test
    public void test09(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        ViewStudent viewStudent = mapper.selectViewStudents(1001);
        System.out.println("查询的结果为：" + viewStudent);
    }

    @Test
    public void test10(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        int i = mapper.countStudent();
        System.out.println("用户总数为:" + i);
    }

    @Test
    public void test11(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Map<Object, Object> objectObjectMap = mapper.selectStudentMap(1002);
        System.out.println(objectObjectMap);
    }
}
