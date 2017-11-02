package cn.lxy.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.lxy.dao.TeacherDao;
import cn.lxy.po.Teacher;

@Component(value="teacherDaoImpl")
public class TeacherDaoImpl extends CommonDaoImpl<Teacher> implements TeacherDao {

	@Override
	public List<Teacher> findAll() {
		return (List<Teacher>) ht.find("from Teacher");
	}
	
}	
