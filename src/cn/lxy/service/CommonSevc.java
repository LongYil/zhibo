package cn.lxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class CommonSevc<E,D> {
	@Autowired
	public D daoImpl;
	
	public abstract void save(E arg);
	public abstract E find(String arg) throws Exception;
	public abstract List<E> findAll(String arg);
	public abstract void delete(E arg);
	
}
