package cn.lxy.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.lxy.dao.StudentDao;
import cn.lxy.po.Student;

@Component(value="studentDaoImpl")
public class StudentDaoImpl extends CommonDaoImpl<Student> implements StudentDao {

	@Override
	public List<Student> findAll() {
		return (List<Student>) ht.find("from Student");
	}
	
	
	
	
}
