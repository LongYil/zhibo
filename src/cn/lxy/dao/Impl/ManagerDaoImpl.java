package cn.lxy.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.lxy.dao.ManagerDao;
import cn.lxy.po.Manager;

@Component(value="managerDaoImpl")
public class ManagerDaoImpl extends CommonDaoImpl<Manager> implements ManagerDao {

	@Override
	public List<Manager> findAll() {
		return (List<Manager>) ht.find("from Manager");
	}
	
}
