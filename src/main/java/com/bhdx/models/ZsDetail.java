package com.bhdx.models;

/**
 * 添加证书审核类
 */
public class ZsDetail {
    private int id;//id
    private String studentId;//学号
    private String project;//项目
    private String proclass;//项目
    private String detail;//细节
    private String Level;//等级
    private double mark;//分数
    //图片

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

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String level) {
        Level = level;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public String getProclass() {
        return proclass;
    }

    public void setProclass(String proclass) {
        this.proclass = proclass;
    }

    @Override
    public String toString() {
        return "ZsDetail{" +
                "id=" + id +
                ", studentId='" + studentId + '\'' +
                ", project='" + project + '\'' +
                ", proclass='" + proclass + '\'' +
                ", detail='" + detail + '\'' +
                ", Level='" + Level + '\'' +
                ", mark=" + mark +
                '}';
    }
}
