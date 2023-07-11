package com.javaweb.demo.dao.impl;

import com.javaweb.demo.dao.BookDao;
import com.javaweb.demo.dao.ReserveDao;
import com.javaweb.demo.entity.Book;
import com.javaweb.demo.entity.Monitor;
import com.javaweb.demo.entity.Reserve;

import com.javaweb.demo.util.DBconn;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReserveDaoImpl implements ReserveDao {

    @Override
    public Boolean addReserve(Reserve re) {
        boolean flag = false;
        System.out.println(re.getBno());
        try {
            DBconn.init();
            int i = DBconn.addUpdDel("insert into reserve(Rno,Cno,Bno,R_time,Q_time,Rnum,Bstatus,Place,totalPrice) " +
                    "values('" + re.getId()+ "','" +re.getCno() + "','" + re.getBno() + "','" + re.getR_time()+ "','" + re.getQ_time() + "','" + re.getNum() +"','" +re.getBstatus()+ "','" +re.getPlace()+ "','" +re.getTotalPrice()+"')");
            if (i > 0) {
                flag = true;
            }
        } finally {
            DBconn.closeConn();
        }
        return flag;
    }

    @Override
    public boolean deleteReserve(String id) {

        boolean flag = false;
        DBconn.init();
        String sql = "delete  from reserve where Rno="+id;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public boolean updateReserve(Reserve re) {
        boolean flag = false;
        try {
            DBconn.init();
            String sql ="update reserve set  Cno='"+re.getCno()
                    +"' , Bno ='"+re.getBno()
                    +"' , RNum ='"+re.getNum()
                    +"' , R_time ='"+re.getR_time()
                    +"' , Q_time ='"+re.getQ_time()
                    +"' , Bstatus ='"+re.getBstatus()
                    +"' , Place ='"+re.getPlace()
                    +"' , Place ='"+re.getTotalPrice()
                    +"' where Rno = "+re.getId();
            int i =DBconn.addUpdDel(sql);
            if(i>0){
                flag = true;
            }
        } finally {
            DBconn.closeConn();
        }
        return flag;
    }
    @Override
    public boolean updateReserveById(String id,int rnum) {
        boolean flag = false;
        try {
            DBconn.init();
            String sql ="update reserve set  Rnum='"+rnum
                    +"' where Rno = "+id;
            int i =DBconn.addUpdDel(sql);
            if(i>0){
                flag = true;
            }
        } finally {
            DBconn.closeConn();
        }
        return flag;
    }

    @Override
    public int findMaxId() {
        int result = -1;
        try {
            DBconn.init();
            String sql="select max(Rno) from reserve";
            ResultSet rs = DBconn.selectSql(sql);
            if (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBconn.closeConn();
        }
        return result;
    }

    @Override
    public List<Reserve> findReserveByBno(String Bno) {
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve where Tno='"+Bno+"'");
            while(rs.next()){
                Reserve reserve =  new Reserve();
                reserve.setId(rs.getString("Rno"));
                reserve.setCno(rs.getString("Cno"));
                reserve.setBno(rs.getString("Bno"));
                reserve.setNum(rs.getInt("Rnum"));
                reserve.setR_time(rs.getString("R_time"));
                reserve.setQ_time(rs.getString("Q_time"));
                reserve.setBstatus(rs.getString("Bstatus"));
                reserve.setPlace(rs.getString("Place"));
                reserve.setTotalPrice(rs.getDouble("totalPrice"));
                String bno = rs.getString("Bno");

                BookDao bo  =new BookDaoimpl();
                reserve.setBook(bo.getBookBybno(bno));
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Reserve> findReserveByCno(String Cno) {
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve where Cno='"+Cno+"'");
            while(rs.next()){
                Reserve reserve =  new Reserve();
                reserve.setId(rs.getString("Rno"));
                reserve.setCno(rs.getString("Cno"));
                reserve.setBno(rs.getString("Bno"));
                reserve.setNum(rs.getInt("Rnum"));
                reserve.setR_time(rs.getString("R_time"));
                reserve.setQ_time(rs.getString("Q_time"));
                reserve.setBstatus(rs.getString("Bstatus"));
                reserve.setPlace(rs.getString("Place"));
                reserve.setTotalPrice(rs.getDouble("totalPrice"));
                String bno = rs.getString("Bno");
                //System.out.println(bno);
                BookDao bo  =new BookDaoimpl();
                Book  book =  bo.getBookBybno(bno);
                reserve.setBook(book);
               // System.out.println(book.getBauthor());
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Reserve> findReserveByStatus(String status) {
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve where Bstatus='"+status+"'");
            while(rs.next()){
                Reserve reserve =  new Reserve();
                reserve.setId(rs.getString("Rno"));
                reserve.setCno(rs.getString("Cno"));
                reserve.setBno(rs.getString("Bno"));
                reserve.setNum(rs.getInt("Rnum"));
                reserve.setR_time(rs.getString("R_time"));
                reserve.setQ_time(rs.getString("Q_time"));
                reserve.setBstatus(rs.getString("Bstatus"));
                reserve.setPlace(rs.getString("Place"));
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Reserve> findAllReserve() {
        List<Reserve> list = new ArrayList<Reserve>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve");
            while(rs.next()){
                BookDao bo  =new BookDaoimpl();
                Reserve reserve =  new Reserve();
                reserve.setId(rs.getString("Rno"));
                reserve.setCno(rs.getString("Cno"));
                String bno = rs.getString("Bno");
                reserve.setBno(rs.getString("Bno"));
                reserve.setNum(rs.getInt("Rnum"));
                reserve.setR_time(rs.getString("R_time"));
                reserve.setQ_time(rs.getString("Q_time"));
                reserve.setBstatus(rs.getString("Bstatus"));
                reserve.setPlace(rs.getString("Place"));
                reserve.setTotalPrice(rs.getDouble("totalPrice"));
                reserve.setBook(bo.getBookBybno(bno));
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<Reserve> findUnDealReserve() {
        List<Reserve> list = new ArrayList<Reserve>();
        try {

            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve where Bstatus='"+"未发放"+"'");
            while(rs.next()){
                Reserve reserve =  new Reserve();
                reserve.setId(rs.getString("Rno"));
                reserve.setCno(rs.getString("Cno"));
                reserve.setBno(rs.getString("Bno"));
                reserve.setNum(rs.getInt("Rnum"));
                reserve.setR_time(rs.getString("R_time"));
                reserve.setQ_time(rs.getString("Q_time"));
                reserve.setBstatus(rs.getString("Bstatus"));
                reserve.setTotalPrice(rs.getDouble("totalPrice"));
                reserve.setPlace(rs.getString("Place"));

                String bno = rs.getString("Bno");
                BookDao bo  =new BookDaoimpl();
                reserve.setBook(bo.getBookBybno(bno));
                list.add(reserve);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Reserve> topQuery(Reserve reserve) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/ylsm?useunicuee=true& characterEncoding=utf8","root","123456");
            /*
             * 1. 给出一个sql语句前半部
             */
            StringBuilder sql = new StringBuilder("select * from Reserve where 1=1");
            /*
             * 2. 判断条件，完成向sql中追加where子句
             */
            /*
             * 3. 创建一个ArrayList，用来装载参数值
             */
            List<Object> params = new ArrayList<Object>();

            String id = reserve.getId();

            if (id != null && !id.trim().isEmpty()) {
                sql.append(" and Rno like ?");
                params.add("%" + id + "%");
            }

            String cno=reserve.getCno();
            if (cno != null && !cno.trim().isEmpty()) {
                sql.append(" and Cno like ?");
                params.add("%" + cno + "%");
            }

            String bno=reserve.getBno();
            if (cno != null && !cno.trim().isEmpty()) {
                sql.append(" and Bno like ?");
                params.add("%" + bno + "%");
            }
            String r_time =reserve.getR_time();
            if (r_time != null && !r_time.trim().isEmpty()) {
                sql.append(" and R_time like ?");
                params.add("%" + r_time + "%");
            }

            String q_time =reserve.getQ_time();
            if (q_time != null && !q_time.trim().isEmpty()) {
                sql.append(" and Q_time like ?");
                params.add("%" + q_time + "%");
            }
//            String rnum=reserve.getNum();
//            if (cno != null && !cno.trim().isEmpty()) {
//                sql.append(" and Rnum  = ?");
//                params.add("%" + rnum + "%");
//            }
            String place =reserve.getPlace();
            if (place != null && !place.trim().isEmpty()) {
                sql.append(" and Place like ?");
                params.add("%" + place + "%");
            }




            /*
             * 三、执行query
             */
            QueryRunner qr = new QueryRunner();

            return qr.query(conn,sql.toString(), new BeanListHandler<Reserve>(Reserve.class), params.toArray());

        } catch (SQLException | ClassNotFoundException e) {
            throw  new RuntimeException(e);
        }
    }

    @Override
    public Reserve findOrderById(String id) {
        Reserve reserve =  new Reserve();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from reserve where Rno='"+id+"'");
            while(rs.next()){

                reserve.setId(rs.getString("Rno"));
                reserve.setCno(rs.getString("Cno"));
                reserve.setBno(rs.getString("Bno"));
                reserve.setNum(rs.getInt("Rnum"));
                reserve.setR_time(rs.getString("R_time"));
                reserve.setQ_time(rs.getString("Q_time"));
                reserve.setBstatus(rs.getString("Bstatus"));
                reserve.setPlace(rs.getString("Place"));
                String bno = rs.getString("Bno");
                BookDao bo  =new BookDaoimpl();
                reserve.setBook(bo.getBookBybno(bno));
            }
            DBconn.closeConn();
            return reserve;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String args[]){
        Reserve reserve =new Reserve();
        Reserve reserve1 =new Reserve();
        ReserveDao re = new ReserveDaoImpl();
        BookDao bo= new BookDaoimpl();
        System.out.println(re.findMaxId());

        List<Reserve> reserves = re.findReserveByCno("17070143");
//        for(Reserve re:reserves){
//            System.out.println(re.toString());
//            System.out.println();
//        }

        reserve.setId("12");
        reserve.setCno("17070143");
        reserve.setBno("123321");
//        reserve.setNum("11");
       // reserve.setR_time("null");
       //reserve.setQ_time(null);
       // reserve.setBstatus("未发放");
        //reserve.setPlace(null);
        //re.addReserve(reserve);
        //re.deleteReserve("2");

//        reserve1.setId("1222");
//        reserve1.setCno("17070143");
//        reserve1.setBno("123321");
//        reserve1.setNum(11);
//        reserve1.setR_time(null);
//        reserve1.setQ_time(null);
//        reserve1.setBstatus("未发放");
//        reserve1.setPlace(null);
//        reserve.setBook(bo.getBooks(reserve.getBno()));
//        RE.addReserve(reserve);
//        RE.addReserve(reserve);
//        System.out.println(RE.findOrderById("12"));

//        System.out.println(RE.deleteReserve("12"));


    }

}
