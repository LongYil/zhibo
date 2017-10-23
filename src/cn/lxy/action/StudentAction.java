package cn.lxy.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import cn.lxy.po.Student;
import cn.lxy.service.StudentServc;

public class StudentAction extends BasicAction<StudentServc> implements ModelDriven<Student> {
	@Autowired
	private Student student;
	
	@Override
	public Student getModel() {
		return student;
	}

}
