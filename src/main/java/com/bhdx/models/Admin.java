package com.bhdx.models;

public class Admin {
    private String ID;//用户ID(默认为学生学号或教师职工号)
    private String Password;//管理员密码
   // private String Grade;//管理员等级
    private String Name;//管理员姓名
    private String Tel;//管理员电话
    private String Mark;//标识，如果是学生，直接获取学生信息方便添加管理员


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getMark() {
        return Mark;
    }

    public void setMark(String mark) {
        Mark = mark;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "ID='" + ID + '\'' +
                ", Password='" + Password + '\'' +
                ", Name='" + Name + '\'' +
                ", Tel='" + Tel + '\'' +
                ", Mark='" + Mark + '\'' +
                '}';
    }
}
