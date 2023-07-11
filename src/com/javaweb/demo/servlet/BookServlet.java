package com.javaweb.demo.servlet;

import com.javaweb.demo.dao.BookDao;
import com.javaweb.demo.dao.ReserveDao;
import com.javaweb.demo.dao.impl.BookDaoimpl;
import com.javaweb.demo.dao.impl.ReserveDaoImpl;
import com.javaweb.demo.entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {

    private BookDao book = new BookDaoimpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String option = request.getParameter("option");
        if ("addBook".equals(option)) {
            addBook(request, response);
        } else if ("showAllBooks".equals(option)) {
            showAllBooks(request, response);
        } else if ("deleteBook".equals(option)) {
            deleteBook(request, response);
        } else if ("updateBook".equals(option)) {
            updateBook(request, response);
        }else if("findBook".equals(option)){
            findBook(request,response);
        } else if("showAllBooksToTeacherA".equals(option)){
            showAllBooksToTeacherA(request,response);
    }
        else if("showAllBooksToMonitor".equals(option)){
        showAllBooksToMonitor(request,response);
    }

        else if ("showAllBooksToTeacher".equals(option)) {
            showAllBooksToTeacher(request, response);
        }
        else if("updateBookByManager".equals(option)){
            updateBookByManager(request,response);
        }
        else if("deleteBookByManager".equals(option)){
            deleteBookByManager(request,response);
        } else if("MonitorfindBook".equals(option)){
            MonitorfindBook(request,response);
        } else if("ManagerfindBook".equals(option)){
            ManagerfindBook(request,response);
        }
    }

    private void findBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Book book1 = new Book();
        String Bno = request.getParameter("Bno");
        String Bname = request.getParameter("Bname");
        String Bauthor = request.getParameter("Bauthor");
        String Bsource = request.getParameter("Bsource");
        String Bedition = request.getParameter("Bedition");
        String CCno = request.getParameter("CCno");
        book1.setBno(Bno);
        System.out.println(Bno);
        book1.setBname(Bname);
        System.out.println(Bname);
        book1.setBauthor(Bauthor);
        System.out.println(Bauthor);
        book1.setBsource(Bsource);
        System.out.println(Bsource);
        book1.setBedition(Bedition);
        System.out.println(Bedition);
        book1.setCcno(CCno);
        List<Book> b = new ArrayList<Book>();
         b=book.topQuery(book1);

        request.setAttribute("books", b);
        //页面
        request.getRequestDispatcher("/teacher_book_find.jsp").forward(request, response);
    }
    private void MonitorfindBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book1 = new Book();
        String Bno = request.getParameter("bno");
        String Bname = request.getParameter("bname");
        String tno = request.getParameter("tno");
        String cno = request.getParameter("cno");
        book1.setBno(Bno);
        book1.setBname(Bname);
        book1.setTno(tno);
        book1.setCcno(cno);
        List<Book> b = new ArrayList<Book>();
        b=book.topQuery(book1);


        request.setAttribute("books", b);
        //页面
        request.getRequestDispatcher("/monitor_book_find.jsp").forward(request, response);
    }

    private void ManagerfindBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book1 = new Book();
        String Bno = request.getParameter("Bno");
        String Bname = request.getParameter("Bname");
        String tno = request.getParameter("Btno");
        String cno = request.getParameter("Bcno");
        String Bauthor = request.getParameter("Bauthor");
        String Bedition = request.getParameter("Bedition");
        String Bsource = request.getParameter("Bsource");
        book1.setBauthor(Bauthor);

        book1.setBsource(Bsource);
        // System.out.println(Bsource);
        book1.setBedition(Bedition);
        //  System.out.println(Bedition);
        book1.setBno(Bno);
        book1.setBname(Bname);
        book1.setTno(tno);
        book1.setCcno(cno);
        List<Book> b = new ArrayList<Book>();
        b=book.topQuery(book1);

        request.setAttribute("books", b);
        //页面
        request.getRequestDispatcher("/manager_book_find.jsp").forward(request, response);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    private void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Teacher teacher= (Teacher) session.getAttribute("user");
        ReserveDao re  = new ReserveDaoImpl();
        String Tno = teacher.getTno();
