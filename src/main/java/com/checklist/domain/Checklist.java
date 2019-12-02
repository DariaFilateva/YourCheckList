package com.checklist.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Checklist {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String creator;

    private String name;

    public Checklist() {
    }

    public Checklist(String creator, String name) {
        this.creator = creator;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
