package com.bhdx.models;

public class SubjectClass {
    public  String id;
    public  String subject;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String  toString() {
        return "SubjectClass{" +
                "id='" + id + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
