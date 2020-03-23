package com.bhdx.models;

import java.util.Arrays;

/**
 * 添加证书审核类
 */
public class ZsDetail {
    private int id;//id
    private String studentId;//学号
    private String detail;//细节
    private String zsName;//证书名
    private double mark;//分数
    private String imageName;//图片
    private byte[] img;	//字节数组
    private String time;//证书时间
    private String remark;//备注
    private String userMark;
    private String shCondition;//审核状态
    private String classID;//班级号

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getZsName() {
        return zsName;
    }

    public void setZsName(String zsName) {
        this.zsName = zsName;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserMark() {
        return userMark;
    }

    public void setUserMark(String userMark) {
        this.userMark = userMark;
    }

    public String getShCondition() {
        return shCondition;
    }

    public void setShCondition(String shCondition) {
        this.shCondition = shCondition;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    @Override
    public String toString() {
        return "ZsDetail{" +
                "id=" + id +
                ", studentId='" + studentId + '\'' +
                ", detail='" + detail + '\'' +
                ", zsName='" + zsName + '\'' +
                ", mark=" + mark +
                ", imageName='" + imageName + '\'' +
                ", img=" + Arrays.toString(img) +
                ", time='" + time + '\'' +
                ", remark='" + remark + '\'' +
                ", userMark='" + userMark + '\'' +
                ", shCondition='" + shCondition + '\'' +
                ", classID='" + classID + '\'' +
                '}';
    }
}
