package com.sls.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.sls.service.CourseService;
import com.sls.util.ReturnDataInit;
import com.sls.vo.Course;

@Controller
@RequestMapping("course")
public class CourseController {
	@Autowired
	private  CourseService courseService;
	@Autowired
	private	ReturnDataInit returnDataInit;
	
	/**
	 * 获取所有科目
	 * @param null
	 * @return List
	 * */
	@RequestMapping(value = "/getAllCourse", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getAllCourse() {
		
		JSONObject jsonObject = returnDataInit.initSetting();
		
		List<Course> courseList = courseService.getAllCourse();
		
		if (courseList.size() != 0) {
        	jsonObject.put("data", courseList);  	
		} else {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;		
	}
	
	/**
	 * 根据courseId获取相应科目
	 * @param courseId
	 * @return JSONObject
	 * */
	@RequestMapping(value = "/getCourseByCourseId", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getCourseByCourseId(int courseId) {
		
		JSONObject jsonObject = returnDataInit.initSetting();
		
		Course course = courseService.getCourseByCourseId(courseId);
		
		if (course != null) {
        	jsonObject.put("data", course);
		} else {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;	
	}
	
}
