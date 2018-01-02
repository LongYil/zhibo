package cn.lxy.service;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lxy.dao.Impl.CourseDaoImpl;
import cn.lxy.po.Course;

@Transactional
@Service(value="courseServc")
public class CourseServc extends CommonSevc<Course, CourseDaoImpl> {

	@Override
	public void save(Course arg) {
		daoImpl.save(arg);
	}

	@Override
	public Course find(String arg) throws Exception {
		//
		return null;
	}

	@Override
	public List<Course> findAll(String arg) {
		return daoImpl.findAll();
	}

	@Override
	public void delete(Course arg) {
		daoImpl.delete(arg);
	}
	public List<Course> findByInfo(String arg){
		return daoImpl.findByInfo(arg);
	}
	public List<Course> teacherFindByInfo(String arg,String teacherid){
		return daoImpl.teacherFindByInfo(arg, teacherid);
	}
	public Course findByCourseId(String arg) throws Exception {
		return (Course) getEntity.getEntity("Course", "id", arg, Course.class);
	}
	public List<Course> findByTeacherId(String arg){
		return daoImpl.findByTeacherId(arg);
	}
	public void update(Course course) {
		daoImpl.update(course);
	}
	public List<Course> findByDate(String arg){
		return daoImpl.findByDate(arg);
	}
	public List<Course> findPast(String arg){
		return daoImpl.findPast(arg);
	}
	public List<Course> findPastCourse(String arg){
		return daoImpl.findPastCourse(arg);
	}
	public List<Course> findPastCourseByInfo(String arg1,String arg2){
		return daoImpl.findPastCourseByInfo(arg1,arg2);
	}
	public List<Course> findPastByDate(String arg){
		return daoImpl.findPastByDate(arg);
	}
	public List<Course> findPastByInfo(String arg1,String arg2){
		return daoImpl.findPastByInfo(arg1,arg2);
	}
	public Course findById(String id) throws Exception {
		return (Course) getEntity.getEntity("Course", "id", id, Course.class);
	}
	public Course findByStreamId(String id) throws Exception {
		return (Course) getEntity.getEntity("Course", "streamid", id, Course.class);
	}
	
}
