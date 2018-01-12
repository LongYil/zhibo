package cn.lxy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lxy.dao.Impl.StudentDaoImpl;
import cn.lxy.po.Student;


@Transactional
@Service(value="studentServc")
public class StudentServc extends CommonSevc<Student, StudentDaoImpl> {
	@Autowired
	private Student student;	
	
	private List<Student> list = new ArrayList<Student>();
	
	@Override
	public void save(Student arg) {
		daoImpl.save(arg);		
	}
	@Override
	public Student find(String arg) throws Exception {
		return daoImpl.find(arg);
	}
	@Override
	public List<Student> findAll(String arg) {
		return daoImpl.findAll();
	}
	public List<Student> findAllDisabled(String arg) {
		return daoImpl.findAllDisabled();
	}
	public List<Student> findEnableByPageNumber(String arg) {
		return daoImpl.findEnableByPageNumber(arg);
	}
	@Override
	public void delete(Student arg) {
		//
	}
	public String forbidden(String arg) throws Exception {
		student = this.find(arg);
		student.setUserstatus(0);
		this.save(student);
		return "1";
	}
	public String start(String arg) throws Exception {
		student = this.find(arg);
		student.setUserstatus(1);
		this.save(student);
		return "1";
	}
	public List<Student> findByName(String arg) throws Exception {
		String sql = "(username like '%"+arg+"%' or name like '%"+arg+"%' ) and ( userstatus = 0 or userstatus = 1)";
		return  daoImpl.findByName(sql);
	}
	public List<Student> findById(String arg) throws Exception {
		return daoImpl.findById(arg);
	}
	public Student login(String arg1,String arg2) throws Exception {
		String sql = "tel ='"+arg1+"'and password = '"+arg2+"'";
		return (Student) getEntity.login("Student", sql, Student.class);
	}
	public int checkAccount(String arg) {
		list.clear();
		list = daoImpl.checkAccount(arg);
		if(list.size()>0) {
			return 0;
		}else {
			return 1;
		}
	}
	
	
}
