package org.sopt;

import org.sopt.model.Department;
import org.sopt.model.Student;
import org.sopt.model.University;
import org.sopt.model.builder.DepartmentBuilder;
import org.sopt.service.StudentService;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args)
    {
        final ArrayList<Department> departmentList = new ArrayList<>();
        final ArrayList<Student> studentList = new ArrayList<>();

        final DepartmentBuilder departmentBuilder = new DepartmentBuilder();
        final Department department1 = departmentBuilder
                .setId(111)
                .setName("컴퓨터공학과")
                .setCall("0328601234")
                .setType("공과대학")
                .build();
        final Department department2 = departmentBuilder
                .setId(222)
                .setName("정보통신공학과")
                .setCall("0328601235")
                .setType("공과대학")
                .build();
        final Department department3 = departmentBuilder
                .setId(333)
                .setName("전기공학과")
                .setCall("0328601236")
                .setType("공과대학")
                .build();
        departmentList.add(department1);
        departmentList.add(department2);
        departmentList.add(department3);


        for(final Department d : departmentList)
            System.out.println(d.toString());
    }
}
