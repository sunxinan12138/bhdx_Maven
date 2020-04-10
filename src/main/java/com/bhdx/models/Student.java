package com.bhdx.models;

import java.util.List;

public class Student {

    private String id;//ID
    private String psw;//密码
    private String name;//名字
    private String classID;//班级代号
    private List<CXDetail> cxDetailList;
    private List<ZCDetail> zcDetailList;
    private List<OutCX> outCXList;
    private List<OutZC> outZCList;
    private String tel;//电话号
    private String address;//家庭住址
    private int dormitory;//寝室号


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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDormitory() {
        return dormitory;
    }

    public void setDormitory(int dormitory) {
        this.dormitory = dormitory;
    }

    public List<OutCX> getOutCXList() {
        return outCXList;
    }

    public void setOutCXList(List<OutCX> outCXList) {
        this.outCXList = outCXList;
    }

    public List<OutZC> getOutZCList() {
        return outZCList;
    }

    public void setOutZCList(List<OutZC> outZCList) {
        this.outZCList = outZCList;
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
                ", outCXList=" + outCXList +
                ", outZCList=" + outZCList +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", dormitory=" + dormitory +
                '}';
    }
}
