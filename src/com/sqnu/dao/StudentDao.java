package com.sqnu.dao;

import com.sqnu.domain.Student;
import com.sqnu.vo.StudentAndClassroomVo;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    public Student getById(String id);

    public void save(Student s);


    List<Student> getAll();

    Student select1(String a0001);

    List<Student> select2(int i);

   // List<Student> select3(String zl, int i);

    List<Student> select4(Student s);

    List<Student> select5(Map<String, Object> map);

    List<Student> select17(Student s);

    List<Student> select18(String[] strArr);

    Student select19(String a0001);

    List<Map<String, Object>> select20();

    List<StudentAndClassroomVo> select21();


    List<StudentAndClassroomVo> select22(String l);
}
