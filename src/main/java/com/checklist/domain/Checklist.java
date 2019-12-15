package com.checklist.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Checklist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    private String filename;

    @OneToMany(
            mappedBy = "checklist",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ListElement> elements = new ArrayList<>();


    public Checklist() {
    }

    public Checklist(String name, User user) {
        this.name = name;
        this.author = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "Автор не задан";
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void addElement(ListElement el) {
        elements.add(el);
        el.setChecklist(this);
    }

    public void removeElement(ListElement el) {
        elements.remove(el);
        el.setChecklist(null);
    }

    public List<ListElement> getElements() {
        return elements;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
