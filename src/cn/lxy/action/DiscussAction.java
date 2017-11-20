package cn.lxy.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import cn.lxy.po.Discuss;
import cn.lxy.service.DiscussServc;

/**
 * <p>Title:DiscussAction</p>
 * <p>Description: 讨论实体控制器</p>
 * @author 李银龙
 *		2017年11月20日
 *		下午9:51:02
 */
public class DiscussAction extends BasicAction implements ModelDriven<Discuss> {
	@Autowired
	private Discuss discuss;
	
	@Override
	public Discuss getModel() {
		return discuss;
	}

}
