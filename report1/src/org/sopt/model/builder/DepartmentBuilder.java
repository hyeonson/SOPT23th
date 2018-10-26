package org.sopt.model.builder;

import org.sopt.model.Department;

public class DepartmentBuilder {
    private int id;
    private String name;
    private String call;
    private String address;
    private String type;

    public int getId() {
        return id;
    }

    public DepartmentBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DepartmentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public String getCall() {
        return call;
    }

    public DepartmentBuilder setCall(String call) {
        this.call = call;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public DepartmentBuilder setType(String type) {
        this.type = type;
        return this;
    }
    public Department build()
    {
        return new Department(this.id, this.name, this.call, this.address, this.type);
    }
}
