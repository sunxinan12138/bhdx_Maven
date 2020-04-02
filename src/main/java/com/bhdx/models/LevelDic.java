package com.bhdx.models;

/**
 * level 累
 * levelchar(30)
 * markZcdecimal(5,1)
 * zkchar(3)
 * markCxdecimal(5,1)
 * kindIdint(6)
 */

public class LevelDic {
    private String level;//ID
    private String zk;//级别
    private double markZc;//分值
    private double markCx;//分值
    private int kindId;//详情id

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getZk() {
        return zk;
    }

    public void setZk(String zk) {
        this.zk = zk;
    }

    public double getMarkZc() {
        return markZc;
    }

    public void setMarkZc(double markZc) {
        this.markZc = markZc;
    }

    public double getMarkCx() {
        return markCx;
    }

    public void setMarkCx(double markCx) {
        this.markCx = markCx;
    }

    public int getKindId() {
        return kindId;
    }

    public void setKindId(int kindId) {
        this.kindId = kindId;
    }

    @Override
    public String toString() {
        return "LevelDic{" +
                "level='" + level + '\'' +
                ", zk='" + zk + '\'' +
                ", markZc=" + markZc +
                ", markCx=" + markCx +
                ", kindId=" + kindId +
                '}';
    }
}
