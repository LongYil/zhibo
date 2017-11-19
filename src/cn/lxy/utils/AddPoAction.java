package cn.lxy.utils;

import org.springframework.beans.factory.annotation.Autowired;

import cn.lxy.action.BasicAction;
import cn.lxy.po.Exam;
import cn.lxy.po.Student;
import cn.lxy.po.Teacher;
import cn.lxy.service.ExamServc;
import cn.lxy.service.StudentServc;
import cn.lxy.service.TeacherServc;

public class AddPoAction extends BasicAction{
	
	private Student student;
	@Autowired
	private StudentServc studentServc;
	
	private Teacher teacher;
	@Autowired
	private TeacherServc teacherServc;
	
	private Exam exam;
	@Autowired
	private ExamServc examServc;
	
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
	
	public String addExam() throws Exception {
		for(int i=0;i<60;i++) {
			teacher = teacherServc.find("28");
			exam = new Exam();
			exam.setName("高等数学:"+i);
			exam.setDescribes("普通高等院校高等数学");
			exam.setTeacher(teacher);
			examServc.save(exam);
		}		
		return "success";
	}
	
	
	
}
