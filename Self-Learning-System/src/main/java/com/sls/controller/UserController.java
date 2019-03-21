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
import com.sls.vo.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService	userService;

	/**
	 * 用户登录API
	 * @param user
	 * @return JSONObject
	 * 
	 * */
	
	@ResponseBody
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public JSONObject userLogin(@RequestBody User user, HttpServletRequest req) {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
        jsonObject.put("data", null);
        jsonObject.put("msg", null);
        
		User u = userService.userLogin(user.getUserId());
		//判断用户是否存在
		if(u != null) {
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
			
		} else {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "该账户不存在，您可以尝试注册");
		}

		return jsonObject;
	}
	
	/**
	 * 用户登录状态检查
	 * @param null
	 * @return boolean
	 * */
	
	public boolean userLoginCheck(HttpServletRequest req) {
		User user = (User)req.getSession().getAttribute("user");
		if (user != null) {
			return true;
		} else {
			return false;
		}	
	}
}
