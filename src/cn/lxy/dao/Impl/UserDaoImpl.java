package cn.lxy.dao.Impl;

import org.springframework.stereotype.Component;

import cn.lxy.dao.UserDao;
import cn.lxy.po.User;

@Component(value="userDaoImpl")
public class UserDaoImpl extends CommonDaoImpl<User> implements UserDao {

	@Override
	public void add() {
		
	}

}
