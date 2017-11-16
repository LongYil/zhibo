package cn.lxy.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.lxy.dao.StudentDao;
import cn.lxy.po.Student;

@Component(value="studentDaoImpl")
public class StudentDaoImpl extends CommonDaoImpl<Student> implements StudentDao {

	@Override
	public List<Student> findAll() {
		return (List<Student>) ht.find("from Student where userstatus = "+"1"+"");
	}
	
	public Student find(String arg) {
		return ht.get(Student.class,Integer.parseInt(arg));
	}

	@Override
	public List<Student> findAllDisabled() {
		return (List<Student>) ht.find("from Student where userstatus = "+"0"+"");
	}

	@Override
	public List<Student> findEnableByPageNumber(String arg) {
		int a = Integer.parseInt(arg);
		a = (a-1)*11+1;
		int b = a+11;
		return (List<Student>) ht.find("from Student where userstatus = "+"1"+"");
	}

	@Override
	public List<Student> findByName(String arg) {
		return (List<Student>) ht.find("from Student where "+arg+"");
	}
	@Override
	public List<Student> findById(String arg) {
		return (List<Student>) ht.find("from Student where id = "+arg+"");
	}
	
	
	
}
