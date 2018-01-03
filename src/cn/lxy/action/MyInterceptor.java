package cn.lxy.action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends  AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        System.out.println("调用的action类是:"+invocation.getAction().getClass().getName());
        System.out.println("调用的Action方法是："+invocation.getProxy().getActionName());
        System.out.println("调用的方法是："+invocation.getProxy().getMethod());
        invocation.invoke();
        return null;
    }
}
