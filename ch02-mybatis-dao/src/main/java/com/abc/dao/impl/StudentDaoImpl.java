package com.abc.dao.impl;

import com.abc.dao.StudentDao;
import com.abc.domain.Student;
import com.abc.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> selectStudents() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.abc.dao.StudentDao.selectStudents";
        List<Student> students = sqlSession.selectList(sqlId);
        sqlSession.close();
        return students;
    }

    @Override
    public int insertStudents(Student student) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.abc.dao.StudentDao.insertStudents";
        int insert = sqlSession.insert(sqlId, student);
        //提交事务
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
        return insert;
    }

}
