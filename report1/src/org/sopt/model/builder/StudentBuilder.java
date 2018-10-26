package org.sopt.model.builder;

import org.sopt.model.Student;

public class StudentBuilder {
    int id;
    String name;
    String call;
    String address;
    String type;
    private int grade;
    private String departmentName;
    private String email;
    private int age;
    private String state;

    public int getId() {
        return id;
    }

    public StudentBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public String getCall() {
        return call;
    }

    public StudentBuilder setCall(String call) {
        this.call = call;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public StudentBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getType() {
        return type;
    }

    public StudentBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public int getGrade() {
        return grade;
    }

    public StudentBuilder setGrade(int grade) {
        this.grade = grade;
        return this;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public StudentBuilder setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public StudentBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getAge() {
        return age;
    }

    public StudentBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public String getState() {
        return state;
    }

    public StudentBuilder setState(String state) {
        this.state = state;
        return this;
    }
    public Student build()
    {
        return new Student(this.id, this.name, this.call, this.address, this.type,
        this.grade, this.departmentName, this.email, this.age, this.state);
    }
}
