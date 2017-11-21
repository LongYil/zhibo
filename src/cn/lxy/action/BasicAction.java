package cn.lxy.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller(value="baseAction")
public class BasicAction extends ActionSupport implements SessionAware {
	
	private Map sesion;
	@Override
	public void setSession(Map<String, Object> arg) {
		this.sesion = arg;
	}
	public Map getSesion() {
		return sesion;
	}
	public void setSesion(Map sesion) {
		this.sesion = sesion;
	}
	
	
}
