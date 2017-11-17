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
		return daoImpl.find(arg);
	}

	@Override
	public List<Teacher> findAll(String arg) {
		return daoImpl.findAll();
	}
	
	public void delete(Teacher arg) {
		daoImpl.delete(arg);		
	}
	
	public Teacher login(String arg1,String arg2) throws Exception {
		return (Teacher) this.getEntity.login("Teacher", "username = '"+arg1+"' and password = '"+arg2+"'", Teacher.class);
	}
	
	public boolean updatePassword(Teacher arg) {
		daoImpl.save(arg);
		return true;
	}
	public List<Teacher> findByName(String arg){
		String sql = "username like '%"+arg+"%' or name like '%"+arg+"%'";
		return daoImpl.findByName(sql);
	}
}
