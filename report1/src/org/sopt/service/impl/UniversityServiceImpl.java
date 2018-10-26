package org.sopt.service.impl;

import org.sopt.model.University;
import org.sopt.model.builder.UniversityBuilder;
import org.sopt.service.UniversityService;

public class UniversityServiceImpl implements UniversityService {
    @Override
    public University getByUniversityId(final int UniversityId)
    {
        return new UniversityBuilder()
                .setId(UniversityId)
                .setName("인하대")
                .setCall("03212345678")
                .setAddress("용현동")
                .build();
    }
}
