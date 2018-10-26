package org.sopt.service;

import org.sopt.model.Professor;
import org.sopt.model.Student;

public interface ProfessorService{
    Professor getByProfessorId(final int ProfessorId);
}
