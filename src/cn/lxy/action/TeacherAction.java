package cn.lxy.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import cn.lxy.po.Teacher;
import cn.lxy.service.TeacherServc;

public class TeacherAction extends BasicAction<TeacherServc> implements ModelDriven<Teacher> {
	@Autowired
	private Teacher teacher;
	
	@Override
	public Teacher getModel() {
		return teacher;
	}

}
