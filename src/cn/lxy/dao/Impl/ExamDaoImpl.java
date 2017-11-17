package cn.lxy.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.lxy.dao.ExamDao;
import cn.lxy.po.Exam;

@Component(value="examDaoImpl")
public class ExamDaoImpl extends CommonDaoImpl<Exam> implements ExamDao {

	@Override
	public List<Exam> findAll() {
		return (List<Exam>) ht.find("from Exam");
	}

	@Override
	public List<Exam> findByName(String arg) {
		return (List<Exam>) ht.find("from Exam where "+arg);
	}
	
}
