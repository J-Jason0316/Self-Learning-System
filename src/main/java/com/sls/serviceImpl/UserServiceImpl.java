package com.sls.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sls.dao.UserDao;
import com.sls.service.UserService;
import com.sls.vo.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	public User userLogin(String userId) {
		return userDao.selectByPrimaryKey(userId);
	}
	
}
