package com.bhdx.models;

import java.util.Arrays;

public class ZCDetail {
    /*    idint(11)
        stuidchar(20)
        levelchar(8)
        markdecimal(5,1)
        zkchar(5)
        zsnamechar(20)
        timechar(10)
        remarkchar(20)
        imgNamechar(20)
        imglongblob
        shConditionchar(10)*/
    private int id;
    private String stuid;
    private String name;
    private double mark;
    private String zk;
    private String zsName;
    private String time;
    private String remark;
    private String classID;
    private String imgName;
    private byte[] img;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public String getZk() {
        return zk;
    }

    public void setZk(String zk) {
        this.zk = zk;
    }

    public String getZsName() {
        return zsName;
    }

    public void setZsName(String zsName) {
        this.zsName = zsName;
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

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
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
        return "ZCDetail{" +
                "id=" + id +
                ", stuid='" + stuid + '\'' +
                ", name='" + name + '\'' +
                ", mark=" + mark +
                ", zk='" + zk + '\'' +
                ", zsName='" + zsName + '\'' +
                ", time='" + time + '\'' +
                ", remark='" + remark + '\'' +
                ", classID='" + classID + '\'' +
                ", imgName='" + imgName + '\'' +
                ", img=" + Arrays.toString(img) +
                '}';
    }
}
