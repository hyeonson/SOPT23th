package org.sopt.service.impl;

import org.sopt.model.Department;
import org.sopt.model.Student;
import org.sopt.model.builder.StudentBuilder;
import org.sopt.model.builder.UniversityBuilder;
import org.sopt.service.StudentService;


public class StudentServiceImpl implements StudentService{

    @Override
    public Student getByStudentId(final int StudentId)
    {
        return new StudentBuilder()
                .setId(StudentId)
                .setName("김현수")
                .setGrade(3)
                .setEmail("gumgim95@naver.com")
                .setAddress("용현동")
                .setAge(24)
                .setState("재학중")
                .build();
    };

}
