package cn.lxy.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.lxy.dao.ExamDao;
import cn.lxy.po.Exam;
import cn.lxy.utils.GetEntity;

@Component(value="examDaoImpl")
public class ExamDaoImpl extends CommonDaoImpl<Exam> implements ExamDao {

	@Override
	public List<Exam> findAll() {
		return (List<Exam>) ht.find("from Exam");
	}

	@Override
	public List<Exam> findByName(String arg1) {
		return (List<Exam>) ht.find("from Exam where name like '%" + arg1 + "%' or describes like '%" + arg1 + "%' order by id desc");
	}

	@Override
	public Exam findById(String arg) {
		return (Exam) ht.find("from Exam where id = "+arg+"").get(0);
	}

	@Override
	public List<Exam> studentFindAll() {
		return (List<Exam>) ht.find("from Exam order by id desc");
	}

	@Override
	public List<Exam> studentFindAllByInfo(String arg) {
		return (List<Exam>) ht.find("from Exam where name like '%" + arg + "%' order by id desc");
	}

	@Override
	public List<Exam> teacherFindByName(String arg1,String arg2) {
		return (List<Exam>) ht.find("from Exam where ( name like '%" + arg1 + "%' or describes like '%" + arg1 + "%') and teacher_id = " + arg2 + "order by id desc");
	}

	@Override
	public List<Exam> teacherFindAll(String arg) {
		return (List<Exam>) ht.find("from Exam where teacher_id = " + arg + "");
	}

	
}
