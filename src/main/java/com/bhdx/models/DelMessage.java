package com.bhdx.models;

public class DelMessage {

    private int id;
    private String stuid;
    private String zsname;
    private String cause;
    private String flag;

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

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DelMessage{" +
                "id=" + id +
                ", stuid='" + stuid + '\'' +
                ", zsname='" + zsname + '\'' +
                ", cause='" + cause + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
