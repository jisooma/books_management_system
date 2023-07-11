package com.javaweb.demo.entity;

public class Course {
    private String cno;
    private String cname;
    private Teacher teacher;
    private String tno;
    public Course() {
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public Course(String ccno, String ccname, Teacher teacher) {
        this.cno = ccno;
        this.cname = ccname;
        this.teacher = teacher;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "ccno='" + cno + '\'' +
                ", ccname='" + cname + '\'' +
                '}';
    }
}
