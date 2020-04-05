package com.bhdx.models;

import java.util.Arrays;

public class CXDetail {
    /*
        idint(11)
        stuidchar(10)
        zsnamechar(50)
        markdecimal(5,1)
        remarkchar(50)
        imgNamechar(15)
        imglongblob
        shConditionchar(10)
        ---------------------------
          detail: this.detail,
            stuid: this.stuid,
            zsname: this.value1,
            mark: this.value2,
            remark: this.value3
        */
    private int id;
    private String stuid;
    private String name;
    private String zsname;
    private Double mark;
    private String remark;
    private String time;
    private String sort;
    private String imgName;
    private String classID;
    private String classId;
    private byte[] img;
    private String shCondition;
    public void setMark(Double mark) {
        this.mark = mark;
    }

    public Double getMark() {
        return mark;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

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

    public String getZsname() {
        return zsname;
    }

    public void setZsname(String zsname) {
        this.zsname = zsname;
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
        return "CXDetail{" +
                "id=" + id +
                ", stuid='" + stuid + '\'' +
                ", name='" + name + '\'' +
                ", zsname='" + zsname + '\'' +
                ", mark=" + mark +
                ", remark='" + remark + '\'' +
                ", time='" + time + '\'' +
                ", sort='" + sort + '\'' +
                ", imgName='" + imgName + '\'' +
                ", classID='" + classID + '\'' +
                ", classId='" + classId + '\'' +
                ", img=" + Arrays.toString(img) +
                ", shCondition='" + shCondition + '\'' +
                '}';
    }
}
