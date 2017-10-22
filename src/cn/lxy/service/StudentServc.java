package cn.lxy.service;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;

import cn.lxy.dao.Impl.StudentDaoImpl;
import cn.lxy.po.Student;

@Transactional
@Scope(value="studentServc")
public class StudentServc extends CommonSevc<Student, StudentDaoImpl> {

	@Override
	public void save(Student arg) {
		//
		
	}

	@Override
	public Student find(String arg) throws Exception {
		//
		return null;
	}

	@Override
	public List<Student> findAll(String arg) {
		//
		return null;
	}

	@Override
	public void delete(Student arg) {
		//
		
	}

}
