package cn.lxy.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import cn.lxy.po.Note;
import cn.lxy.po.Student;
import cn.lxy.service.NoteServc;
import cn.lxy.utils.GetDateAndTime;

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
	@Autowired
	private NoteServc servc;
	@Autowired
	private Student student;
	@Autowired
	private GetDateAndTime getDateAndTime;
	
	private String resultinfo;
	
	private List<Note> listNote = new ArrayList<Note>();
	
	@Override
	public Note getModel() {
		//
		return note;
	}
	
	
	//����ʼ�
	public String save() {
		this.resultinfo = "0";
		HttpServletRequest request =  ServletActionContext.getRequest();
		String noteContent = request.getParameter("info");
		
		student = (Student) this.getSesion().get("Student");
		
		note.setCourse(null);
		
		note.setStudent(student);
		note.setTime(getDateAndTime.getNowTime());
		servc.save(note);
		
		this.resultinfo = "1";
		return null;
	}
	//ѧ��ɾ���ʼ�
	public String delete() {
		this.resultinfo = "0";
		HttpServletRequest request =  ServletActionContext.getRequest();
		String noteId = request.getParameter("info");
		note = servc.findById(noteId);
		servc.delete(note);
		
		this.resultinfo = "1";
		return null;
	}
	//ѧ�����ݿγ�id�������иÿγ̵����бʼ�
	public String findAll() {
		listNote.clear();
		String course_id = null;
		student = (Student) this.getSesion().get("Student");
		listNote = servc.findAll(String.valueOf(student.getId()), course_id);
		return null;
	}
	
	
	
	
	public Note getNote() {
		return note;
	}
	public void setNote(Note note) {
		this.note = note;
	}
	public String getResultinfo() {
		return resultinfo;
	}
	public void setResultinfo(String resultinfo) {
		this.resultinfo = resultinfo;
	}
	public List<Note> getListNote() {
		return listNote;
	}
	public void setListNote(List<Note> listNote) {
		this.listNote = listNote;
	}
	
	
}
