package cn.lxy.service;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;

import cn.lxy.dao.Impl.CourseDaoImpl;
import cn.lxy.po.Course;

@Transactional
@Scope(value="courseServc")
public class CourseServc extends CommonSevc<Course, CourseDaoImpl> {

	@Override
	public void save(Course arg) {
		//
		
	}

	@Override
	public Course find(String arg) throws Exception {
		//
		return null;
	}

	@Override
	public List<Course> findAll(String arg) {
		//
		return null;
	}

	@Override
	public void delete(Course arg) {
		//
		
	}

}
