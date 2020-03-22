package com.bhdx.models;

public class Admin {
    private String ID;//用户ID(默认为学生学号或教师职工号)
    private String Password;//管理员密码
    private String Grade;//管理员等级
    private String Name;//管理员姓名
    private String Tel;//管理员电话
    private String Mark;//标识，如果是学生，直接获取学生信息方便添加管理员


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
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
                "ID=" + ID +
                ", Password='" + Password + '\'' +
                ", Grade='" + Grade + '\'' +
                ", Name='" + Name + '\'' +
                ", Tel=" + Tel +
                ", Mark='" + Mark + '\'' +
                '}';
    }
    /*public String GetSubject(String ID){
        String Subject = ID.substring(4,8);
        switch (Subject){
            case "1601" : Subject = "测控";
                break;
            case "1602" : Subject = "电气";
                break;
            case "1603" : Subject = "信息";
                break;
            case "1604" : Subject = "通信";
                break;
            case "1605" : Subject = "电子";
                break;
            case "1606" : Subject = "自动化";
                break;
            case "1607" : Subject = "通合作";
        }
        String New_ID=Subject+ID.substring(2,4)+"级"+ID.substring(9,10)+"班";
        return New_ID;
    }*/
}
