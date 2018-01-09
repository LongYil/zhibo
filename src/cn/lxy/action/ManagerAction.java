package cn.lxy.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
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
	private String resultinfo;
	private List<Manager> listManager = new ArrayList<Manager>();
	@Override
	public Manager getModel() {
		return manager;
	}
	//系统初始化
	public String initialization() {
		listManager.clear();
		listManager = servc.findAll("");
		if(listManager.size() == 0) {
			manager.setUsername("admin");
			manager.setPassword("admin");
			manager.setName("管理员");
			manager.setHead("http://"+ServerInfo.SERVER_IP+"/CollegeLive/Image/manager.png");
			servc.save(manager);
			student.setHead(manager.getHead());
			student.setName(manager.getName());
			student.setUsername(manager.getUsername());
			studentServc.save(student);			
		}
		return "initialization";
	}
	//查看个人信息
	public String queryInfo() {
		manager = (Manager) this.getSesion().get("Manager");
		return "queryInfo";
	}
	//修改个人信息
	public String updateInfo() throws UnsupportedEncodingException {
		this.resultinfo = "0";
		HttpServletRequest request =  ServletActionContext.getRequest();
		String info = request.getParameter("info");
		info = URLDecoder.decode(info,"UTF-8");
		String[] infos = info.split("-");
		manager = (Manager) this.getSesion().get("Manager");
		manager.setUsername(infos[0]);
		manager.setName(infos[1]);
		servc.save(manager);
		this.resultinfo = "1";
		return "updateInfo";
	}
	//修改密码
	public String updatePassword() throws UnsupportedEncodingException {
		this.resultinfo = "0";
		HttpServletRequest request =  ServletActionContext.getRequest();
		String info = request.getParameter("info");
		info = URLDecoder.decode(info,"UTF-8");
		String[] infos = info.split("-");
		manager = (Manager) this.getSesion().get("Manager");
		if(manager.getPassword().equals(infos[0])) {
			manager.setPassword(infos[1]);
			servc.save(manager);
			this.resultinfo = "1";
		}
		return "updatePassword";
	}
	
	
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public String getResultinfo() {
		return resultinfo;
	}
	public void setResultinfo(String resultinfo) {
		this.resultinfo = resultinfo;
	}	
	
}
