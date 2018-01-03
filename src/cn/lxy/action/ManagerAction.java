package cn.lxy.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import cn.lxy.po.Manager;
import cn.lxy.po.Student;
import cn.lxy.service.ManagerServc;
import cn.lxy.service.StudentServc;
import cn.lxy.utils.ServerInfo;

public class ManagerAction extends BasicAction implements ModelDriven<Manager> {
	@Autowired
	private Manager manager;
	@Autowired
	private ManagerServc servc;
	@Autowired
	private Student student;
	@Autowired
	private StudentServc studentServc;
	private List<Manager> listManager = new ArrayList<Manager>();
	@Override
	public Manager getModel() {
		return manager;
	}
	public String initialization() {
		listManager.clear();
		listManager = servc.findAll("");
		if(listManager.size() == 0) {
			manager.setUsername("admin");
			manager.setPassword("admin");
			manager.setName("π‹¿Ì‘±");
			manager.setHead("http://"+ServerInfo.SERVER_IP+":8080/CollegeLive/Image/manager.png");
			servc.save(manager);
			student.setHead(manager.getHead());
			student.setName(manager.getName());
			student.setUsername(manager.getUsername());
			studentServc.save(student);			
		}
		return "initialization";
	}
}
