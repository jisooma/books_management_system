package com.javaweb.demo.servlet;

import com.javaweb.demo.dao.BookDao;
import com.javaweb.demo.dao.CourseDao;
import com.javaweb.demo.dao.impl.BookDaoimpl;
import com.javaweb.demo.dao.impl.CourseDaoImpl;
import com.javaweb.demo.entity.Book;
import com.javaweb.demo.entity.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
    private CourseDao course = new CourseDaoImpl();
    private BookDao book = new BookDaoimpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String option = request.getParameter("option");
       if ("showAllCourses".equals(option)) {
            showAllCourses(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    private void showAllCourses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Course> courses = course.getCourseAll();
        request.setAttribute("courses", courses);
//        System.out.println("111111");
        //页面
        request.getRequestDispatcher("/teacher_course.jsp").forward(request, response);
    }


}
