package com.javaweb.demo.dao;

import com.javaweb.demo.entity.Reserve;

import java.util.List;

public interface ReserveDao {

    public Boolean addReserve(Reserve re);
    public boolean deleteReserve(String id);
    public boolean updateReserve(Reserve re);
    public int findMaxId();
    public List<Reserve> findReserveByBno(String Bno);
    public List<Reserve> findReserveByCno(String Cno);
    public List<Reserve> findReserveByStatus(String status);
    public boolean updateReserveById(String id,int rnum);
    public List<Reserve> findAllReserve();
    public List<Reserve> findUnDealReserve();
    public Reserve findOrderById(String id);
}
