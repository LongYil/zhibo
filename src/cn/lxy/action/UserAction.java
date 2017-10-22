package cn.lxy.action;

import cn.lxy.service.UserService;


public class UserAction extends BasicAction {
	
	private UserService userservice;

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("action");

		return SUCCESS;
	}
	
	public String test() {
		return "aaa";
	}
}

