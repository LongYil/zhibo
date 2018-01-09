package cn.lxy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lxy.dao.Impl.TeacherDaoImpl;
import cn.lxy.po.Course;
import cn.lxy.po.Exam;
import cn.lxy.po.Teacher;

@Transactional
@Service(value="teacherServc")
public class TeacherServc extends CommonSevc<Teacher, TeacherDaoImpl> {
	private List<Teacher> list = new ArrayList<Teacher>();
	private List<Course> listCourse = new ArrayList<Course>();
	private List<Course> tempListCourse = new ArrayList<Course>();
	private List<Exam> listExam = new ArrayList<Exam>();
	@Override
	public void save(Teacher arg) {
		daoImpl.save(arg);
	}

	@Override
	public Teacher find(String arg) throws Exception {
		return daoImpl.find(arg);
	}

	@Override
	public List<Teacher> findAll(String arg) {
		return daoImpl.findAll();
	}
	
	public List<Exam> findAllByInfo(String arg){
		list.clear();
		listExam.clear();
		list = daoImpl.findByName(arg);
		for(int i = 0;i < list.size();i++) {
			listExam.addAll(list.get(i).getSetExam());
		}
		return listExam;
	}
	public void delete(Teacher arg) {
		daoImpl.delete(arg);
	}
	
	public Teacher login(String arg1,String arg2) throws Exception {
		return (Teacher) this.getEntity.login("Teacher", "tel = '"+arg1+"' and password = '"+arg2+"'", Teacher.class);
	}
	
	public boolean updatePassword(Teacher arg) {
		daoImpl.save(arg);
		return true;
	}
	public List<Teacher> findByName(String arg){
		return daoImpl.findByName(arg);
	}
	public List<Course> findCourseByName(String arg){
		String sql = "username like '%"+arg+"%' or name like '%"+arg+"%'";
		list = daoImpl.findByName(sql);
		tempListCourse.clear();
		for(int i=0;i<list.size();i++) {
			listCourse.clear();
			listCourse.addAll(list.get(i).getSetCourse());
			for(int j=0;j<listCourse.size();j++) {
				if(listCourse.get(j).getCoursetype()==1) {
					tempListCourse.add(listCourse.get(j));
				}
			}
		}
		return tempListCourse; 
	}
}
