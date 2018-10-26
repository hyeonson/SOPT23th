package org.sopt.service;

import org.sopt.model.Student;



public interface StudentService {
    //학번으로 학생 조회
    Student getByStudentId(final int StudentId);
}
