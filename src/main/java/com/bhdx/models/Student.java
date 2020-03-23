package com.bhdx.models;

import java.util.List;

public class Student {

    private String id;//ID
    private String psw;//密码
    private String name;//名字
    private List<ZsDetail> zsDetails;

    public List<ZsDetail> getZsDetails() {
        return zsDetails;
    }

    public void setZsDetails(List<ZsDetail> zsDetails) {
        this.zsDetails = zsDetails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", psw='" + psw + '\'' +
                ", name='" + name + '\'' +
                ", zsDetails=" + zsDetails +
                '}';
    }
}
