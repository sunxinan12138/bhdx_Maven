package com.bhdx.models;

//综测证书审核通过表
public class OutZC {
    private int id;
    private String stuid;
    private String name;
    private String zsName;
    private Double mark;
    private String zk;//折扣
    private String cause;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZsName() {
        return zsName;
    }

    public void setZsName(String zsName) {
        this.zsName = zsName;
    }

    public String getZk() {
        return zk;
    }

    public void setZk(String zk) {
        this.zk = zk;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    @Override
    public String toString() {
        return "OutZC{" +
                "id=" + id +
                ", stuid='" + stuid + '\'' +
                ", name='" + name + '\'' +
                ", zsName='" + zsName + '\'' +
                ", mark=" + mark +
                ", zk='" + zk + '\'' +
                ", cause='" + cause + '\'' +
                '}';
    }
}
