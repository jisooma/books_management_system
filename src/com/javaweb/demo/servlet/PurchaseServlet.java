package com.javaweb.demo.servlet;

import com.javaweb.demo.dao.BookDao;
import com.javaweb.demo.dao.PurchaseDao;
import com.javaweb.demo.dao.impl.BookDaoimpl;
import com.javaweb.demo.dao.impl.PurchaseDaoImpl;
import com.javaweb.demo.entity.Book;
import com.javaweb.demo.entity.Purchase;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
    PurchaseDao pc = new PurchaseDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String option = request.getParameter("option");
        if ("addPurchase".equals(option)) {
            addPurchase(request, response);
        }  else if ("deletePurchase".equals(option)) {
            deletePurchase(request, response);
        } else if ("updatePurchase".equals(option)) {
            updatePurchase(request, response);
        } else if ("showPurchase".equals(option)) {
            showPurchase(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    private void addPurchase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Pnumber = (String)request.getAttribute("number");
        String Bno = (String)request.getAttribute("bno");
        BookDao bo = new BookDaoimpl();
        Book book = bo.getBookBybno(Bno);

        Purchase purchase = new Purchase();
        purchase.setBno(book.getBno());
        purchase.setBname(book.getBname());
        purchase.setBauthor(book.getBauthor());
        purchase.setBsource(book.getBsource());
        purchase.setBprice(book.getBprice());
        purchase.setNumber(Integer.parseInt(Pnumber));
       // pc.addPurchase(purchase);
        showPurchase(request, response);
    }

    private void deletePurchase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
    private void updatePurchase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
    private void showPurchase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Purchase> Purchases;
        Purchases = pc.getAllPurchase();
        request.setAttribute("purchases", Purchases);
        request.getRequestDispatcher("manager_deal_purchase.jsp").forward(request, response);
    }






}
