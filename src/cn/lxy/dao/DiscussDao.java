package cn.lxy.dao;

import java.util.List;

import cn.lxy.po.Discuss;

public interface DiscussDao {
	List<Discuss> findByCourseId(String arg);
}
