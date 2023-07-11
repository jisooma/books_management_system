package com.javaweb.demo.entity;

public class Monitor {
    private String cno;
    private String cgrade;
    private String cdept;
    private String cmajor;
    String cnum;
    String password;

    public Monitor() {
    }

    public Monitor(String cno, String cgrade, String cdept, String cmajor, String cnum, String password) {
        this.cno = cno;
        this.cgrade = cgrade;
        this.cdept = cdept;
        this.cmajor = cmajor;
        this.cnum = cnum;
        this.password = password;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCgrade() {
        return cgrade;
    }

    public void setCgrade(String cgrade) {
        this.cgrade = cgrade;
    }

    public String getCdept() {
        return cdept;
    }

    public void setCdept(String cdept) {
        this.cdept = cdept;
    }

    public String getCmajor() {
        return cmajor;
    }

    public void setCmajor(String cmajor) {
        this.cmajor = cmajor;
    }

    public String getCnum() {
        return cnum;
    }

    public void setCnum(String cnum) {
        this.cnum = cnum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "cno='" + cno + '\'' +
                ", cgrade='" + cgrade + '\'' +
                ", cdept='" + cdept + '\'' +
                ", cmajor='" + cmajor + '\'' +
                ", cnum=" + cnum +
                ", password='" + password + '\'' +
                '}';
    }
}
