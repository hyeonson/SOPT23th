package org.sopt.service.impl;

import org.sopt.model.Department;
import org.sopt.model.Student;
import org.sopt.model.builder.StudentBuilder;
import org.sopt.model.builder.UniversityBuilder;
import org.sopt.service.StudentService;

import java.util.List;


public class StudentServiceImpl implements StudentService {
    private List<Student> StudentList;

    @Override
    public Student getByStudentId(final int StudentId) {
        for (Student s : StudentList) {
            if (s.getId() == StudentId)
                return s;
        }
        return null;
    }

    ;

    @Override
    public void addStudent(Student s) {
        StudentList.add(s);
    }

}
