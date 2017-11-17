package cn.lxy.dao;

import java.util.List;

import cn.lxy.po.Exam;

public interface ExamDao {
	List<Exam> findAll();
	List<Exam> findByName(String arg);
}
