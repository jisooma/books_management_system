package com.javaweb.demo.entity;

public class Book {
    private String bno;
    private String bname;
    private String bauthor;
    private String bsource;
    private String bedition;
    private String bprice;
    private String bnum;//库存
    private String ccno;
    private String tno;
    private Teacher teacher;
    private Course course;

    public Book() {
    }


    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

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

    public String getBnum() {
        return bnum;
    }

    public void setBnum(String bnum) {
        this.bnum = bnum;
    }

    public String getCcno() {
        return ccno;
    }

    public void setCcno(String ccno) {
        this.ccno = ccno;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bno='" + bno + '\'' +
                ", bname='" + bname + '\'' +
                ", bauthor='" + bauthor + '\'' +
                ", bsource='" + bsource + '\'' +
                ", bedition='" + bedition + '\'' +
                ", bprice='" + bprice + '\'' +
                ", bnum=" + bnum +
                ", ccno='" + ccno + '\'' +
                ", tno='" + tno + '\'' +
                '}';
    }
}
