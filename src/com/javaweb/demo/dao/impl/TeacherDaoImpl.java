package com.javaweb.demo.dao.impl;

import com.javaweb.demo.dao.BookDao;
import com.javaweb.demo.dao.CourseDao;
import com.javaweb.demo.dao.TeacherDao;
import com.javaweb.demo.entity.*;
import com.javaweb.demo.entity.Teacher;
import com.javaweb.demo.util.DBconn;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {
    public boolean modifyPwd(String id,String pwd){
        boolean flag = false;
        DBconn.init();
        String sql = "update teacher  set password="+pwd+" where Tno="+id;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;

    }

    @Override
    public boolean addTeacher(Teacher te){
        boolean flag = false;
        DBconn.init();
        int i = DBconn.addUpdDel("insert into teacher(Tno,Tname,Tdept,Ttel,Temail,CCno,password) " +
                "values('" + te.getTno()+ "','" + te.getTname() + "','" + te.getTdept() + "','" + te.getTtel()+ "','" + te.getTemail()  + "','" + te.getTcno() +"','" +te.getPassword()+ "')");
        if (i > 0) {
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public boolean login(String id, String pwd) {
        boolean flag = false;
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Teacher where Tno='"+id+"' and password='"+pwd+"'");
            while(rs.next()){
                if(rs.getString("Tno").equals(id) && rs.getString("password").equals(pwd)){
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
    public boolean findTeacher(String tno) {
        Teacher teacher =  new Teacher();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Teacher where Tno='"+tno+"'");
            while(rs.next()){
                return true;
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public List<Teacher> topQuery(Teacher teacher) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/ylsm?useunicuee=true& characterEncoding=utf8","root","123456");
            /*
             * 1. 给出一个sql语句前半部
             */
            StringBuilder sql = new StringBuilder("select * from Teacher where 1=1");
            /*
             * 2. 判断条件，完成向sql中追加where子句
             */
            /*
             * 3. 创建一个ArrayList，用来装载参数值
             */
            List<Object> params = new ArrayList<Object>();

            String cno =teacher.getTno();

            if (cno != null && !cno.trim().isEmpty()) {
                sql.append(" and Tno like ?");
                params.add("%" + cno + "%");
            }

            String cgrade =teacher.getTname();
            if (cgrade != null && !cgrade.trim().isEmpty()) {
                sql.append(" and Tname like ?");
                params.add("%" + cgrade + "%");
            }
            String cdept =teacher.getTdept();
            if (cdept != null && !cdept.trim().isEmpty()) {
                sql.append(" and Tdept like ?");
                params.add("%" + cdept + "%");
            }

            String cmajor =teacher.getTcno();
            if (cmajor != null && !cmajor.trim().isEmpty()) {
                sql.append(" and Tcno like ?");
                params.add("%" + cmajor + "%");
            }

            /*
             * 三、执行query
             */
            QueryRunner qr = new QueryRunner();

            return qr.query(conn,sql.toString(), new BeanListHandler<Teacher>(Teacher.class), params.toArray());

        } catch (SQLException | ClassNotFoundException e) {
            throw  new RuntimeException(e);
        }
    }

    @Override
    public List<Teacher> getTeacherAll() {
        List<Teacher> list = new ArrayList<Teacher>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Teacher");
            while(rs.next()){
                Teacher teacher =  new Teacher();
                teacher.setTno(rs.getString("Tno"));
                teacher.setTname(rs.getString("Tname"));
                teacher.setTdept(rs.getString("Tdept"));
                teacher.setTtel(rs.getString("Ttel"));
                teacher.setTemail(rs.getString("Temail"));

                String cno = rs.getString("CCno");

                teacher.setTcno(rs.getString("CCno"));
                CourseDao co = new CourseDaoImpl();
                teacher.setCourse(co.FindCourse(cno));
                list.add(teacher);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteTeacher(String id) {
        boolean flag = false;
        DBconn.init();
        String sql = "delete  from teacher where Tno="+id;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public boolean updateTeacher(String id, String name, String dept, String tel, String email,String cno) {
        boolean flag = false;
        DBconn.init();
        String sql ="update teacher set Tname ='"+name
                +"' , Tdept ='"+dept
                +"' , Ttel ='"+tel
                +"' , Temail ='"+email
                +"' , CCno ='"+cno+"' where Tno = "+id;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;

    }
    @Override
    public boolean updateTeacher(String id, String name, String dept, String tel, String email) {
        boolean flag = false;
        DBconn.init();
        String sql ="update teacher set Tname ='"+name
                +"' , Tdept ='"+dept
                +"' , Ttel ='"+tel
                +"' , Temail ='"+email
                 +"' where Tno = "+id;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;

    }
    @Override
    public boolean updateTeacher(Teacher te) {
        boolean flag = false;
        System.out.println(te.toString());

        DBconn.init();
        String sql ="update Teacher set Tname ='"+te.getTname()
                +"' , Tdept ='"+te.getTdept()
                +"' , Ttel ='"+te.getTtel()
                +"' , Temail ='"+te.getTemail()
//                +"' , password ='"+te.getPassword()
                +"' , CCno ='"+te.getTcno()+"' where Tno = "+te.getTno();
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;

    }

    @Override
    public Teacher FindTeacher(String tno){
        Teacher teacher =  new Teacher();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Teacher where Tno='"+tno+"'");
            while(rs.next()){

                teacher.setTno(rs.getString("Tno"));
                teacher.setTname(rs.getString("Tname"));
                teacher.setTdept(rs.getString("Tdept"));
                teacher.setPassword(rs.getString("password"));
                teacher.setTtel(rs.getString("Ttel"));
                teacher.setTemail(rs.getString("Temail"));
                String cno = rs.getString("CCno");
                teacher.setTcno(rs.getString("CCno"));
                CourseDao co = new CourseDaoImpl();
                teacher.setCourse(co.FindCourse(cno));
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;

    }
    @Override
    public List<Teacher> FindTeacherBytno(String tno){
        List<Teacher> list = new ArrayList<Teacher>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Teacher where Tno='"+tno+"'");
            while(rs.next()){
                Teacher teacher =  new Teacher();
                Book book=new Book();
                Course course = new Course();
                BookDao bo = new BookDaoimpl();
                CourseDao co =  new CourseDaoImpl();

                teacher.setTno(rs.getString("Tno"));
                teacher.setTname(rs.getString("Tname"));
                teacher.setTdept(rs.getString("Tdept"));
                teacher.setTtel(rs.getString("Ttel"));
                teacher.setTemail(rs.getString("Temail"));
                String cno =rs.getString("CCno");
                teacher.setTcno(rs.getString("CCno"));
                course = co.FindCourse(cno);
                teacher.setCourse(course);
                list.add(teacher);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Teacher> FindTeacherByDC(String dept,String cno){
        List<Teacher> list = new ArrayList<Teacher>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Teacher where Tdept='"+dept+"' and CCno='"+cno+"'");
            while(rs.next()){
                Teacher teacher =  new Teacher();
                teacher.setTno(rs.getString("Tno"));
                teacher.setTname(rs.getString("Tname"));
                teacher.setTdept(rs.getString("Tdept"));
                teacher.setTtel(rs.getString("Ttel"));
                teacher.setTemail(rs.getString("Temail"));
                String ccno = rs.getString("CCno");
                teacher.setTcno(rs.getString("CCno"));
                CourseDao co = new CourseDaoImpl();
                teacher.setCourse(co.FindCourse(ccno));
                list.add(teacher);
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }
    @Override
    public List<Teacher> FindTeacherByDN(String dept,String tname){
        List<Teacher> list = new ArrayList<Teacher>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Teacher where Tdept='"+dept+"' and Tname='"+tname+"'");
            while(rs.next()){
                Teacher teacher =  new Teacher();
                teacher.setTno(rs.getString("Tno"));
                teacher.setTname(rs.getString("Tname"));
                teacher.setTdept(rs.getString("Tdept"));
                teacher.setTtel(rs.getString("Ttel"));
                teacher.setTemail(rs.getString("Temail"));
                String ccno = rs.getString("CCno");
                teacher.setTcno(rs.getString("CCno"));
                CourseDao co = new CourseDaoImpl();
                teacher.setCourse(co.FindCourse(ccno));
                list.add(teacher);
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }
    @Override
    public List<Teacher> FindTeacherBydept(String Tdept){
        List<Teacher> list = new ArrayList<Teacher>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Teacher where Tdept='"+Tdept+"'");
            while(rs.next()){
                Teacher teacher =  new Teacher();
                teacher.setTno(rs.getString("Tno"));
                teacher.setTname(rs.getString("Tname"));
                teacher.setTdept(rs.getString("Tdept"));
                teacher.setTtel(rs.getString("Ttel"));
                teacher.setTemail(rs.getString("Temail"));
                String cno = rs.getString("CCno");
                teacher.setTcno(rs.getString("CCno"));
                CourseDao co = new CourseDaoImpl();
                teacher.setCourse(co.FindCourse(cno));
                list.add(teacher);
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }
    @Override
    public List<Teacher> FindTeacherByname(String   Tname){
        List<Teacher> list = new ArrayList<Teacher>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Teacher where Tname='"+Tname+"'");
            while(rs.next()){
                Teacher teacher =  new Teacher();
                teacher.setTno(rs.getString("Tno"));
                teacher.setTname(rs.getString("Tname"));
                teacher.setTdept(rs.getString("Tdept"));
                teacher.setTtel(rs.getString("Ttel"));
                teacher.setTemail(rs.getString("Temail"));
                teacher.setTcno(rs.getString("CCno"));
                list.add(teacher);
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Teacher> FindTeacherBycno(String   cno){
        List<Teacher> list = new ArrayList<Teacher>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Teacher where Cno='"+cno+"'");
            while(rs.next()){
                Teacher teacher =  new Teacher();
                teacher.setTno(rs.getString("Tno"));
                teacher.setTname(rs.getString("Tname"));
                teacher.setTdept(rs.getString("Tdept"));
                teacher.setTtel(rs.getString("Ttel"));
                teacher.setTemail(rs.getString("Temail"));
                String ccno = rs.getString("CCno");
                teacher.setTcno(rs.getString("CCno"));
                CourseDao co = new CourseDaoImpl();
                teacher.setCourse(co.FindCourse(ccno));
                list.add(teacher);
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args) {
        Teacher te=new Teacher();
        te.setTno("22111");
        te.setTname("wang");
        te.setTdept("大数据");
        te.setTtel("132666");
        te.setTemail("123@qq");
        te.setTcno("11");
        te.setPassword("1234");

        Teacher te1=new Teacher();
        te1.setTno("1");
        te1.setTname("wang");
        te1.setTdept("123数据");
        te1.setTtel("13");
        te1.setTemail("123");
        te1.setTcno("11");
        te1.setPassword("134");


//

        TeacherDao dao = new TeacherDaoImpl();
        //dao.addTeacher(te);

           dao.updateTeacher(te1);
//        dao.addTeacher(te1);
        dao.deleteTeacher("1");
        //List <Teacher> teachers= new ArrayList<Teacher>();
//        te=dao.FindTeacher("122220");
//        System.out.println( te.toString());
//        teachers = dao.FindTeacherBytno("122221");
//        for(Teacher teacher:teachers){
//            System.out.println( teacher.toString());
//        }
//        boolean flag=dao.deleteTeacher("122221");
//        System.out.println(flag);
////        boolean flag0=dao.addTeacher(te1);
////        System.out.println(flag0);
//        List <Teacher> teachers= dao.FindTeacher("122221","11");


//        boolean flag1= dao.deleteTeacher("1111");
//        System.out.println(flag1);
//
//        boolean flag3= dao.updateTeacher("1111","wang","大数据","13266","123@qq","11");
//        System.out.println(flag3);
    }

}