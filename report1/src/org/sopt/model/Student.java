package org.sopt.model;

public class Student extends Department{
    private int grade;
    private String departmentName;
    private String email;
    private int age;
    private String state;

    public Student(int id, String name, String call, String address, String type,
                   int grade, String departmentName, String email, int age, String state) {
        super(id, name, call, address, type);
        this.grade = grade;
        this.departmentName = departmentName;
        this.email = email;
        this.state = state;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public String toString(){
        return "학번: " + getId() + " 이름: " + getName() + " 학년: " + getGrade() +
                " 학과: " + getDepartmentName() + " 이메일: " + getEmail() + " 주소: " + getAddress() +
                " 나이: " + getAge() + "현재 상태: " + getState();
    }
}
