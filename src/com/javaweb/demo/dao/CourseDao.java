package com.javaweb.demo.dao;

import com.javaweb.demo.entity.Course;
import com.javaweb.demo.entity.Teacher;

import java.util.List;

public interface CourseDao {
    public List<Course> getCourseAll();//返回所有老师信息集合
    public Course FindCourse(String cno);

}
