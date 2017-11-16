package cn.lxy.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import cn.lxy.po.Student;


@Component(value="getEntity")
public class GetEntity {
	@Autowired
	public HibernateTemplate ht;
	private List<Object> list = new ArrayList<Object>();
	private Object t ;
	
	public Object getEntity(String table,String column,String info,Class type) throws Exception{
		t = type.newInstance();
		list = (List<Object>) ht.find("from "+table+" where "+column+" = "+info+"");
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return t;
		}
	}
	public Object login(String table,String sql,Class type) throws Exception{
		t = type.newInstance();
		list = (List<Object>) ht.find("from "+table+" where "+sql);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return t;
		}
	}


}
