package org.sopt.model;

public class Department extends University{
    private String type;
    public Department(int id, String name, String call, String address, String type) {
        super(id, name, call, address);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString(){
        return "학과 고유 번호: " + getId() + " 학과 이름: " + getName() + " 학과 전화번호: " + getCall() + " 학과 타입: " + getType();
    }
}
