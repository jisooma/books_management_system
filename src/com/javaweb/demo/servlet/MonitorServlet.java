package com.javaweb.demo.servlet;

import com.javaweb.demo.dao.MonitorDao;
import com.javaweb.demo.dao.impl.MonitorDaoImpl;
import com.javaweb.demo.entity.Monitor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/MonitorServlet")
public class MonitorServlet extends HttpServlet{

    private MonitorDao monitor = new MonitorDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String option = request.getParameter("option");
        if ("addMonitor".equals(option)) {
            addMonitor(request, response);
        } else if ("showAllMonitor".equals(option)) {
            showAllMonitor(request, response);
        } else if ("deleteMonitor".equals(option)) {
            deleteMonitor(request, response);
        } else if ("updateMonitor".equals(option)) {
            updateMonitor(request, response);
        }
        else if ("FindMonitorByCno".equals(option)) {
            System.out.println("Cno");
        FindMonitorByCno(request, response);
        }
        else if ("FindMonitorByCdept".equals(option)) {
//            FindMonitorByCdept(request, response);
        }
        else if ("FindMonitorByCdeptandCgrade".equals(option)) {
//            FindMonitorByCdeptandCgrade(request, response);
        }
        else if ("showFindMonitor".equals(option)) {
            showFindMonitor(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
        System.out.println( request.getParameter("cls.cno"));
    }

    private void addMonitor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String Cno = request.getParameter("Cno");
        String Cgrade = request.getParameter("Cgrade");
        String Cdept = request.getParameter("Cdept");
        String Cmajor = request.getParameter("Cmajor");
        String  Cnum = request.getParameter("Cnum");
        String password = request.getParameter("password");
        Monitor monitor1 = new Monitor();
        monitor1.setCno(Cno);
        monitor1.setCgrade(Cgrade);
        monitor1.setCdept(Cdept);
        monitor1.setCmajor(Cmajor);
        monitor1.setCnum(Cnum);
        monitor1.setPassword(password);
        monitor.addMonitor(monitor1);
        showAllMonitor(request, response);
    }

    private void deleteMonitor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Cno = request.getParameter("id");
        System.out.println(Cno);
        monitor.delete(Cno);
        showAllMonitor(request, response);
    }
    private void FindMonitorByCno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Cno = request.getParameter("Cno");
        System.out.println(Cno);
        String Cdept = request.getParameter("Cdept");
        System.out.println(Cdept);
        String Cgrade = request.getParameter("Cgrade");
        System.out.println(Cgrade);
        String Cmajor = request.getParameter("Cmajor");
        System.out.println(Cmajor);
       // String Cnum = request.getParameter("Cnum");

        //System.out.println(Cnum);
        Monitor monitor1 = new Monitor();
        monitor1.setCno(Cno);
        monitor1.setCdept(Cdept);
        monitor1.setCgrade(Cgrade);
        monitor1.setCmajor(Cmajor);
        //monitor1.setCnum(Integer.parseInt(Cnum));

        List<Monitor> monitors = monitor.topQuery(monitor1);

        request.setAttribute("monitors", monitors);
        //页面
        request.getRequestDispatcher("/manager_monitor_find.jsp").forward(request, response);


    }

//    private void FindMonitorByCdept(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String Cdept = request.getParameter("Cdept");
//        List<Monitor> monitors = monitor.findMonitorByCdept(Cdept);
//        request.setAttribute("monitors", monitors);
//        //页面
//        request.getRequestDispatcher("/manager_monitor_find.jsp").forward(request, response);
//    }
//
//    private void FindMonitorByCdeptandCgrade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String Cdept = request.getParameter("Cdept");
//        String Cgrade = request.getParameter("Cgrade");
//        List<Monitor> monitors = monitor.findMonitorByCdeptandCgrade(Cdept,Cgrade);
//        request.setAttribute("monitors", monitors);
//        //页面
//        request.getRequestDispatcher("/manager_monitor_find.jsp").forward(request, response);
//    }



    private void showAllMonitor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Monitor> monitors = monitor.getMonitorAll();

        request.setAttribute("monitors", monitors);
        //页面
        request.getRequestDispatcher("/manager_monitor_management.jsp").forward(request, response);
    }
    private void showFindMonitor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Monitor> monitors = monitor.getMonitorAll();
        request.setAttribute("monitors", monitors);
        //页面
        request.getRequestDispatcher("/manager_monitor_find.jsp").forward(request, response);
    }


    private void updateMonitor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Cno = request.getParameter("Cno");
        String Cgrade = request.getParameter("Cgrade");
        String Cdept = request.getParameter("Cdept");
        String Cmajor = request.getParameter("Cmajor");
        String Cnum = request.getParameter("Cnum");
        String password = request.getParameter("password");
        System.out.println(Cno);
        System.out.println(Cgrade);
        System.out.println(Cdept);
        System.out.println(Cmajor);
        System.out.println(Cnum);
        Monitor monitor1 = new Monitor();
        monitor1.setCno(Cno);
        monitor1.setCgrade(Cgrade);
        monitor1.setCdept(Cdept);
        monitor1.setCmajor(Cmajor);
        monitor1.setCnum(Cnum);
        monitor1.setPassword(password);
         monitor.update(monitor1);
        showAllMonitor(request, response);
    }


}
