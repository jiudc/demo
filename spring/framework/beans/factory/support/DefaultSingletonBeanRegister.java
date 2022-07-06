package com.ldc.spring.framework.beans.factory.support;

import com.ldc.spring.framework.beans.factory.config.SingletonBeanRegister;

import java.util.HashMap;
import java.util.Map;

public class DefaultSingletonBeanRegister implements SingletonBeanRegister {
    Map<String, Object> beansMap = new HashMap<>();

    @Override
    public Object getSingletonBean(String beanName) {
        return beansMap.get(beanName);
    }

    protected void addSingletonBean(String beanName, Object bean) {
        beansMap.put(beanName, bean);
    }
}
