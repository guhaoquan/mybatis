package com.abc.dao;

import com.abc.domain.Student;
import com.abc.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    public Student selectStudents(Integer id);

    public List<Student> selectStudentParam(@Param("myId") Integer id,
                                            @Param("myname") String name);

    public List<Student> selectQueryParam(QueryParam param);

    public List<Student> selectStudentparam(Student student);
}
