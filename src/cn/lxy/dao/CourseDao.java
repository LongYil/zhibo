package cn.lxy.dao;

import java.util.List;

import cn.lxy.po.Course;

public interface CourseDao {
	List<Course> findAll();
	List<Course> findByInfo(String arg);
	List<Course> teacherFindByInfo(String arg1,String teacherid);
	List<Course> findByTeacherId(String arg);
	List<Course> findByDate(String arg);
}
