package org.sopt.service;

import org.sopt.model.Department;
import org.sopt.model.Student;

public interface DepartmentService {
    Department getByDepartmentId(final int DepartmentId);
}
