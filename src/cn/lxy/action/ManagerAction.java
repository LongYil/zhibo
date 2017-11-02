package cn.lxy.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import cn.lxy.po.Manager;
import cn.lxy.service.ManagerServc;

public class ManagerAction extends BasicAction implements ModelDriven<Manager> {

	@Autowired
	private Manager manager;
	
	@Override
	public Manager getModel() {
		return manager;
	}

	
}
