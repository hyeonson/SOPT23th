package org.sopt.service;

import org.sopt.model.Student;
import org.sopt.model.University;

public interface UniversityService {
    University getByUniversityId(final int UniversityId);

    void addUniversity(University u);
}
