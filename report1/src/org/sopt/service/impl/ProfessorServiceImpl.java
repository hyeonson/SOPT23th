package org.sopt.service.impl;

import org.sopt.model.Professor;
import org.sopt.model.builder.ProfessorBuilder;
import org.sopt.model.builder.UniversityBuilder;
import org.sopt.service.ProfessorService;

import java.util.List;

public class ProfessorServiceImpl implements ProfessorService {
    private List<Professor> ProfessorList;
    @Override
    public Professor getByProfessorId(final int ProfessorId)
    {
        for(Professor p : ProfessorList)
        {
            if(p.getId() == ProfessorId)
                return p;
        }
        return null;
    };
    @Override
    public void addProfessor(Professor p)
    {
        ProfessorList.add(p);
    }
}
