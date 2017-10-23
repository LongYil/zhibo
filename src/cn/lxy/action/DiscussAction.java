package cn.lxy.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import cn.lxy.po.Discuss;
import cn.lxy.service.DiscussServc;

public class DiscussAction extends BasicAction<DiscussServc> implements ModelDriven<Discuss> {
	@Autowired
	private Discuss discuss;
	
	@Override
	public Discuss getModel() {
		return discuss;
	}

}
