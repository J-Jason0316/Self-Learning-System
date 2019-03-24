package com.sls.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sls.dao.CourseDao;
import com.sls.service.CourseService;
import com.sls.vo.Course;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseDao courseDao;
	
	/**
	 * 获取所有科目
	 * @param null
	 * @return List
	 * */
	public List<Course> getAllCourse() {
		return courseDao.selectAllCourse();	
	}
	
	/**
	 * 根据courseId获取相应科目
	 * @param courseId
	 * @return Course
	 * */
	public  Course getCourseByCourseId(int courseId) {
		return courseDao.selectByPrimaryKey(courseId);
	}
}
