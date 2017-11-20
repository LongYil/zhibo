package cn.lxy.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import cn.lxy.po.Discuss;
import cn.lxy.service.DiscussServc;

/**
 * <p>Title:DiscussAction</p>
 * <p>Description: ����ʵ�������</p>
 * @author ������
 *		2017��11��20��
 *		����9:51:02
 */
public class DiscussAction extends BasicAction implements ModelDriven<Discuss> {
	@Autowired
	private Discuss discuss;
	
	@Override
	public Discuss getModel() {
		return discuss;
	}

}
