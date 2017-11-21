package cn.lxy.dao;

import java.util.List;

import cn.lxy.po.Note;

public interface NoteDao {
	Note findById(String arg);
	List<Note> findAll(String arg1,String arg2);
}
