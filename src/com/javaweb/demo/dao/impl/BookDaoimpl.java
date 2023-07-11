package com.javaweb.demo.dao.impl;

import com.javaweb.demo.dao.BookDao;
import com.javaweb.demo.dao.CourseDao;
import com.javaweb.demo.dao.TeacherDao;
import com.javaweb.demo.entity.Book;

import com.javaweb.demo.entity.Course;
import com.javaweb.demo.util.DBconn;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoimpl implements BookDao {

    //增
    @Override
    public boolean addBook(Book book) {
        boolean flag = false;
        DBconn.init();
        System.out.println(book.getBauthor());
        int i =DBconn.addUpdDel("insert into book(bno, bname, bauthor, bsource, bedition, bprice, ccno,tno) " +
                "values('"+book.getBno()+"','"+book.getBname()+"','"+book.getBauthor()+"','"+book.getBsource()+"','"+book.getBedition()+"','"+book.getBprice()+"','"+book.getCcno()+"','"+book.getTno()+ "')");//"','"+book.getTno()+   "','"+book.getBnum()+
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }
    //删
    @Override
    public boolean deleteBook(String bno) {
        boolean flag = false;
        DBconn.init();
        String sql = "delete  from book where Bno="+bno;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }


    //改
    @Override
    public boolean updateBook(Book bo) {
        boolean flag = false;
        DBconn.init();
        String sql ="update book set Bname ='"+bo.getBname()
                +"' , Bauthor ='"+bo.getBauthor()
                +"' , Bsource ='"+bo.getBsource()
                +"' , Bedition ='"+bo.getBedition()
                +"' , Bprice ='"+bo.getBprice()
                +"' , CCno ='"+bo.getCcno()
                +"' where Bno = "+bo.getBno();
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }
    @Override
    public boolean updateBook(String bno, String bname, String bauthor, String bsource, String bedition, String bprice, String bnum,String ccno) {
        boolean flag = false;
        DBconn.init();
        String sql ="update book set Bname ='"+bname
                +"' , Bauthor ='"+bauthor
                +"' , Bsource ='"+bsource
                +"' , Bedition ='"+bedition
                +"' , Bprice ='"+bprice
                +"' , Bnum ='"+bnum
//                +"' , Tno ='"+tno
                +"' , CCno ='"+ccno +"' where Bno = "+bno;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    //查询全部的教材信息
    @Override
    public List<Book> getBookkall(String tno) {
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select *" +
                    "from book,Teacher,Course " +
                    "where book.Tno = teacher.Tno and teacher.CCno = course.CCno and teacher.Tno = "+tno);
            while(rs.next()){

                Book book = new Book();
//                Course c = new Course();
                CourseDao co = new CourseDaoImpl();
                String cno = rs.getString("CCno");
                book.setCourse(co.FindCourse(cno));
                book.setCcno(rs.getString("CCno"));
//
//                c.setCname(rs.getString("CCname"));
//                System.out.println(c.toString());
                book.setBno(rs.getString("Bno"));
                book.setBname(rs.getString("Bname"));
                book.setBauthor(rs.getString("Bauthor"));
                book.setBsource(rs.getString("Bsource"));
                book.setBedition(rs.getString("Bedition"));
                book.setBprice(rs.getString("Bprice"));
                book.setBnum(rs.getString("Bnum"));
                book.setCcno(rs.getString("CCno"));
                book.setTno(rs.getString("Tno"));
                list.add(book);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> getBookkall() {
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from book ");
            while(rs.next()){
                Book book = new Book();
                CourseDao co = new CourseDaoImpl();
                String cno = rs.getString("CCno");
                book.setCourse(co.FindCourse(cno));
                book.setCcno(rs.getString("CCno"));
                book.setBno(rs.getString("Bno"));
                book.setBname(rs.getString("Bname"));
                book.setBauthor(rs.getString("Bauthor"));
                book.setBsource(rs.getString("Bsource"));
                book.setBedition(rs.getString("Bedition"));
                book.setBprice(rs.getString("Bprice"));
                book.setBnum(rs.getString("Bnum"));
                book.setCcno(rs.getString("CCno"));
                book.setTno(rs.getString("Tno"));
                list.add(book);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Book> topQuery(Book book) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/ylsm?useunicuee=true& characterEncoding=utf8","root","123456");
            /*
             * 1. 给出一个sql语句前半部
             */
            StringBuilder sql = new StringBuilder("select * from book where 1=1");
            /*
             * 2. 判断条件，完成向sql中追加where子句
             */
            /*
             * 3. 创建一个ArrayList，用来装载参数值
             */
            List<Object> params = new ArrayList<Object>();

            String bno = book.getBno();
            if (bno != null && !bno.trim().isEmpty()) {
                sql.append(" and Bno like ?");
                params.add("%" + bno + "%");
            }

            String bname = book.getBname();
            if (bname != null && !bname.trim().isEmpty()) {
                sql.append(" and Bname like ?");
                params.add("%" + bname + "%");
            }

            String bauthor = book.getBauthor();
            if (bauthor != null && !bauthor.trim().isEmpty()) {
                sql.append(" and Bauthor like ?");
                params.add("%" + bauthor + "%");
            }

            String bsource = book.getBsource();
            if (bsource != null && !bsource.trim().isEmpty()) {
                sql.append(" and Bsource like ?");
                params.add("%" + bsource + "%");
            }

            String bedition = book.getBedition();
            if (bedition != null && !bedition.trim().isEmpty()) {
                sql.append(" and Bedition like ?");
                params.add("%" + bedition + "%");
            }

            String ccno = book.getCcno();
            if (ccno != null && !ccno.trim().isEmpty()) {
                sql.append(" and CCno like ?");
                params.add("%" + ccno + "%");
            }

            /*
             * 三、执行query
             */
            QueryRunner qr = new QueryRunner();
//            DBconn.closeConn();
            return qr.query( conn,sql.toString(), new BeanListHandler<Book>(Book.class), params.toArray());

        } catch (SQLException | ClassNotFoundException e) {
            throw  new RuntimeException(e);
        }
    }



    @Override
    public List<Book> getBookAll() {
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from book ");
            while(rs.next()){
                Book book = new Book();
                CourseDao co = new CourseDaoImpl();
                TeacherDao te =  new TeacherDaoImpl();
                String tno = rs.getString("Tno");
                book.setTeacher(te.FindTeacher(tno));
                String cno = rs.getString("CCno");
                book.setCourse(co.FindCourse(cno));
                book.setCcno(rs.getString("CCno"));
                book.setBno(rs.getString("Bno"));
                book.setBname(rs.getString("Bname"));
                book.setBauthor(rs.getString("Bauthor"));
                book.setBsource(rs.getString("Bsource"));
                book.setBedition(rs.getString("Bedition"));
                book.setBprice(rs.getString("Bprice"));
                book.setCcno(rs.getString("CCno"));
                book.setTno(rs.getString("Tno"));
                list.add(book);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateBook(String bno, String bnum) {
        boolean flag = false;
        DBconn.init();
        String sql ="update book set Bnum ='"+bnum
                +"' where Bno = "+bno;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public List<Book> getBookbno(String bno) {
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from book where Bno="+bno);
            while(rs.next()){
                Book book = new Book();
                CourseDao co = new CourseDaoImpl();
                String cno = rs.getString("CCno");
                book.setCourse(co.FindCourse(cno));
                book.setBno(rs.getString("Bno"));
                book.setBname(rs.getString("Bname"));
                book.setBauthor(rs.getString("Bauthor"));
                book.setBsource(rs.getString("Bsource"));
                book.setBedition(rs.getString("Bedition"));
                book.setBprice(rs.getString("Bprice"));
                book.setBnum(rs.getString("Bnum"));
                book.setCcno(rs.getString("CCno"));
                book.setTno(rs.getString("Tno"));
                list.add(book);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Book getBookBybno(String bno) {
        Book book = new Book();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from book where Bno="+bno);
            while(rs.next()){

                book.setBno(rs.getString("Bno"));
                book.setBname(rs.getString("Bname"));
                book.setBauthor(rs.getString("Bauthor"));
                book.setBsource(rs.getString("Bsource"));
                book.setBedition(rs.getString("Bedition"));
                book.setBprice(rs.getString("Bprice"));
                book.setBnum(rs.getString("Bnum"));
                book.setCcno(rs.getString("CCno"));

                book.setCcno(rs.getString("Tno"));
            }
            DBconn.closeConn();
            return book;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> getBookbna(String bna) {
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from book where Bname="+bna);
            while(rs.next()){
                Book book = new Book();
                book.setBno(rs.getString("Bno"));
                book.setBname(rs.getString("Bname"));
                book.setBauthor(rs.getString("Bauthor"));
                book.setBsource(rs.getString("Bsource"));
                book.setBedition(rs.getString("Bedition"));
                book.setBprice(rs.getString("Bprice"));
                book.setBnum(rs.getString("Bnum"));
                book.setCcno(rs.getString("CCno"));
                list.add(book);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> getBooksau(String bauthor) {
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from book where Bauthor="+bauthor);
            while(rs.next()){
                Book book = new Book();
                book.setBno(rs.getString("Bno"));
                book.setBname(rs.getString("Bname"));
                book.setBauthor(rs.getString("Bauthor"));
                book.setBsource(rs.getString("Bsource"));
                book.setBedition(rs.getString("Bedition"));
                book.setBprice(rs.getString("Bprice"));
                book.setBnum(rs.getString("Bnum"));
                book.setCcno(rs.getString("CCno"));
                list.add(book);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> getBooksed(String bsource) {
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from book where Bsource="+bsource);
            while(rs.next()){
                Book book = new Book();
                book.setBno(rs.getString("Bno"));
                book.setBname(rs.getString("Bname"));
                book.setBauthor(rs.getString("Bauthor"));
                book.setBsource(rs.getString("Bsource"));
                book.setBedition(rs.getString("Bedition"));
                book.setBprice(rs.getString("Bprice"));
                book.setBnum(rs.getString("Bnum"));
                book.setCcno(rs.getString("CCno"));
                list.add(book);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> getBooksc(String ccno) {
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from book where CCno="+ccno);
            while(rs.next()){
                Book book = new Book();
                book.setBno(rs.getString("Bno"));
                book.setBname(rs.getString("Bname"));
                book.setBauthor(rs.getString("Bauthor"));
                book.setBsource(rs.getString("Bsource"));
                book.setBedition(rs.getString("Bedition"));
                book.setBprice(rs.getString("Bprice"));
                book.setBnum(rs.getString("Bnum"));
                book.setCcno(rs.getString("CCno"));
                list.add(book);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    @Override
//    public List<Book> getBooks(String bauthor, String bsource) {
//        List<Book> list = new ArrayList<Book>();
//        try {
//            DBconn.init();
//            ResultSet rs = DBconn.selectSql("select * from book where Bauthor='"+bauthor+"'and Bsource='"+bsource+'"');
//            while(rs.next()){
//                Book book = new Book();
//                book.setBno(rs.getString("Bno"));
//                book.setBname(rs.getString("Bname"));
//                book.setBauthor(rs.getString("Bauthor"));
//                book.setBsource(rs.getString("Bsource"));
//                book.setBedition(rs.getString("Bedition"));
//                book.setBprice(rs.getString("Bprice"));
//                book.setBnum(rs.getInt("Bnum"));
//                book.setCcno(rs.getString("CCno"));
//                list.add(book);
//            }
//            DBconn.closeConn();
//            return list;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public List<Book> getBooks(String bauthor, String bsource, String bedition) {
//        List<Book> list = new ArrayList<Book>();
//        try {
//            DBconn.init();
//            ResultSet rs = DBconn.selectSql("select * from book where Bauthor='"+bauthor+"'and Bsource='"+bsource+"'and Bedition='"+bedition+"'");
//            while(rs.next()){
//                Book book = new Book();
//                book.setBno(rs.getString("Bno"));
//                book.setBname(rs.getString("Bname"));
//                book.setBauthor(rs.getString("Bauthor"));
//                book.setBsource(rs.getString("Bsource"));
//                book.setBedition(rs.getString("Bedition"));
//                book.setBprice(rs.getString("Bprice"));
//              //  book.setBnum(rs.getString("Bnum"));
//                book.setBnum(rs.getInt("Bnum"));
//                book.setCcno(rs.getString("CCno"));
//                list.add(book);
//            }
//            DBconn.closeConn();
//            return list;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }


    public static void main(String[] args) {
        Book book = new Book();
//        book.setBsource("112");
//        book.setBauthor("112");
//        book.setBedition("112");
        BookDao bookDao = new BookDaoimpl();
        bookDao.deleteBook("111");
//        bookDao.deleteBook("1");
         List<Book> b2 = new ArrayList<Book>();//bookDao.getBookkall();

//         b2 = bookDao.topQuery(book);
//        for(Book s : b2){
//            System.out.println(s.toString());
//        }


//        System.out.println("11111");
//        List<Book> b1=bookDao.getBooksau("2");
//        for(Book s : b1){
//            System.out.println(s.toString());
//        }
    }



}
