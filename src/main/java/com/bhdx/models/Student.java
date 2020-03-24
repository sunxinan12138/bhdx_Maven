package com.bhdx.models;

import java.util.List;

public class Student {

    private String id;//ID
    private String psw;//密码
    private String name;//名字
    private String classID;//班级代号
    private List<CXDetail> cxDetailList;
    private  List<ZCDetail> zcDetailList;


    public List<CXDetail> getCxDetailList() {
        return cxDetailList;
    }

    public void setCxDetailList(List<CXDetail> cxDetailList) {
        this.cxDetailList = cxDetailList;
    }

    public List<ZCDetail> getZcDetailList() {
        return zcDetailList;
    }

    public void setZcDetailList(List<ZCDetail> zcDetailList) {
        this.zcDetailList = zcDetailList;
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

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", psw='" + psw + '\'' +
                ", name='" + name + '\'' +
                ", classID='" + classID + '\'' +
                ", cxDetailList=" + cxDetailList +
                ", zcDetailList=" + zcDetailList +
                '}';
    }
}
