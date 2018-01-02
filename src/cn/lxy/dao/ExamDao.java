package cn.lxy.dao;

import java.util.List;

import cn.lxy.po.Exam;

public interface ExamDao {
	List<Exam> findAll();
	List<Exam> studentFindAll();
	List<Exam> teacherFindAll(String arg);
	List<Exam> studentFindAllByInfo(String arg);
	List<Exam> findByName(String arg);
	List<Exam> teacherFindByName(String arg1,String arg2);
	Exam findById(String arg);
}
