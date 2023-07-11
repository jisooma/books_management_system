package com.javaweb.demo.dao.impl;

import com.javaweb.demo.dao.AdminDao;
import com.javaweb.demo.entity.Admin;

import com.javaweb.demo.entity.Admin;
import com.javaweb.demo.util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdiminDaoImpl implements AdminDao {

    @Override
    public boolean login(String id, String pwd) {
        boolean flag = false;
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from admin where Mno='" + id + "' and password='" + pwd + "'");
            while (rs.next()) {
                if (rs.getString("Mno").equals(id) && rs.getString("password").equals(pwd)) {
                    flag = true;
                }
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;

    }

    @Override

    public boolean modifyPwd(String id,String pwd){
        boolean flag = false;
        DBconn.init();
        String sql = "update admin  set password="+pwd+" where Mno="+id;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;

    }

    @Override
    public boolean updateInfo(Admin admin) {
        boolean flag = false;
        DBconn.init();
        String sql ="update admin set Mname ='"+admin.getMname()
                +"' , Mtel ='"+admin.getMtel()
                +"' , Meamil ='"+admin.getMeamil()
              +"' where Mno = "+admin.getMno();
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;

    }
    @Override
    public boolean updateInfo(String Mno, String Mname,  String Mtel, String Memail) {
        boolean flag = false;
        DBconn.init();
        String sql ="update admin set Mname ='"+Mname
                +"' , Mtel ='"+Mtel
                +"' , Memail ='"+Memail
            +"' where Mno = "+Mno;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;

    }

    @Override
    public Admin FindAdmin(String id) {
        Admin admin =new Admin();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from admin where Mno='"+id+"'");
            while(rs.next()){
                admin.setMno(rs.getString("Mno"));
                admin.setMname(rs.getString("Mname"));
                admin.setMtel(rs.getString("Mtel"));
                admin.setMeamil(rs.getString("Memail"));
                admin.setPassword(rs.getString("password"));
            }
            DBconn.closeConn();
            return admin;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String args[]){


    }




}
