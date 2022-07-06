package com.ldc.spring.framework.beans.factory.support;

import com.ldc.spring.framework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 实例化策略
 *
 * @author charles
 * @date 2022/06/30
 */
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object... args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

}
