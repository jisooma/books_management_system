package com.javaweb.demo.entity;

public class Admin  {
    private String mno;
    private String mname;
    private String mtel;
    private String meamil;
    private String password;

    public Admin() {
    }

    public Admin(String mno, String mname, String mtel, String meamil, String password) {
        this.mno = mno;
        this.mname = mname;
        this.mtel = mtel;
        this.meamil = meamil;
        this.password = password;
    }

    public String getMno() {
        return mno;
    }

    public void setMno(String mno) {
        this.mno = mno;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMtel() {
        return mtel;
    }

    public void setMtel(String mtel) {
        this.mtel = mtel;
    }

    public String getMeamil() {
        return meamil;
    }

    public void setMeamil(String meamil) {
        this.meamil = meamil;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "mno='" + mno + '\'' +
                ", mname='" + mname + '\'' +
                ", mtel='" + mtel + '\'' +
                ", meamil='" + meamil + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
