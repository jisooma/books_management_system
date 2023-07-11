package com.javaweb.demo.entity;

public class Teacher {
    private String tno;
    private String tname;
    private String tdept;
    private String ttel;
    private String temail;
    private String tcno;
    private String password;
    private Course course;
    private  String bno;
    private Book book;


    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
        this.bno = bno;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "tno='" + tno + '\'' +
                ", tname='" + tname + '\'' +
                ", tdept='" + tdept + '\'' +
                ", ttel='" + ttel + '\'' +
                ", temail='" + temail + '\'' +
                ", tcno='" + tcno + '\'' +
                ", password='" + password + '\'' +
                ", course=" + course +
                ", book=" + book +
                '}';
    }

    public Teacher() {
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Teacher(String tno) {
        this.tno = tno;
    }

    public Teacher(String tno, String tname, String tdept, String ttel, String temail, String tcno, String password) {
        this.tno = tno;
        this.tname = tname;
        this.tdept = tdept;
        this.ttel = ttel;
        this.temail = temail;
        this.tcno = tcno;
        this.password = password;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTdept() {
        return tdept;
    }

    public void setTdept(String tdept) {
        this.tdept = tdept;
    }

    public String getTtel() {
        return ttel;
    }

    public void setTtel(String ttel) {
        this.ttel = ttel;
    }

    public String getTemail() {
        return temail;
    }

    public void setTemail(String temail) {
        this.temail = temail;
    }

    public String getTcno() {
        return tcno;
    }

    public void setTcno(String tcno) {
        this.tcno = tcno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
