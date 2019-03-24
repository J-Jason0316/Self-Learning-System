package com.sls.service;

import java.util.List;

import com.sls.vo.Course;

public interface CourseService {

	/**
	 * 获取所有科目
	 * @param null
	 * @return List
	 * */
	List<Course> getAllCourse();
	
	/**
	 * 根据courseId获取相应科目
	 * @param courseId
	 * @return Course
	 * */
	Course getCourseByCourseId(int courseId);
}
