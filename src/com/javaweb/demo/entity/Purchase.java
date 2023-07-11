package com.javaweb.demo.entity;

public class Purchase {
    private String bno;
    private String bname;
    private String bauthor;
    private String bsource;
    private String bedition;
    private String bprice;
    private int number;

    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
        this.bno = bno;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBauthor() {
        return bauthor;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public String getBsource() {
        return bsource;
    }

    public void setBsource(String bsource) {
        this.bsource = bsource;
    }

    public String getBedition() {
        return bedition;
    }

    public void setBedition(String bedition) {
        this.bedition = bedition;
    }

    public String getBprice() {
        return bprice;
    }

    public void setBprice(String bprice) {
        this.bprice = bprice;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
