package cn.lxy.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.lxy.dao.NoteDao;
import cn.lxy.po.Note;

@Component(value="noteDaoImpl")
public class NoteDaoImpl extends CommonDaoImpl<Note> implements NoteDao {

	@Override
	public Note findById(String arg) {
		return (Note) ht.find("from Note where Id = "+arg+"");
	}

	@Override
	public List<Note> findAll(String arg1, String arg2) {
		return (List<Note>) ht.find("from Note where student_id ="+arg1+" and course_id = "+arg2+"");
	}
	

	
}
