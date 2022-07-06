package com.ldc.proxy.application;

import com.ldc.proxy.api.ProxyDemoApi;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JdkProxy {
    public static void main(String[] args) {
        ProxyDemoApi target = new RateCalculate(1);

        InvocationHandler invocationHandler = new MyInvocationHandler(target);
        ProxyDemoApi proxyDemoApi = (ProxyDemoApi) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), invocationHandler);
        proxyDemoApi.calculate(20);

    }
}

