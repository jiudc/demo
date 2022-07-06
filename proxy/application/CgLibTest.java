package com.ldc.proxy.application;

import com.ldc.proxy.api.ProxyDemoApi;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;


import java.lang.reflect.Method;

public class CgLibTest {
    //-Dcglib
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "target/classes");
        ProxyDemoApi target = RateCalculate.class.newInstance();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ProxyDemoApi.class);
        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("切面逻辑前置");
                Object invoke = method.invoke(target, args);
                System.out.println("切面逻辑后置");
                return invoke;
            }
        });
        ProxyDemoApi demoApi = (ProxyDemoApi) enhancer.create();
        demoApi.calculate(10);

    }
}
