package org.sopt.service;

import org.sopt.model.Department;
import org.sopt.model.Professor;

public interface ProfessorService{
    Professor getByProfessorId(final int ProfessorId);
    void addProfessor(Professor p);
}
