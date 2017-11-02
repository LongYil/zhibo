package cn.lxy.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lxy.dao.Impl.TeacherDaoImpl;
import cn.lxy.po.Teacher;

@Transactional
@Service(value="teacherServc")
public class TeacherServc extends CommonSevc<Teacher, TeacherDaoImpl> {

	@Override
	public void save(Teacher arg) {
		daoImpl.save(arg);		
	}

	@Override
	public Teacher find(String arg) throws Exception {
		//
		return null;
	}

	@Override
	public List<Teacher> findAll(String arg) {
		return daoImpl.findAll();
	}

	@Override
	public void delete(Teacher arg) {
		//
		
	}

}
