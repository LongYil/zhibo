package cn.lxy.dao.Impl;

import org.springframework.stereotype.Component;

import cn.lxy.dao.NoteDao;
import cn.lxy.po.Note;

@Component(value="noteDaoImpl")
public class NoteDaoImpl extends CommonDaoImpl<Note> implements NoteDao {

}
