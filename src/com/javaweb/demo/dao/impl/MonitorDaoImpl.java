package com.javaweb.demo.dao.impl;

import com.javaweb.demo.dao.MonitorDao;
import com.javaweb.demo.entity.Book;
import com.javaweb.demo.entity.Monitor;
import com.javaweb.demo.entity.Monitor;
import com.javaweb.demo.util.DBconn;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MonitorDaoImpl implements MonitorDao {
    public boolean addMonitor(Monitor mo){
        boolean flag = false;
        DBconn.init();
        int i = DBconn.addUpdDel("insert into monitor(Cno,Cgrade,Cdept,Cmajor,Cnum,password) " +
                "values('" + mo.getCno()+ "','" + mo.getCgrade() + "','" +mo.getCdept()+ "','" + mo.getCmajor()+ "','" + mo.getCnum() + "','" + mo.getPassword()+ "')");

        if (i > 0) {
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }



    @Override
    public List<Monitor> findMonitorByCno(String id) {

        List<Monitor> list = new ArrayList<Monitor>();
        try {
            Monitor monitor =  new Monitor();
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Monitor where Cno="+id);
            while(rs.next()){
                monitor.setCno(rs.getString("Cno"));
                monitor.setCgrade(rs.getString("Cgrade"));
                monitor.setCdept(rs.getString("Cdept"));
                monitor.setCmajor(rs.getString("Cmajor"));
                monitor.setCnum(rs.getString("Cnum"));
                monitor.setPassword(rs.getString("password"));
                list.add(monitor);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Monitor findMonitorByCno1(String id) {

        try {
            Monitor monitor =  new Monitor();
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Monitor where Cno="+id);
            while(rs.next()){
                monitor.setCno(rs.getString("Cno"));
                monitor.setCgrade(rs.getString("Cgrade"));
                monitor.setCdept(rs.getString("Cdept"));
                monitor.setCmajor(rs.getString("Cmajor"));
                monitor.setCnum(rs.getString("Cnum"));
                monitor.setPassword(rs.getString("password"));

            }
            DBconn.closeConn();
            return monitor;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Monitor> findMonitorByCdept(String dept) {
        List<Monitor> list = new ArrayList<Monitor>();
        try {

            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Monitor where Cdept='"+dept+"'");
            while(rs.next()){
                Monitor monitor =  new Monitor();
                monitor.setCno(rs.getString("Cno"));
                monitor.setCgrade(rs.getString("Cgrade"));
                monitor.setCdept(rs.getString("Cdept"));
                monitor.setCmajor(rs.getString("Cmajor"));
                monitor.setCnum(rs.getString("Cnum"));
                monitor.setPassword(rs.getString("password"));
                list.add(monitor);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<Monitor> findMonitorByCgrade(String grade) {
        List<Monitor> list = new ArrayList<Monitor>();
        try {
            Monitor monitor =  new Monitor();
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Monitor where Cgrade='"+grade+"'");
            while(rs.next()){

                monitor.setCno(rs.getString("Cno"));
                monitor.setCgrade(rs.getString("Cgrade"));
                monitor.setCdept(rs.getString("Cdept"));
                monitor.setCmajor(rs.getString("Cmajor"));
                monitor.setCnum(rs.getString("Cnum"));
                monitor.setPassword(rs.getString("password"));
                list.add(monitor);

            }
            DBconn.closeConn();
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Monitor>  findMonitorByDG(String dept, String grade) {
        List<Monitor> list = new ArrayList<Monitor>();
        try {

            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Monitor where Cgrade='"+grade+"'and Cdept='"+dept+"'");
            while(rs.next()){
                Monitor Monitor =  new Monitor();
                Monitor.setCno(rs.getString("Cno"));
                Monitor.setCdept(rs.getString("Cdept"));
                Monitor.setCgrade(rs.getString("Cgrade"));
                Monitor.setCmajor(rs.getString("Cmajor"));
                Monitor.setCnum(rs.getString("Cnum"));
                Monitor.setPassword(rs.getString("password"));
                list.add(Monitor);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Monitor> findMonitorByDGM(String dept, String grade, String major) {
        List<Monitor> list = new ArrayList<Monitor>();
        try {

            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Monitor where Cgrade='"+grade+"'and Cdept='"+dept+"'and Cmajor='"+major+"'");
            while(rs.next()){
                Monitor Monitor =  new Monitor();
                Monitor.setCno(rs.getString("Cno"));
                Monitor.setCdept(rs.getString("Cdept"));
                Monitor.setCgrade(rs.getString("Cgrade"));
                Monitor.setCmajor(rs.getString("Cmajor"));
                Monitor.setCnum(rs.getString("Cnum"));
                Monitor.setPassword(rs.getString("password"));
                list.add(Monitor);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Monitor> findMonitorBynum(String num) {
        List<Monitor> list = new ArrayList<Monitor>();
        try {
            Monitor monitor =  new Monitor();
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Monitor where Cnum='"+num+"'");
            while(rs.next()){
                monitor.setCno(rs.getString("Cno"));
                monitor.setCgrade(rs.getString("Cgrade"));
                monitor.setCdept(rs.getString("Cdept"));
                monitor.setCmajor(rs.getString("Cmajor"));
                monitor.setCnum(rs.getString("Cnum"));
                monitor.setPassword(rs.getString("password"));
                list.add(monitor);

            }
            DBconn.closeConn();
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean login(String id, String pwd) {
        boolean flag = false;
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Monitor where Cno='"+id+"' and password='"+pwd+"'");
            while(rs.next()){
                if(rs.getString("Cno").equals(id) && rs.getString("password").equals(pwd)){
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
    public List<Monitor> getMonitorAll(){
        List<Monitor> list = new ArrayList<Monitor>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Monitor");
            while(rs.next()){
                Monitor Monitor =  new Monitor();
                Monitor.setCno(rs.getString("Cno"));
                Monitor.setCdept(rs.getString("Cdept"));
                Monitor.setCgrade(rs.getString("Cgrade"));
                Monitor.setCmajor(rs.getString("Cmajor"));
                Monitor.setCnum(rs.getString("Cnum"));
                Monitor.setPassword(rs.getString("password"));
                list.add(Monitor);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        boolean flag = false;
        DBconn.init();
        String sql = "delete  from Monitor where Cno="+id;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }

        DBconn.closeConn();
        return flag;
    }

    @Override/////////////////////////////
    public boolean update(String id, String garde, String dept, String major, String num) {
        boolean flag = false;
        DBconn.init();
        String sql ="update Monitor set Cgarde ='"+garde
                +"' , Cdept ='"+dept
                +"' , Cmajor ='"+major
                +"' , Cnum ='"+num+"' where Cno = "+id;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public boolean update(String id, String num) {
        boolean flag = false;
        DBconn.init();
        String sql ="update Monitor set Cnum ='"+num
                +"' where Cno = "+id;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public boolean update(Monitor mo) {
        boolean flag = false;
        DBconn.init();
        String sql ="update monitor set Cgrade ='"+mo.getCgrade()
                +"' , Cdept ='"+mo.getCdept()
                +"' , Cmajor ='"+mo.getCmajor()
                +"' , password ='"+mo.getPassword()
                +"' , Cnum ='"+mo.getCnum()+"' where Cno = "+mo.getCno();
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        else{
            Monitor m = new Monitor();
            m.setCno(mo.getCno());
            m.setCgrade(mo.getCgrade());
            m.setCdept(mo.getCdept());
            m.setCmajor(mo.getCmajor());
            m.setCnum(mo.getCnum());
            m.setPassword(mo.getPassword());
            System.out.println(m.getCno());
            addMonitor(m);

        }
        DBconn.closeConn();
        return flag;
    }

    public List<Monitor> topQuery(Monitor monitor) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/ylsm?useunicuee=true& characterEncoding=utf8","root","123456");
            /*
             * 1. 给出一个sql语句前半部
             */
            StringBuilder sql = new StringBuilder("select * from Monitor where 1=1");
            /*
             * 2. 判断条件，完成向sql中追加where子句
             */
            /*
             * 3. 创建一个ArrayList，用来装载参数值
             */
            List<Object> params = new ArrayList<Object>();

            String cno = monitor.getCno();

            if (cno != null && !cno.trim().isEmpty()) {
                sql.append(" and Cno like ?");
                params.add("%" + cno + "%");
            }

            String cgrade =monitor.getCgrade();
            if (cgrade != null && !cgrade.trim().isEmpty()) {
                sql.append(" and Cgrade like ?");
                params.add("%" + cgrade + "%");
            }
            String cdept =monitor.getCdept();
            if (cdept != null && !cdept.trim().isEmpty()) {
                sql.append(" and Cdept like ?");
                params.add("%" + cdept + "%");
            }

            String cmajor =monitor.getCmajor();
            if (cmajor != null && !cmajor.trim().isEmpty()) {
                sql.append(" and Cmajor like ?");
                params.add("%" + cmajor + "%");
            }

//            int cnum =monitor.getCnum();
//            if (cnum == 0 && !cnum.trim().isEmpty()) {
//                sql.append(" and Cnum =");
//                params.add("%" + cnum + "%");
//            }
            /*
             * 三、执行query
             */
            QueryRunner qr = new QueryRunner();

            return qr.query(conn,sql.toString(), new BeanListHandler<Monitor>(Monitor.class), params.toArray());

        } catch (SQLException | ClassNotFoundException e) {
            throw  new RuntimeException(e);
        }
    }

    public static  void main(String args[]){
        Monitor mo = new Monitor();
        mo.setCno("17070143");
        mo.setCgrade("17");
        mo.setCdept("dashuju");
        mo.setCmajor("computer");
        mo.setCnum("123");
        mo.setPassword("1223");

        Monitor mo1 = new Monitor();
        //mo1.setCno("17070000");
        mo1.setCgrade("17级");
        mo1.setCdept("大数据学院");
        //mo1.setCmajor("computer");
        //mo1.setCnum(123);
        //mo1.setPassword("1223");

        MonitorDao m=  new MonitorDaoImpl();
//        m.update("17070143",12);
//        m.update(mo1);
//        m.delete("17070141");
       ;


        List <Monitor> mm=new ArrayList<Monitor>();
        mm= m.topQuery(mo1);
//        mm = m.findMonitorByCdept("大数据");
        //mm=m.findMonitorByDG("大数据","17级");
//        mm=m.findMonitorByDGM("大数据学院","17级","计科");
        for(Monitor monitor:mm){
            System.out.println(monitor.toString());
        }


    }
}
