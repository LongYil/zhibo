package cn.lxy.dao;

import java.util.List;

import cn.lxy.po.Teacher;

public interface TeacherDao {
	List<Teacher> findAll();
	List<Teacher> findByName(String arg);
}
