package com.omix222;

import java.io.Serializable;

public class PersonBean implements Serializable {
    private String id;
    private String dep;
    private String rank;
    private String sex;

    public PersonBean(String id, String dep, String rank, String sex) {
        this.id = id;
        this.dep = dep;
        this.rank = rank;
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
