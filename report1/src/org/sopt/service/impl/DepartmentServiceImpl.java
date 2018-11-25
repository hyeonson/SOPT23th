package org.sopt.service.impl;

import org.sopt.model.Department;
import org.sopt.model.builder.DepartmentBuilder;
import org.sopt.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    private List<Department> DepartmentList;

    @Override
    public Department getByDepartmentId(final int DepartmentId) {
        for (Department d : DepartmentList) {
            if (d.getId() == DepartmentId)
                return d;
        }
        return null;
    }

    @Override
    public void addDepartment(Department d) {
        DepartmentList.add(d);
    }
}
