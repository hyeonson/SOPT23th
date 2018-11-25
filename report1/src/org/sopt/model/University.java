package org.sopt.model;

public class University {
    private int id;
    private String name;
    private String call;
    private String address;

    public University(int id, String name, String call, String address) {
        this.id = id;
        this.name = name;
        this.call = call;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "대학 고유 번호: " + getId() + " 대학 이름: " + getName() + " 대학 전화번호: " + getCall() + " 대학 주소: " + getAddress();
    }
}
