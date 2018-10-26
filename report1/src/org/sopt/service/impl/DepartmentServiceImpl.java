package org.sopt.service.impl;

import org.sopt.model.Department;
import org.sopt.model.builder.DepartmentBuilder;
import org.sopt.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public Department getByDepartmentId(final int DepartmentId)
    {
        return new DepartmentBuilder()
                .setId(DepartmentId)
                .setName("컴퓨터공학과")
                .setCall("03212345678")
                .setType("공대")
                .build();
    };
}
