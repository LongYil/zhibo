package cn.lxy.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import cn.lxy.po.Student;
import cn.lxy.service.StudentServc;

public class StudentAction extends BasicAction implements ModelDriven<Student> {
	@Autowired
	private Student student ;
	@Autowired
	private StudentServc servc;
	
	private List<Student> liststudent = new ArrayList<Student>();
	
	
	@Override
	public Student getModel() {
		return student;
	}
	
	//学生用户注册新用户
	public String add() {
		servc.save(student);
		return "add";
	}
	
	//查找所有学生用户
	public String findAll() {
		liststudent = servc.findAll("");
		System.out.println(liststudent.size());
		return "findAll";
	}
	
	
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Student> getListstudent() {
		return liststudent;
	}

	public void setListstudent(List<Student> liststudent) {
		this.liststudent = liststudent;
	}

	
}
