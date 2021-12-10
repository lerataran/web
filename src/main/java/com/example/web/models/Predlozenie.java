package com.example.web.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Predlozenie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fio, name;
    private int sumCred, procent;
    private String date;
    private int sumPla, sumTelo, sumPros;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSumCred() {
            return sumCred;
        }

        public void setSumCred(int sumCred) {
            this.sumCred = sumCred;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getSumPla() {
            return sumPla;
        }

        public void setSumPla(int sumPla) {
            this.sumPla = sumPla;
        }

        public int getSumTelo() {
            return sumTelo;
        }

        public void setSumTelo(int sumTelo) {
            this.sumTelo = sumTelo;
        }

        public int getSumPros() {
            return sumPros;
        }

        public void setSumPros(int sumPros) {
            this.sumPros = sumPros;
        }

    public int getProcent() {
        return procent;
    }

    public void setProcent(int procent) {
        this.procent = procent;
    }

    public Predlozenie() {
    }

    public Predlozenie(String fio, String name, int sumCred,int procent, String date, int sumPla, int sumTelo, int sumPros) {
        this.fio = fio;
        this.name = name;
        this.sumCred = sumCred;
        this.procent = procent;
        this.date = date;
        this.sumPla = sumPla;
        this.sumTelo = sumTelo;
        this.sumPros = sumPros;
    }

}