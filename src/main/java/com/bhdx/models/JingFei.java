package com.bhdx.models;

/**
 * 细节类
 */
public class JingFei {
    private String id;//ID
    private String detail;//密码

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

    @Override
    public String toString() {
        return "JingFei{" +
                "id='" + id + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
