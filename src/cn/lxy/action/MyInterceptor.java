package cn.lxy.action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends  AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        System.out.println("���õ�action����:"+invocation.getAction().getClass().getName());
        System.out.println("���õ�Action�����ǣ�"+invocation.getProxy().getActionName());
        System.out.println("���õķ����ǣ�"+invocation.getProxy().getMethod());
        invocation.invoke();
        return null;
    }
}
