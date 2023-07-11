package com.javaweb.demo.entity;

public class Reserve {
    private String id;
    private String cno;
    private String bno;
    private int num;
    private double totalPrice;
    private String r_time;
    private String q_time;
    private String bstatus;
    private String place;
    private Book book;

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }



    public Reserve() {
    }

    public Reserve(String id, String cno, String bno, int num, String r_time, String q_time, String bstatus, String place, Book book) {
        this.id = id;
        this.cno = cno;
        this.bno = bno;
        this.num = num;
        this.r_time = r_time;
        this.q_time = q_time;
        this.bstatus = bstatus;
        this.place = place;
        this.book = book;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Reserve{" +
                "id='" + id + '\'' +
                ", cno='" + cno + '\'' +
                ", bno='" + bno + '\'' +
                ", num=" + num +
                ", r_time='" + r_time + '\'' +
                ", q_time='" + q_time + '\'' +
                ", bstatus='" + bstatus + '\'' +
                ", place='" + place + '\'' +
                ", book=" + book +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
        this.bno = bno;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getR_time() {
        return r_time;
    }

    public void setR_time(String r_time) {
        this.r_time = r_time;
    }

    public String getQ_time() {
        return q_time;
    }

    public void setQ_time(String q_time) {
        this.q_time = q_time;
    }

    public String getBstatus() {
        return bstatus;
    }

    public void setBstatus(String bstatus) {
        this.bstatus = bstatus;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
