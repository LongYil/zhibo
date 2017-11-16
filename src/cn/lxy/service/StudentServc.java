package cn.lxy.service;

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
		String sql = "username like '%"+arg+"%' or name like '%"+arg+"%'";
		return  daoImpl.findByName(sql);
	}
	public List<Student> findById(String arg) throws Exception {
		return daoImpl.findById(arg);
	}
	
}
