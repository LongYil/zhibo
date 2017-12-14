package cn.lxy.dao;

import java.util.List;

import cn.lxy.po.Exam;

public interface ExamDao {
	List<Exam> findAll();
	List<Exam> studentFindAll();
	List<Exam> studentFindAllByInfo(String arg);
	List<Exam> findByName(String arg);
	Exam findById(String arg);
}
