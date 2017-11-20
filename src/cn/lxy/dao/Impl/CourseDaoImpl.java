package cn.lxy.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.lxy.dao.CourseDao;
import cn.lxy.po.Course;

@Component(value="courseDaoImpl")
public class CourseDaoImpl extends CommonDaoImpl<Course> implements CourseDao {

	@Override
	public List<Course> findAll() {
		return (List<Course>) ht.find("from Course");
	}

	@Override
	public List<Course> findByInfo(String arg) {
		return (List<Course>) ht.find("from Course where name like '%?%' or subject like '%?%'", arg,arg);
	}

	@Override
	public List<Course> teacherFindByInfo(String arg1, String teacherid) {
		return (List<Course>) ht.find("from Course where name like '%?%' or subject like '%?%'",arg1,teacherid);
	}
	
	
	
}
