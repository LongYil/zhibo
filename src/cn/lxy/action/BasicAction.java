package cn.lxy.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class BasicAction<S> extends ActionSupport implements SessionAware {
	
	@Autowired
	private S servc;
	
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
