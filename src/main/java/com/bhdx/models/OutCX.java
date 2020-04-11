package com.bhdx.models;

public class OutCX {
    /**
     * idint(11)
     * stuidchar(13)
     * namechar(15)
     * zsnamechar(30)
     * markdecimal(5,1)
     * sortchar(5)
     */
    private int id;
    private String stuid;
    private String name;
    private String zsName;
    private Double mark;
    private String sort;
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

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    @Override
    public String toString() {
        return "OutCX{" +
                "id=" + id +
                ", stuid='" + stuid + '\'' +
                ", name='" + name + '\'' +
                ", zsName='" + zsName + '\'' +
                ", mark=" + mark +
                ", sort='" + sort + '\'' +
                ", cause='" + cause + '\'' +
                '}';
    }
}
