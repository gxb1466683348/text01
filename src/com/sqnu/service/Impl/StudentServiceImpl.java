package com.sqnu.service.Impl;

import com.sqnu.dao.StudentDao;

import com.sqnu.domain.Student;
import com.sqnu.service.StudentService;
import com.sqnu.util.SqlSessionUtil;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = SqlSessionUtil.getSession().getMapper(StudentDao.class);


    @Override
    public Student getById(String id) {

        Student s = studentDao.getById(id);
        return s;
    }

    @Override
    public void save(Student s) {
        studentDao.save(s);
    }

    @Override
    public List<Student> getAll() {
         List<Student> sList = studentDao.getAll();

        return sList;
    }
}
