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

@WebServlet("/ModifyPwdServlet")
public class ModifyPwdServlet extends HttpServlet {
    AdminDao ad = new AdiminDaoImpl();
    TeacherDao te = new TeacherDaoImpl();
    MonitorDao mo = new MonitorDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String option = request.getParameter("option");
        if ("updateManagerPwd".equals(option)) {
            updateManagerPwd(request, response);
        } else if ("updateTeacherPwd".equals(option)) {
            updateTeacherPwd(request, response);
        }else if ("updateMonitorPwd".equals(option)) {
            updateMonitorPwd(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    private void updateManagerPwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session1 = request.getSession();
        Admin admin = (Admin) session1.getAttribute("user");
        String oldPwd=request.getParameter("oldpwd");
        String newPwd=request.getParameter("newpwd");
        String rnewPwd=request.getParameter("rnewpwd");

        if(!(newPwd.equals(rnewPwd))){
            session1.setAttribute("changePwdError","您两次输入的新密码不一致，请重新输入...");
            request.getRequestDispatcher("manager_modify_pwd.jsp").forward(request, response);
            return;
        }
        if(!(oldPwd.equals(admin.getPassword()))){
            session1.setAttribute("changePwdErr","您输入的原密码不正确，请重新输入...");
            request.getRequestDispatcher("manager_modify_pwd.jsp").forward(request, response);
            return;
        }

        String pwd1 = request.getParameter("newpwd" );
        AdminDao ad = new AdiminDaoImpl();
        boolean flag =ad.modifyPwd(admin.getMno(),newPwd);
        if(flag){
            request.setAttribute("msg0","修改成功,你已修改密码请重新登录!" );
            response.sendRedirect(getServletContext().getContextPath()+"/login.jsp");
        }
        else {
            request.setAttribute("msg1","修改失败" );
            request.getRequestDispatcher("manager_modify_pwd.jsp").forward(request, response);
        }
    }

    private void updateTeacherPwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean flag  =false;
        HttpSession session1 = request.getSession();
        Teacher teacher = (Teacher) session1.getAttribute("user");
        String oldPwd=request.getParameter("oldpwd");
        String newPwd=request.getParameter("newpwd");
        String rnewPwd=request.getParameter("rnewpwd");
        //String pwd1 = request.getParameter("newpwd" );

        if(!(newPwd.equals(rnewPwd))){
            session1.setAttribute("changePwdError","您两次输入的新密码不一致，请重新输入...");
            request.getRequestDispatcher("teacher_modify_pwd.jsp").forward(request, response);
            return;
        }
        if(!(oldPwd.equals(teacher.getPassword()))){
            session1.setAttribute("changePwdErr","您输入的原密码不正确，请重新输入...");
            request.getRequestDispatcher("teacher_modify_pwd.jsp").forward(request, response);

            return;
        }
        String id =teacher.getTno();
        flag=te.modifyPwd(id,newPwd);

        if(flag){
            request.setAttribute("msg","修改成功,你已修改密码请重新登录!" );
            response.sendRedirect(getServletContext().getContextPath()+"/login.jsp");
        }
        else {
            request.setAttribute("msg","修改失败" );
            request.getRequestDispatcher("teacher_modify_Pwd.jsp").forward(request, response);
        }

    }

    private void updateMonitorPwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session1 = request.getSession();
        Monitor monitor  = (Monitor) session1.getAttribute("user");
        String oldPwd=request.getParameter("oldpwd");
        String newPwd=request.getParameter("newpwd");
        String rnewPwd=request.getParameter("rnewpwd");
        boolean flag  =false;
        if(!(newPwd.equals(rnewPwd))){
            session1.setAttribute("changePwdError","您两次输入的新密码不一致，请重新输入...");
            request.getRequestDispatcher("manager_modify_pwd.jsp").forward(request, response);
            return;
        }
        if(!(oldPwd.equals(monitor.getPassword()))){
            session1.setAttribute("changePwdErr","您输入的原密码不正确，请重新输入...");
            request.getRequestDispatcher("manager_modify_pwd.jsp").forward(request, response);
            return;
        }
        if(flag){
            request.setAttribute("msg","修改成功" );
            response.sendRedirect(getServletContext().getContextPath()+"/monitor_modify_pwd.jsp");
        }
        else {
            request.setAttribute("msg","修改失败" );
            request.getRequestDispatcher("monitor_modify_Pwd.jsp").forward(request, response);
        }
    }
}
