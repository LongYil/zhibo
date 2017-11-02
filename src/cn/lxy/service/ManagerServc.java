package cn.lxy.service;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lxy.dao.Impl.ManagerDaoImpl;
import cn.lxy.po.Manager;

@Transactional
@Service(value="managerServc")
public class ManagerServc extends CommonSevc<Manager, ManagerDaoImpl> {

	@Override
	public void save(Manager arg) {
		//
		
	}

	@Override
	public Manager find(String arg) throws Exception {
		//
		return null;
	}

	@Override
	public List<Manager> findAll(String arg) {
		//
		return null;
	}

	@Override
	public void delete(Manager arg) {
		//
		
	}

}
