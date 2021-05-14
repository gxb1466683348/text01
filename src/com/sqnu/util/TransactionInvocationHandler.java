package com.sqnu.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionInvocationHandler implements InvocationHandler {

    private SqlSessionUtil SqlSessionUtil;

    private Object target;

    public TransactionInvocationHandler(Object target){
        this.target = target;
    }

    //代理类业务方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

       SqlSession session = null;
       Object obj = null;
       try {

          session = SqlSessionUtil.getSession();

          //处理业务逻辑
           //method.invoke张三的表白方法
          obj =  method.invoke(target,args);

       }catch (Exception e ){
           e.printStackTrace();

           session.rollback();
       }finally {
           SqlSessionUtil.myClose(session);

       }

        //处理业务逻辑完毕之后，提交事务
        return obj;
    }

    //取得代理类对象
    public Object getProxy() {

        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);

    }

}
