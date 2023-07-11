package com.javaweb.demo.dao;

import com.javaweb.demo.entity.Admin;

public interface AdminDao {
    public boolean login(String id, String pwd);
    public boolean modifyPwd(String id,String pwd);
    public boolean updateInfo(Admin admin);

    public boolean updateInfo(String mno, String mname, String mtel, String memail);
    public Admin FindAdmin(String id);
}
