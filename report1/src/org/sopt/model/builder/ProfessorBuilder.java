package org.sopt.model.builder;

import org.sopt.model.Professor;

public class ProfessorBuilder {
    private int id;
    private String name;
    private String call;
    private String address;
    private String type;
    private String departmentName;
    private String subject;

    public int getId() {
        return id;
    }

    public ProfessorBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProfessorBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public String getCall() {
        return call;
    }

    public ProfessorBuilder setCall(String call) {
        this.call = call;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ProfessorBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getType() {
        return type;
    }

    public ProfessorBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public ProfessorBuilder setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public ProfessorBuilder setSubject(String subject) {
        this.subject = subject;
        return this;
    }
    public Professor build(){
        return new Professor(this.id, this.name, this.call, this.address, this.type, this.departmentName, this.subject);
    }
}
