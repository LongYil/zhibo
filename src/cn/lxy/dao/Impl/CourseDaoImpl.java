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
		return (List<Course>) ht.find("from Course where name like '%"+arg1+"%' or subject like '%"+arg1+"%' and teacher_id="+teacherid+" and coursetype = 0 ");
	}

	@Override
	public List<Course> findByTeacherId(String arg) {
		return (List<Course>) ht.find("from Course where teacher_id = "+arg+" and coursetype = 0 order by time desc");
	}

	@Override
	public List<Course> findByDate(String arg) {
		return (List<Course>) ht.find("from Course where time like '%"+arg+"%' order by time desc");
	}

	@Override
	public List<Course> findPast(String arg) {
		return (List<Course>) ht.find("from Course where time < '"+arg+"' order by time desc");
	}

	@Override
	public List<Course> findPastByInfo(String arg1, String arg2) {
		return (List<Course>) ht.find("from Course where time < '"+arg1+"' and coursetype = 1 and name like '%"+arg2+"%' order by time desc");
	}

	@Override
	public List<Course> findPastByDate(String arg) {
		return (List<Course>) ht.find("from Course where time like '%"+arg+"%' and coursetype = 1 order by time desc");
	}
	
	
	
}
