package cn.lxy.service;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;

import cn.lxy.dao.Impl.NoteDaoImpl;
import cn.lxy.po.Note;

@Transactional
@Scope(value="noteServc")
public class NoteServc extends CommonSevc<Note, NoteDaoImpl> {

	@Override
	public void save(Note arg) {
		//
		
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
		//
		
	}

}
