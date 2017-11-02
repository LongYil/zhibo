package cn.lxy.dao.Impl;

import org.springframework.stereotype.Component;

import cn.lxy.dao.ExamDao;
import cn.lxy.po.Exam;

@Component(value="examDaoImpl")
public class ExamDaoImpl extends CommonDaoImpl<Exam> implements ExamDao {
	
}
