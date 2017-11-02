package cn.lxy.dao;

import java.util.List;

import cn.lxy.po.Student;

public interface StudentDao {
	List<Student> findAll();
}
