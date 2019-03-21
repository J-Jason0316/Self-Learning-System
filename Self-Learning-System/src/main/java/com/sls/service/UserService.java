package com.sls.service;

import com.sls.vo.User;

public interface UserService {
	/**
	 * 根据主键获取用户
	 * @param userId
	 * @return user
	 * */
	public User userLogin(String userId); 
	
}
