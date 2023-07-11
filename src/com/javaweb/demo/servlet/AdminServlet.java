package com.javaweb.demo.servlet;

import com.javaweb.demo.dao.TeacherDao;

import com.javaweb.demo.dao.impl.TeacherDaoImpl;

import com.javaweb.demo.entity.Teacher;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        }
    }


