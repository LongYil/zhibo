package cn.lxy.utils;

import org.springframework.beans.factory.annotation.Autowired;

import cn.lxy.action.BasicAction;
import cn.lxy.po.Student;
import cn.lxy.po.Teacher;
import cn.lxy.service.StudentServc;
import cn.lxy.service.TeacherServc;

public class AddPoAction extends BasicAction{
	
	private Student student;
	@Autowired
	private StudentServc studentServc;
	
	private Teacher teacher;
	@Autowired
	private TeacherServc teacherServc;
	
	public String addStudent() {
		for(int i=0;i<60;i++) {
			student = new Student();
			student.setName("student"+i);
			student.setUserstatus(1);
			studentServc.save(student);
		}	
		return "success";
	}
	
	public String addTeacher() {
		for(int i=0;i<60;i++) {
			teacher = new Teacher();
			teacher.setName("teacher"+i);
			teacherServc.save(teacher);
		}
		return "success";
	}
	
	
	
	
}
