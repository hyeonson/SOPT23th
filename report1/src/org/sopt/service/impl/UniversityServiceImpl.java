package org.sopt.service.impl;

import org.sopt.model.University;
import org.sopt.model.builder.UniversityBuilder;
import org.sopt.service.UniversityService;

import java.util.List;

public class UniversityServiceImpl implements UniversityService {
    private List<University> UniversityList;
    @Override
    public University getByUniversityId(final int UniversityId)
    {
        for(University u : UniversityList)
        {
            if(u.getId() == UniversityId)
            {
                return u;
            }
        }
        return null;
    }
    @Override
    public void addUniversity(University u)
    {
        UniversityList.add(u);
    }
}
