package com.ldc.proxy.application;

import com.ldc.proxy.api.ProxyDemoApi;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    ProxyDemoApi target;

    MyInvocationHandler(ProxyDemoApi target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK before");
        Object invoke = method.invoke(target, args);
        System.out.println("JDK after");
        return invoke;
    }
}
