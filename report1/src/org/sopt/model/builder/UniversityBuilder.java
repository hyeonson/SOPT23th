package org.sopt.model.builder;

import org.sopt.model.University;

public class UniversityBuilder {
    private int id;
    private String name;
    private String call;
    private String address;

    public int getId() {
        return id;
    }

    public UniversityBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UniversityBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public String getCall() {
        return call;
    }

    public UniversityBuilder setCall(String call) {
        this.call = call;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UniversityBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public University build(){
        return new University(this.id, this.name, this.call, this.address);
    }
}
