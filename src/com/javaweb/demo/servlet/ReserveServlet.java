package com.javaweb.demo.servlet;


import com.javaweb.demo.dao.BookDao;
import com.javaweb.demo.dao.MonitorDao;
import com.javaweb.demo.dao.ReserveDao;
import com.javaweb.demo.dao.impl.BookDaoimpl;
import com.javaweb.demo.dao.impl.MonitorDaoImpl;
import com.javaweb.demo.dao.impl.ReserveDaoImpl;
import com.javaweb.demo.entity.Book;
import com.javaweb.demo.entity.Monitor;
import com.javaweb.demo.entity.Reserve;
import com.javaweb.demo.entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/ReserveServlet")
public class ReserveServlet extends HttpServlet {

    ReserveDao re = new ReserveDaoImpl();
    BookDao bo =  new BookDaoimpl();
    MonitorDao mo= new MonitorDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String option = request.getParameter("option");
        if ("addReserve".equals(option)) {
            addReserve(request, response);
        } else if ("showReserveMonitor".equals(option)) {
            showReserveMonitor(request, response);
        } else if ("deleteReserve".equals(option)) {
            deleteReserve(request, response);
        } else if ("updateReserve".equals(option)) {
            updateReserve(request, response);
        } else if ("showReserveManager".equals(option)) {
            showReserveManager(request, response);
        } else if ("showUnDealReserve".equals(option)) {
            showUnDealReserve(request, response);
        } else if ("dealPage".equals(option)) {
            dealPage(request, response);
        } else if ("updateReserveByMonitor".equals(option)) {
        updateReserveByMonitor(request, response);
    }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    private void showReserveMonitor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Monitor monitor = (Monitor) session.getAttribute("user");
        ReserveDao re  = new ReserveDaoImpl();
        String cno = monitor.getCno();
        List<Reserve> reserves =  new ArrayList<Reserve>();
        reserves = re.findReserveByCno(cno) ;
        for(Reserve re1:reserves){
            System.out.println(re1.toString());
        }
        request.setAttribute("Reserves", reserves);
        request.getRequestDispatcher("monitor_book_reservedeal.jsp").forward(request, response);
    }
    private void addReserve(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cno = request.getParameter("cno");
        String bno = request.getParameter("bno");
        BookDao bo = new BookDaoimpl();
        Book book =  bo.getBookBybno(bno);
        double price =  Double.parseDouble(book.getBprice());
        String number = request.getParameter("rnum");
        int num = Integer.parseInt(number);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String r_time = format.format(date);
        Reserve Reserve = new Reserve();
        Reserve.setBstatus("未发放");

        Reserve.setId(Integer.toString(re.findMaxId()+1));
        Reserve.setBno(bno);
        Reserve.setCno(cno);
        Reserve.setR_time(r_time);
        System.out.println(r_time);
        Reserve.setNum(num);
        Reserve.setTotalPrice(num*price);
        ReserveDao re = new ReserveDaoImpl();
        re.addReserve(Reserve);
        showReserveMonitor(request, response);

    }

    private void updateReserveByMonitor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        String rnum=request.getParameter("rnum");
//        System.out.println(id);
//        System.out.println(rnum);
        Boolean flag = re.updateReserveById(id,Integer.parseInt(rnum));
        System.out.println(flag);
        if(flag){
            request.setAttribute("msg","修改成功" );
            showReserveMonitor(request, response);
        }
        else {
            request.setAttribute("msg","修改失败" );
            showReserveMonitor(request, response);
        }
    }

    private void showReserveManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Reserve> Reserves;
        Reserves = re.findAllReserve();
        request.setAttribute("Reserves", Reserves);
        request.getRequestDispatcher("manager_all-book-reserve.jsp").forward(request, response);
    }



    private void deleteReserve(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Boolean flag = re.deleteReserve(id);
        if(flag){
            request.setAttribute("msg","修改成功" );
            showReserveMonitor(request, response);
        }
        else {
            request.setAttribute("msg","修改失败" );
            showReserveMonitor(request, response);
        }
    }

    private void showUnDealReserve(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Reserve> Reserves;
        Reserves = re.findUnDealReserve();
        request.setAttribute("Reserves", Reserves);
        request.getRequestDispatcher("manager_undeal_book_reserve.jsp").forward(request, response);
    }
//    private void updateReserve(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //订单id号
//        String id = request.getParameter("id");
//        String place = request.getParameter("place");
//        String q_time = request.getParameter("q_time");
//        Reserve Reserve = re.findOrderById(id);
//        int needNumber =Reserve.getNum();
//
//        BookDao bo = new BookDaoimpl();
//        String bno = Reserve.getBno();
//
//        Book book = bo.getBookBybno(bno);
//
//        int book_number = Integer.parseInt(book.getBnum());
////        System.out.println(book_number);
//
//        if (needNumber <= book_number) {
//            int bnum=book_number - needNumber;
//            //订单的需求小于书的数量
//            Reserve.setPlace(place);
//            Reserve.setQ_time(q_time);
//            Reserve.setBstatus("已处理");
//            book.setBnum(Integer.toString(bnum));
//            bo.updateBook(book);
//            re.updateReserve(Reserve);
//            request.getRequestDispatcher("ReserveServlet?option=showReserveManager").forward(request, response);
//        } else {
//            //订单的需求大于书的数量
////            String pnumber = Integer.toString(needNumber-book_number);
////            request.setAttribute("number", pnumber);
////            request.setAttribute("bno", bno);
//            request.setAttribute("msg", "书的数量不足，请补充书本");
//            request.getRequestDispatcher("manager_all_book_reserve.jsp").forward(request, response);
//        }
//    }

    /**
     * 处理订单
     */
    private void updateReserve(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //订单id号
        String id = request.getParameter("id");
        String place = request.getParameter("place");
//        System.out.println(place);
//        System.out.println(id);
        String q_time = request.getParameter("q_time");
        Reserve Reserve = re.findOrderById(id);
        int needNumber =Reserve.getNum();

        BookDao bo = new BookDaoimpl();
        String bno = Reserve.getBno();
        Book book = bo.getBookBybno(bno);
       // int book_number = Integer.parseInt(book.getBnum());
        int book_number =Integer.valueOf(book.getBnum()).intValue();
//        System.out.println(book_number);

        if (needNumber <= book_number) {
            int bnum=book_number - needNumber;
            //订单的需求小于书的数量
            Reserve.setPlace(place);
            Reserve.setQ_time(q_time);
            Reserve.setBstatus("已处理");
            book.setBnum(Integer.toString(bnum));
            bo.updateBook(book);
            re.updateReserve(Reserve);
            request.getRequestDispatcher("ReserveServlet?option=showReserveManager").forward(request, response);
        } else {
            //订单的需求大于书的数量
            request.setAttribute("bookReserve", Reserve);
            request.setAttribute("msg", "书的数量不足，请补充书本");
            request.getRequestDispatcher("manager-deal-reserve.jsp").forward(request, response);
        }
    }

    private void dealPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //订单id号
        String id=request.getParameter("id");
        System.out.println(id);
        Reserve Reserve = re.findOrderById(id);
        request.setAttribute("bookReserve", Reserve);
        request.getRequestDispatcher("manager-deal-reserve.jsp").forward(request, response);
    }
}
