package org.sopt.service.impl;

import org.sopt.model.Professor;
import org.sopt.model.builder.ProfessorBuilder;
import org.sopt.model.builder.UniversityBuilder;
import org.sopt.service.ProfessorService;

public class ProfessorServiceImpl implements ProfessorService {
    @Override
    public Professor getByProfessorId(final int ProfessorId)
    {
        return new ProfessorBuilder()
                .setId(ProfessorId)
                .setName("박준석")
                .setDepartmentName("컴퓨터공학과")
                .setCall("03212345678")
                .setSubject("임베디드 시스템")
                .build();
    };
}
