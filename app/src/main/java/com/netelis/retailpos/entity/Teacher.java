package com.netelis.retailpos.entity;

public class Teacher {

    private int id;
    private String name;
    private String sex;


    public Teacher(int id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
