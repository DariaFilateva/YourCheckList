package com.checklist.domain;

import javax.persistence.*;

@Entity
public class ListElement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "checklist_id")
    Checklist checklist;

    String element;

    String comment;

    public ListElement() {
    }

    public ListElement(String element, String comment) {
        this.element = element;
        this.comment = comment;
    }

    public ListElement(Checklist checklist, String element, String comment) {
        this.checklist = checklist;
        this.element = element;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Checklist getChecklist() {
        return checklist;
    }

    public void setChecklist(Checklist checklist) {
        this.checklist = checklist;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }
}
