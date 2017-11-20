package cn.lxy.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import cn.lxy.po.Note;
import cn.lxy.service.NoteServc;

/**
 * <p>Title:NoteAction</p>
 * <p>Description: �ʼ�ʵ�������</p>
 * @author ������
 *		2017��11��20��
 *		����9:52:28
 */
public class NoteAction extends BasicAction implements ModelDriven<Note> {
	@Autowired
	private Note note;
	
	@Override
	public Note getModel() {
		//
		return note;
	}
	
	public String test() {
		System.out.println("hello,world");
		return null;
	}
}
