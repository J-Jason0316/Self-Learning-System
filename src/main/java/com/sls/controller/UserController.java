package com.sls.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.sls.service.UserService;
import com.sls.util.ReturnDataInit;
import com.sls.vo.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService	userService;
	@Autowired
	private	ReturnDataInit returnDataInit;

	/**
	 * 用户登录API
	 * @param user
	 * @return JSONObject
	 * 
	 * */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	@ResponseBody
	public JSONObject login(@RequestBody User user,HttpServletRequest req) {
		
		System.out.println(user.getUserId());
		
		JSONObject jsonObject = returnDataInit.initSetting();
        
		User u = userService.userLogin(user.getUserId());
		
		System.out.println(u.getUserPassword());
		//判断用户是否存在
		if(u == null) {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "密码输入错误，请重试");
			
		} else{
			//密码比对
			if(user.getUserPassword().equals(u.getUserPassword())) {
				req.getSession().setAttribute("user", u);
				jsonObject.put("code", 0);
				jsonObject.put("data", u);
				jsonObject.put("msg", "登录成功");
			} else {
				jsonObject.put("code", 1);
				jsonObject.put("msg", "密码输入错误，请重试");
			}
		}
		
		return jsonObject;
	}
	
	/**
	 * 用户登录状态检查
	 * @param null
	 * @return boolean
	 * */	
//	@RequestMapping(value = "/loginStatus" , method = RequestMethod.GET)
//	public boolean userLoginCheck(HttpServletRequest req) {		
//		
//		User user = (User)req.getSession().getAttribute("user");
//		
//		boolean status = false; 
//		if (user != null) {
//			return status = true;
//		}	
//		return status;
//	}
	
	/**
	 * 注销用户
	 * @param null
	 * @return boolean
	 * */
	@RequestMapping(value = "/logout" , method = RequestMethod.GET)
	@ResponseBody
	public JSONObject userLogoutCheck(HttpServletRequest req) {	
		
		JSONObject jsonObject = returnDataInit.initSetting();
		
		boolean status = false;
		try {
			req.getSession().removeAttribute("user");
			status = true;
			jsonObject.put("status",status);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsonObject.put("status",status);
		System.out.println(jsonObject);
		return jsonObject;
	}
	
}
