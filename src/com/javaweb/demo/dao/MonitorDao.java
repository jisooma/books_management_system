package com.javaweb.demo.dao;

import com.javaweb.demo.entity.Monitor;
import java.util.List;

public interface MonitorDao {
    public boolean login(String name,String pwd);//登录
    public List<Monitor> getMonitorAll();//返回用户信息集合
    public boolean delete(String id) ;//根据id删除用户
    public boolean update(String id, String garde, String dept, String major, String num) ;//更新用户信息
    public boolean update(Monitor mo) ;//更新用户信息
   // public boolean update(String major, String num);
    public boolean update(String id, String num);
    public boolean addMonitor(Monitor mo);
    public List<Monitor> findMonitorByCno(String id);
    public List<Monitor> findMonitorByCdept(String dept);
    public List<Monitor> findMonitorByCgrade(String grade);
    public List<Monitor>  findMonitorByDG(String dept,String grade);
    public List<Monitor>  findMonitorByDGM(String dept,String grade,String major);
    public List<Monitor> findMonitorBynum(String num);
    public Monitor findMonitorByCno1(String id);
    public List<Monitor> topQuery(Monitor monitor);

}
