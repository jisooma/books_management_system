package com.javaweb.demo.servlet;

import com.javaweb.demo.dao.AdminDao;
import com.javaweb.demo.dao.MonitorDao;
import com.javaweb.demo.dao.TeacherDao;
import com.javaweb.demo.dao.impl.AdiminDaoImpl;
import com.javaweb.demo.dao.impl.MonitorDaoImpl;
import com.javaweb.demo.dao.impl.TeacherDaoImpl;
import com.javaweb.demo.entity.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ModifyInfoServlet")
public class ModifyInfoServlet extends HttpServlet {
    AdminDao ad = new AdiminDaoImpl();
    TeacherDao te = new TeacherDaoImpl();
    MonitorDao mo = new MonitorDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String option = request.getParameter("option");
        if ("updateManagerInfo".equals(option)) {
            updateManagerInfo(request, response);
        } else if ("updateTeacherInfo".equals(option)) {
            updateTeacherInfo(request, response);
        }else if ("updateMonitorInfo".equals(option)) {
            updateMonitorInfo(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    private void updateManagerInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean flag  =false;
        String Mno = request.getParameter("mno");
        String Mname = request.getParameter("mname");
        String Mtel = request.getParameter("mtel");
        String Memail = request.getParameter("memail");
        flag=ad.updateInfo(Mno, Mname, Mtel,Memail);
        if(flag){
            request.setAttribute("msg","修改成功" );
            request.getRequestDispatcher("manager_index.jsp").forward(request, response);
        }
        else {
            request.setAttribute("msg","修改失败" );
//            request.getRequestDispatcher("manager_modify_info.jsp").forward(request, response);
            response.sendRedirect(getServletContext().getContextPath()+"/manager_modify_info.jsp");
        }


    }

    private void updateTeacherInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean flag  =false;
        String Tno = request.getParameter("tno");
        String name = request.getParameter("name");
        String dept = request.getParameter("dept");
        String tel = request.getParameter("tel");
        String email = request.getParameter("email");
        te.updateTeacher( Tno, name, dept,  tel,  email);
        if(flag){
            request.setAttribute("msg","修改成功" );
            request.getRequestDispatcher("teacher_index.jsp").forward(request, response);
        }
        else {
            request.setAttribute("msg","修改失败" );
            request.getRequestDispatcher("teacher_modify_info.jsp").forward(request, response);
        }

    }

    private void updateMonitorInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean flag  =false;
        String Cno = request.getParameter("cno");
        String cnum = request.getParameter("cnum");
        mo.update(Cno,cnum);
        if(flag){
            request.setAttribute("msg","修改成功" );
            response.sendRedirect(getServletContext().getContextPath()+"/manager_modify_info.jsp");
        }
        else {
            request.setAttribute("msg","修改失败" );
            request.getRequestDispatcher("monitor_modify_info.jsp").forward(request, response);
        }
    }

}
