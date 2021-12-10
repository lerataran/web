package com.example.web.models;

import javax.persistence.*;

@Entity
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String name_credit;
    private int lim, procent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_credit() {
        return name_credit;
    }

    public void setName_credit(String name_credit) {
        this.name_credit = name_credit;
    }

    public int getLim() {
        return lim;
    }

    public void setLim(int lim) {
        this.lim = lim;
    }

    public int getProcent() {
        return procent;
    }

    public void setProcent(int procent) {
        this.procent = procent;
    }

    public Credit() {
    }

    public Credit(String name_credit, int lim, int procent) {
        this.name_credit = name_credit;
        this.lim = lim;
        this.procent = procent;
    }
}
