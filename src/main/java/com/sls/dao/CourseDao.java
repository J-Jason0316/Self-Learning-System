package com.sls.dao;

import java.util.List;

import com.sls.vo.Course;

public interface CourseDao {
    int deleteByPrimaryKey(Integer courseId);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer courseId);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
    
   /*****************************/
    List<Course> selectAllCourse();
}