package cn.lxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.lxy.utils.GetEntity;

public abstract class CommonSevc<E,D> {
	@Autowired
	public D daoImpl;
	@Autowired
	public GetEntity getEntity;
	
	public abstract void save(E arg);
	public abstract E find(String arg) throws Exception;
	public abstract List<E> findAll(String arg);
	public abstract void delete(E arg);
	
}
