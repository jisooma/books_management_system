//package com.javaweb.demo.servlet;
//
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import jxl.Cell;
//import jxl.Sheet;
//import jxl.Workbook;
//import jxl.read.biff.BiffException;
//
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.FileItemFactory;
//import org.apache.commons.fileupload.FileUploadException;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//
//import databaseOrm.DatabaseOperation;
//
///**
// * Servlet implementation class ImportMsg
// */
//@WebServlet("/ImportMsg")
//public class ImportMsg extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    // JDBC 驱动名及数据库 URL
//    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://localhost:3306/sx";
//
//    // 数据库的用户名与密码，需要根据自己的设置
//    static final String USER = "root";
//    static final String PASS = "******";//此处为自己数据库的密码
//
//    protected void doGet(HttpServletRequest request,
//                         HttpServletResponse response) throws ServletException, IOException {
//        doPost(request, response);
//    }
//
//    protected void doPost(HttpServletRequest request,
//                          HttpServletResponse response) throws ServletException, IOException {
//
//        FileItemFactory factory = new DiskFileItemFactory();
//        ServletFileUpload upload = new ServletFileUpload(factory);
//
//        java.sql.Connection conn = null;
//        java.sql.Statement stmt = null;
//        try {
//            // 注册 JDBC 驱动器
//            Class.forName("com.mysql.jdbc.Driver");
//            // 打开一个连接
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            // 执行 SQL 查询
//            stmt = conn.createStatement();
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        }
//
//        try {
//            List items = upload.parseRequest(request);
//            InputStream is = null;
//            Iterator iter = items.iterator();
//            while (iter.hasNext()) {
//                FileItem item = (FileItem) iter.next();
//                if (!item.isFormField()) {
//                    is = item.getInputStream();
//                }
//            }
//            Workbook workbook = Workbook.getWorkbook(is);
//            Sheet sheet = workbook.getSheet(0);
//            // 行数
//            int rows = sheet.getColumns();
//            // 列数
//            int columns = sheet.getColumns();
//
//            PreparedStatement ps = conn
//                    .prepareStatement("insert into students(sid,sname,ssex,stelephone) values(?,?,?,?)");
//
//            for (int i = 0; i < rows; i++) {
//                if (i == 0) {// 第一行是属性，不读取
//                    continue;
//                }
//                Cell ce0 = ((jxl.Sheet) sheet).getCell(0, i);
//                Cell ce1 = ((jxl.Sheet) sheet).getCell(1, i);
//                Cell ce2 = ((jxl.Sheet) sheet).getCell(2, i);
//                Cell ce3 = ((jxl.Sheet) sheet).getCell(3, i);
//
//                String c0 = ce0.getContents();
//                String c1 = ce1.getContents();
//                String c2 = ce2.getContents();
//                String c3 = ce3.getContents();
//
//                ps.setString(1, c0);
//                ps.setString(2, c1);
//                ps.setString(3, c2);
//                ps.setString(4, c3);
//                ps.execute();
//            }
//            ps.close();
//            conn.close();
//            response.sendRedirect("ImportMsgSuccess.html");// 重定向到成功插入学生数据的页面
//        } catch (FileUploadException e) {
//            e.printStackTrace();
//        } catch (BiffException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//}
