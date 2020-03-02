package com.bhdx.models;

public class DetailMark {
    //分数细节类
    private String id;//ID
    private String detail;//细节
    private double mark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "DetailMark{" +
                "id='" + id + '\'' +
                ", detail='" + detail + '\'' +
                ", mark=" + mark +
                '}';
    }
}
