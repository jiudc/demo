package com.ldc.spring.framework.beans.factory;

import java.lang.reflect.InvocationTargetException;

/**
 * 1、bean注册时只需要传入class，而不是实例化后的对象
 * 2、获取bean对象时需要判断是否为单例，缓存等信息
 */
public interface BeanFactory {
    Object getBean(String beanName) throws InstantiationException, IllegalAccessException;

    Object getBean(String beanName, Object... args) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException;
}
