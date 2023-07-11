package com.javaweb.demo.dao;

import com.javaweb.demo.entity.Book;


import java.util.List;

public interface BookDao {
    public boolean addBook(Book book);//增加教材
    public boolean deleteBook(String bno) ;//根据书号删除教材
    public boolean updateBook(String bno, String bname, String bauthor, String bsource, String bedition, String bprice, String bnum, String ccno) ;//更新教材信息
    public List<Book> getBookkall(String tno);//查询全部教材的信息
    public List<Book> getBookkall();//查询全部教材的信息
    public List<Book> getBookbno(String bno);//书号查询教材信息
    public List<Book> getBookbna(String bna);//书名查询教材信息
    public List<Book> getBooksau(String bauthor);//作者查询教材信息
    public List<Book> getBooksed(String bsource);//出版社查询教材信息
    public List<Book> getBooksc(String ccno);//课程查询教材信息
    public boolean updateBook(Book bo);
    public Book getBookBybno(String bno);//通过课程号查询
    public List<Book> getBookAll();//包含老师信息
    public boolean updateBook(String bno,String bnum);
    public List<Book> topQuery(Book book);



}
