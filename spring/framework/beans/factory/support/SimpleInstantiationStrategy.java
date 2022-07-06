package com.ldc.spring.framework.beans.factory.support;

import com.ldc.spring.framework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @className: SimpleInstantiationStrategy
 * @description: TODO 类描述
 * @author: charles
 * @date: 2022/6/30 08:51
 **/
public class SimpleInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object... args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor constructor1 = beanDefinition.getBeanClass().getConstructor(constructor.getParameterTypes());
        return constructor1.newInstance(args);
    }
}
