package com.javaweb.demo.dao.impl;

import com.javaweb.demo.dao.BookDao;
import com.javaweb.demo.dao.CourseDao;
import com.javaweb.demo.entity.Book;
import com.javaweb.demo.entity.Course;
import com.javaweb.demo.util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {


    @Override
    public List<Course> getCourseAll() {
        List<Course> list = new ArrayList<Course>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from course ");
            while(rs.next()){
                Course course = new Course();
                course.setCno(rs.getString("CCno"));
                course.setCname(rs.getString("CCname"));
                list.add(course);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Course FindCourse(String ccno) {
        Course course = new Course();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from course where Ccno = "+ccno);
            while(rs.next()){
                course.setCno(rs.getString("Ccno"));
                course.setCname(rs.getString("Ccname"));
            }
            DBconn.closeConn();
            return course;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {

        BookDao bookDao = new BookDaoimpl();

        CourseDao course = new CourseDaoImpl();
        List<Course> b2 = course.getCourseAll();

        for(Course s : b2){
            System.out.println(s.toString());
        }

//        bookDao.deleteBook("1");
//        List<Book> b2 = bookDao.getBookkall();
//
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
