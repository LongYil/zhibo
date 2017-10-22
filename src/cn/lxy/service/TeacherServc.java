package cn.lxy.service;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;

import cn.lxy.dao.Impl.TeacherDaoImpl;

@Transactional
@Scope(value="teacherServc")
public class TeacherServc extends CommonSevc<TeacherServc, TeacherDaoImpl> {

	@Override
	public void save(TeacherServc arg) {
		//
		
	}

	@Override
	public TeacherServc find(String arg) throws Exception {
		//
		return null;
	}

	@Override
	public List<TeacherServc> findAll(String arg) {
		//
		return null;
	}

	@Override
	public void delete(TeacherServc arg) {
		//
		
	}

}
