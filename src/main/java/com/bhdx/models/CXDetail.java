package com.bhdx.models;

import java.util.Arrays;

public class CXDetail {
    /*
        idint(11)
        stuidchar(10)
        levelchar(8)
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
    private String level;
    private String zsname;
    private Double mark;
    private String remark;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getZsname() {
        return zsname;
    }

    public void setZsname(String zsname) {
        this.zsname = zsname;
    }

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

    @Override
    public String toString() {
        return "CXDetail{" +
                "id=" + id +
                ", stuid='" + stuid + '\'' +
                ", level='" + level + '\'' +
                ", zsname='" + zsname + '\'' +
                ", mark='" + mark + '\'' +
                ", remark='" + remark + '\'' +
                ", imgName='" + imgName + '\'' +
                ", img=" + Arrays.toString(img) +
                '}';
    }
}
