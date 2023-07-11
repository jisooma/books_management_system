package com.javaweb.demo.servlet;

import com.javaweb.demo.dao.TeacherDao;
import com.javaweb.demo.dao.impl.TeacherDaoImpl;
import com.javaweb.demo.entity.Teacher;
import com.javaweb.demo.entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
    TeacherDao teacher = new TeacherDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String option = request.getParameter("option");
        if ("deleteTeacher".equals(option)) {
            deleteTeacher(request, response);
        } else if ("showAllTeachers".equals(option)) {
            showAllTeachers(request, response);
        } else if ("addTeacher".equals(option)) {
            addTeacher(request, response);
        } else if ("updateTeacherByManager".equals(option)) {
            updateTeacherByManager(request, response);
        } else if ("FindTeacher".equals(option)) {
         FindTeacher(request, response);
    }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }

    private void showAllTeachers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Teacher> teachers =teacher.getTeacherAll();
        request.setAttribute("teachers",teachers );
        request.getRequestDispatcher("manager_teacher_management.jsp").forward(request, response);
    }

    private void deleteTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        teacher.deleteTeacher(id);
        showAllTeachers(request, response);
    }

    private void updateTeacherByManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tno = request.getParameter("tno");
        String name = request.getParameter("name");
        String dept = request.getParameter("dept");
        String tel = request.getParameter("tel");
        String email = request.getParameter("email");
        String cno = request.getParameter("cno");
        //String password = request.getParameter("password");
        Teacher te= new Teacher();
        te.setTno(tno);
        te.setTname(name);
        te.setTdept(dept);
        //te.setPassword(password);
        te.setTtel(tel);
        te.setTcno(cno);
        te.setTemail(email);
        System.out.println(te.getTcno());
        teacher.updateTeacher(te);
        showAllTeachers(request, response);
    }
    private void FindTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Tno = request.getParameter("Tno");
        String Tname= request.getParameter("Tname");
        String Tdept = request.getParameter("Tdept");
        String CCno= request.getParameter("Cno");
        Teacher te =new Teacher();
        te.setTno(Tno);
        te.setTname(Tname);
        te.setTdept(Tdept);
        te.setTcno(CCno);

        List<Teacher> teachers =teacher.topQuery(te);
        request.setAttribute("teachers",teachers );
        request.getRequestDispatcher("manager_teacher_management.jsp").forward(request, response);
    }

    private void addTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("Tno");
        String name = request.getParameter("Tname");
        String dept = request.getParameter("Tdept");
        String tel = request.getParameter("Ttel");
        String email = request.getParameter("Temail");
        String cno = request.getParameter("CCno");
        String pwd = request.getParameter("password");
        Teacher td = new Teacher();
        td.setTno(id);
        td.setTname(name);
        td.setTdept(dept);
        td.setTemail(email);
        td.setTcno(cno);
        td.setPassword(pwd);
        td.setTtel(tel);
        System.out.println(td.getTcno());
        teacher.addTeacher(td);
        showAllTeachers(request, response);
    }
}

