package cn.lxy.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import cn.lxy.po.Teacher;
import cn.lxy.service.TeacherServc;

public class TeacherAction extends BasicAction implements ModelDriven<Teacher> {
	@Autowired
	private Teacher teacher;
	@Autowired
	private TeacherServc servc;
	
	private List<Teacher> listteacher = new ArrayList<Teacher>(); 
	
	@Override
	public Teacher getModel() {
		return teacher;
	}
	
	//添加教师
	public String add() {
		servc.save(teacher);
		return "add";
	}
	
	//查找所有教师
	public String findAll() {
		listteacher = servc.findAll("");	
		System.out.println("总页数:"+this.getSesion().get("allpage"));
		return "findAll";
	}
	
	
	
	
	
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Teacher> getListteacher() {
		return listteacher;
	}

	public void setListteacher(List<Teacher> listteacher) {
		this.listteacher = listteacher;
	}
	
}
