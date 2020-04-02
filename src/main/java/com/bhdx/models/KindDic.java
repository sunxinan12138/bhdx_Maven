package com.bhdx.models;

/**
 * KInd类
 *
 FieldTypeComment
 idint(11)
 kindchar(20)
 sortchar(6)
 lableIdint(4)
 */
public class KindDic {
    private String id;//ID
    private String  kind;//kind
    private String  sort;//kind
    private String  lableId;//kind

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getLableId() {
        return lableId;
    }

    public void setLableId(String lableId) {
        this.lableId = lableId;
    }

    @Override
    public String toString() {
        return "KindDic{" +
                "id='" + id + '\'' +
                ", kind='" + kind + '\'' +
                ", sort='" + sort + '\'' +
                ", lableId='" + lableId + '\'' +
                '}';
    }
}
