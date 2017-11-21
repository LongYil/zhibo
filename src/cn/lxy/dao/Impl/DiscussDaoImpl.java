package cn.lxy.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.lxy.dao.DiscussDao;
import cn.lxy.po.Discuss;

@Component(value="discussDaoImpl")
public class DiscussDaoImpl extends CommonDaoImpl<Discuss> implements DiscussDao {

	@Override
	public List<Discuss> findByCourseId(String arg) {
		return (List<Discuss>) ht.find("from Discuss where course_id = "+arg+"");
	}
	
	
}
