package org.sopt.model;

public class Professor extends Department {
    private String departmentName;
    private String subject;
    public Professor(int id, String name, String call, String address, String type, String departmentName, String subject) {
        super(id, name, call, address, type);
        this.departmentName = departmentName;
        this.subject = subject;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String toString(){
        return "교수 고유 번호: " + getId() + " 교수 이름: " + getName() + " 교수 학과: " + getDepartmentName() +
                " 교수 전화번호: " + getCall() + " 담당과목: " + getSubject();
    }
}
