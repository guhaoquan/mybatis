package com.abc;


import com.abc.dao.StudentDao;
import com.abc.domain.Student;
import com.abc.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void test01() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        List<Student> students = mapper.selectStudents();
        for (Student student : students) {
            System.out.println("用户数据:" + student);
        }
        sqlSession.close();

    }

    @Test
    public void test02() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("赵云");
        student.setId(1006);
        student.setEmail("asdad@qq.com");
        student.setAge(50);
        int i = mapper.insertStudents(student);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("成功添加的数据:" + i);
    }

    @Test
    public void test03() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String sqlId = "com.abc.dao.StudentDao.selectStudents";
        List<Object> objects = sqlSession.selectList(sqlId);
        for (Object object : objects) {
            System.out.println(object);
        }
        sqlSession.close();
    }
}
