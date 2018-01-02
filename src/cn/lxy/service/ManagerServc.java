package cn.lxy.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lxy.dao.Impl.ManagerDaoImpl;
import cn.lxy.po.Manager;

@Transactional
@Service(value="managerServc")
public class ManagerServc extends CommonSevc<Manager, ManagerDaoImpl> {

	@Override
	public void save(Manager arg) {
		daoImpl.save(arg);		
	}

	@Override
	public Manager find(String arg) throws Exception {
		//
		return null;
	}

	@Override
	public List<Manager> findAll(String arg) {
		return daoImpl.findAll();
	}

	@Override
	public void delete(Manager arg) {
		//
		
	}
	
	public Manager login(String arg1,String arg2) throws Exception {
		return (Manager) this.getEntity.login("Manager", "username = '"+arg1+"' and password = '"+arg2+"'", Manager.class);
	}
	
	
}
