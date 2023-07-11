package com.javaweb.demo.servlet;

import com.javaweb.demo.dao.AdminDao;
import com.javaweb.demo.dao.MonitorDao;
import com.javaweb.demo.dao.TeacherDao;

import com.javaweb.demo.dao.impl.AdiminDaoImpl;
import com.javaweb.demo.dao.impl.MonitorDaoImpl;
import com.javaweb.demo.dao.impl.TeacherDaoImpl;
import com.javaweb.demo.entity.Admin;
import com.javaweb.demo.entity.Monitor;
import com.javaweb.demo.entity.Teacher;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet {
            TeacherDao te = new TeacherDaoImpl();
        AdminDao ad = new AdiminDaoImpl();
        MonitorDao mo = new MonitorDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String option = request.getParameter("option");
        if ("signIn".equals(option)) {
            signIn(request, response);
        }else if ("quit".equals(option)){
            quit(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    private void signIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("manager".equals(type)) {
            //用户为管理员
            Admin admin = ad.FindAdmin(username);
            if (admin == null) {
                //用户不存在
                String msg = "用户不存在";
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("sign-in.jsp").forward(request, response);
                return;
            } else if (admin.getMno().equals(username) &&admin.getPassword().equals(password)){
                //账号密码正确
                HttpSession session = request.getSession();
                session.setAttribute("user", admin);
                response.sendRedirect(getServletContext().getContextPath()+"/manager_index.jsp");
                return;
            } else {
                //密码错误
                String msg = "密码错误";
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("sign-in.jsp").forward(request, response);
                return;
            }
        }
        if ("teacher".equals(type)) {

            //用户为教师

            Teacher teacher = te.FindTeacher(username);

            if (teacher == null) {
                //用户不存在
                String msg = "用户不存在";
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("sign-in.jsp").forward(request, response);
                return;
            } else if (teacher.getTno().equals(username) && teacher.getPassword().equals(password)){
                //账号密码正确

                HttpSession session = request.getSession();
                session.setAttribute("user", teacher);
                response.sendRedirect(getServletContext().getContextPath()+"/teacher_index.jsp");
                return;
            } else {
                //密码错误
                String msg = "密码错误";
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("sign-in.jsp").forward(request, response);
                return;
            }
        }
        if ("monitor".equals(type)) {
            //用户为教师
            Monitor monitor = mo.findMonitorByCno1(username);
            if (monitor == null) {
                //用户不存在
                String msg = "用户不存在";
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("sign-in.jsp").forward(request, response);
                return;
            } else if (monitor.getCno().equals(username) && monitor.getPassword().equals(password)){
                //账号密码正确

                HttpSession session = request.getSession();
                session.setAttribute("user", monitor);
                response.sendRedirect(getServletContext().getContextPath()+"/monitor_index.jsp");
                return;
            } else {
                //密码错误
                String msg = "密码错误";
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("sign-in.jsp").forward(request, response);
                return;
            }
        }

    }


    private void quit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        response.sendRedirect("sign-in.jsp");
    }

}
