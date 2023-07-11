package com.javaweb.demo.dao;

import com.javaweb.demo.entity.Monitor;
import com.javaweb.demo.entity.Teacher;


import java.util.List;

public interface TeacherDao {
    public boolean login(String name,String pwd);//登录
    public boolean findTeacher(String tno);
    public List<Teacher> getTeacherAll();//返回所有老师信息集合
    public boolean deleteTeacher(String id) ;//根据id删除老师
    public boolean updateTeacher(String id, String name, String dept, String tel, String email,String cno);//更新用户信息
    public boolean addTeacher(Teacher te);
    public boolean updateTeacher(Teacher te);
    public List<Teacher> FindTeacherByDC(String dept,String cno);
    public Teacher FindTeacher(String tno);
    public List<Teacher> FindTeacherBytno(String tno);
    public List<Teacher> FindTeacherBycno(String  cno);
    public List<Teacher> FindTeacherByname(String  Tname);
    public List<Teacher> FindTeacherBydept(String Tdept);
    public List<Teacher> FindTeacherByDN(String dept,String tname);
    public boolean updateTeacher(String id, String name, String dept, String tel, String email);
    public boolean modifyPwd(String id,String pwd);
    public List<Teacher> topQuery(Teacher teacher);

}
