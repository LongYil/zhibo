package cn.lxy.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckLoginInterceptor extends AbstractInterceptor {
	
	private Map session;
	
    public String intercept(ActionInvocation actionInvocation) throws Exception {
//        System.out.println("begin check login interceptor!");
        
//        System.out.println("调用的方法是："+actionInvocation.getProxy().getMethod());
        
        // 对LoginAction不做该项拦截
        String[] methods = {"initialization","preLogin","findRecentCource","findRecentCourceTemp","getVerificationCode","findByDate","findRecentByPage","findPastCource","findPastByPage","findPastCourceTemp","studentFindAll","studentFindAllTemp","checkAccount","add","logout","login"};
        String actionMethod = actionInvocation.getProxy().getMethod();
        
        Map session = actionInvocation.getInvocationContext().getSession();
        String status = (String) session.get("userStatus");
        boolean flag = false;
        boolean flag1 = false;
        
        for(int i = 0; i < methods.length ; i ++) {
        	if(actionMethod.equals(methods[i])) {
//        		System.out.println("放行---------------------");
        		flag = true;
        		flag1 = true;
        		actionInvocation.invoke();
        		break;
        	}else {
        		;
        	}
        }
        
        if(status != null) {
        	flag = true;
        }
        
        if(!flag1) {
        	session.put("loginMethod", actionMethod);
            if(flag) {
            	actionInvocation.invoke();
            }else {
            	session.put("loginstatus", 0);
            	if(actionMethod.equals("watch1")) {
            		return "pleaselogin1";	
            	}else if(actionMethod.equals("watch2")) {
            		return "pleaselogin2";
            	}else if(actionMethod.equals("analyseExam")){
            		return "pleaselogin3";
            	}else {
            		return "pleaselogin1";
            	}
            }
        }
        
//        Object action = actionInvocation.getAction();
        
//        if(action instanceof LoginAction){
//            System.out.println("exit check login, because this is login action.");
//            return actionInvocation.invoke();
//        }
        // 确认Session中是否存在LOGIN
//        Map session = actionInvocation.getInvocationContext().getSession();
//        
//        System.out.println("调用的action类是:"+actionInvocation.getAction().getClass().getName());
//        System.out.println("调用的Action方法是："+actionInvocation.getProxy().getActionName());
//        System.out.println("调用的方法是："+actionInvocation.getProxy().getMethod());
//        actionInvocation.invoke();
        return null;
    }

}