//        System.out.println(Tno+"test");
        //类不可
        String Bno = request.getParameter("Bno");
        String Bname = request.getParameter("Bname");
        String Bauthor = request.getParameter("Bauthor");
        String Bsource = request.getParameter("Bsource");
        String Bedition = request.getParameter("Bedition");
        String Bprice = request.getParameter("Bprice");
        String CCno = request.getParameter("Ccno");

        Book book1 = new Book();
        book1.setBno(Bno);
        book1.setBname(Bname);
        book1.setBauthor(Bauthor);
        book1.setBsource(Bsource);
        book1.setBedition(Bedition);
        book1.setBprice(Bprice);
//       book1.setBnum(Bnum);
       book1.setTno(Tno);
        book1.setCcno(CCno);
        book.addBook(book1);
        showAllBooksToTeacher(request,response);
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Bno = request.getParameter("Bno");
        System.out.println(Bno);
        book.deleteBook(Bno);
        showAllBooksToTeacher(request, response);
    }
    private void deleteBookByManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Bno = request.getParameter("Bno");
        System.out.println(Bno);
        book.deleteBook(Bno);
        showAllBooks(request, response);
    }

    private void showAllBooksToTeacherA(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = book.getBookkall();
        request.setAttribute("books", books);
        //页面
        request.getRequestDispatcher("/teacher_look_allbook.jsp").forward(request, response);
    }

    private void showAllBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = book.getBookkall();
        request.setAttribute("books", books);
        //页面
        request.getRequestDispatcher("/manager_book_management.jsp").forward(request, response);
    }

    private void showAllBooksToTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Teacher teacher = (Teacher) session.getAttribute("user");
//        ReserveDao re  = new ReserveDaoImpl();
        String tno = teacher.getTno();


        List<Book> books = book.getBookkall(tno);
        request.setAttribute("books", books);
        for(Book book:books){
            System.out.println(book.toString());
        }
        //页面
        request.getRequestDispatcher("/teacher_book_management.jsp").forward(request, response);
    }


    private void showAllBooksToMonitor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = book.getBookAll();
        request.setAttribute("books", books);
        //页面
        request.getRequestDispatcher("/monitor_book_reserve.jsp").forward(request, response);
    }


    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Bno = request.getParameter("Bno");
        String Bname = request.getParameter("Bname");
        String Bauthor = request.getParameter("Bauthor");
        String Bsource = request.getParameter("Bsource");
        String Bedition = request.getParameter("Bedition");
        String Bprice = request.getParameter("Bprice");
        //int Bnum = Integer.parseInt(request.getParameter("Bnum"));
       // String Tno = request.getParameter("Tno");
        String CCno = request.getParameter("CCno");
        Book book1 = new Book();
        book1.setBno(Bno);
        book1.setBname(Bname);
        book1.setBauthor(Bauthor);
        book1.setBsource(Bsource);
        book1.setBedition(Bedition);
        book1.setBprice(Bprice);
      //  book1.setBnum(Bnum);
        //book1.setTno(Tno);
        book1.setCcno(CCno);
        book.updateBook(book1);
        System.out.println(book1.getBedition());
        showAllBooksToTeacher(request, response);

    }
    private void updateBookByManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Bno = request.getParameter("bno");
        String Bnum =request.getParameter("number");
        Book book1 = new Book();
        book1.setBno(Bno);
        book1.setBnum(Bnum);
        book.updateBook(Bno,Bnum);
        showAllBooks(request, response);
    }

//    private void getFindBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Book> books = book.getBookkall();
//        request.setAttribute("books", books);
//        //页面
//        request.getRequestDispatcher("/book_find.jsp").forward(request, response);
//    }



}
