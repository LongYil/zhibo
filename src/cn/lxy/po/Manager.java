package cn.lxy.po;

/**
 * <p>Title:Manager</p>
 * <p>Description:ϵͳ����Ա </p>
 * @author ������
 *		2017��10��23��
 *		����12:16:53
 */
public class Manager {
	private Integer id;//���
	private String name;//�û�����
	private String head;//ͷ��
	private String username;//�û���
	private String password;//����
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	
}
