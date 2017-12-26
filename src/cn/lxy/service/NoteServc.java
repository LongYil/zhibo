package cn.lxy.service;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lxy.dao.Impl.NoteDaoImpl;
import cn.lxy.po.Note;

@Transactional
@Service(value="noteServc")
public class NoteServc extends CommonSevc<Note, NoteDaoImpl> {
	
	@Override
	public void save(Note arg) {
		daoImpl.save(arg);		
	}

	@Override
	public Note find(String arg) throws Exception {
		//
		return null;
	}

	@Override
	public List<Note> findAll(String arg) {
		//
		return null;
	}

	@Override
	public void delete(Note arg) {
		daoImpl.delete(arg);
	}
	public Note findById(String arg) {
		return daoImpl.findById(arg);
	}
	public List<Note> findAll(String studentId,String courseId){
		return daoImpl.findAll(studentId, courseId);
	}
	
}
