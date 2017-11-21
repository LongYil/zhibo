package cn.lxy.service;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lxy.dao.Impl.DiscussDaoImpl;
import cn.lxy.po.Discuss;

@Transactional
@Service(value="discussServc")
public class DiscussServc extends CommonSevc<Discuss, DiscussDaoImpl> {

	@Override
	public void save(Discuss arg) {
		daoImpl.save(arg);		
	}

	@Override
	public Discuss find(String arg) throws Exception {
		//
		return null;
	}

	@Override
	public List<Discuss> findAll(String arg) {
		//
		return null;
	}

	@Override
	public void delete(Discuss arg) {
		daoImpl.delete(arg);		
	}
	
	public List<Discuss> findByCourseId(String arg){
		return daoImpl.findByCourseId(arg);		
	}
	
}
