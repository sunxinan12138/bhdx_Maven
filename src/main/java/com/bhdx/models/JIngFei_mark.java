package com.bhdx.models;

/**
 * 分数累
 */

public class JIngFei_mark {
    private String id;//ID
    private String level;//级别
    private double mark;//分值
    private int detail_id;//详情id

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public int getDetail_id() {
        return detail_id;
    }

    public void setDetail_id(int detail_id) {
        this.detail_id = detail_id;
    }

    @Override
    public String toString() {
        return "JIngFei_mark{" +
                "id='" + id + '\'' +
                ", level='" + level + '\'' +
                ", mark=" + mark +
                ", detail_id=" + detail_id +
                '}';
    }
}
