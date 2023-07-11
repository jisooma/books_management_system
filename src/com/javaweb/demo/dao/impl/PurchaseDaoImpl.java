package com.javaweb.demo.dao.impl;

import com.javaweb.demo.dao.PurchaseDao;
import com.javaweb.demo.entity.Book;
import com.javaweb.demo.entity.Purchase;
import com.javaweb.demo.entity.Purchase;
import com.javaweb.demo.util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDaoImpl implements PurchaseDao {

//    @Override
//    public boolean addPurchase(Purchase purchase) {
//        boolean flag = false;
////        DBconn.init();
////        int i = DBconn.addUpdDel("insert into Purchase(Bno,Bname,Bauthor,Bsource,Bedition,Bprice,BNumber) " +
////                "values('" + purchase.getBno()+ "','" + purchase.getBname()+ "','" + purchase.getBauthor()+ "','" + purchase.getBsource()+ "','" + purchase.getBedition()+ "','" + purchase.getBprice()+"','" +purchase.getNumber()+ "')");
////        if (i > 0) {
////            flag = true;
////        }
////        DBconn.closeConn();
//        return flag;
//    }


    @Override
    public List<Purchase> getAllPurchase() {
        {
            List<Purchase> list = new ArrayList<Purchase>();
            try {
                DBconn.init();
                ResultSet rs = DBconn.selectSql("select * from Purchase");
                while(rs.next()){
                    Purchase Purchase =  new Purchase();
                    Purchase.setBno(rs.getString("Bno"));
                    Purchase.setBname(rs.getString("Bname"));
                    Purchase.setBauthor(rs.getString("Bauthor"));
                    Purchase.setBsource(rs.getString("Bsource"));
                    Purchase.setBedition(rs.getString("Bedition"));
                    Purchase.setBprice(rs.getString("Bprice"));
                    Purchase.setNumber(rs.getInt("BNumber"));
                    list.add(Purchase);
                }
                DBconn.closeConn();
                return list;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}