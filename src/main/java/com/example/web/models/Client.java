package com.example.web.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String fio_client, mail;
    private int nomer, pasport;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio_client() {
        return fio_client;
    }

    public void setFio_client(String fio_client) {
        this.fio_client = fio_client;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getNomer() {
        return nomer;
    }

    public void setNomer(int nomer) {
        this.nomer = nomer;
    }

    public int getPasport() {
        return pasport;
    }

    public void setPasport(int pasport) {
        this.pasport = pasport;
    }

    public Client() {
    }
    public Client(String fio_client, String mail, int nomer, int pasport) {
        this.fio_client = fio_client;
        this.mail = mail;
        this.nomer = nomer;
        this.pasport = pasport;
    }


}


