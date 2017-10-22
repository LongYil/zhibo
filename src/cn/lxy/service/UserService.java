package cn.lxy.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lxy.dao.UserDao;

@Transactional
@Service(value="userService")
public class UserService {

//	×¢Èëdao¶ÔÏó
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void add(){
		
		userDao.add();
	}
}
