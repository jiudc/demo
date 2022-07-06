package com.ldc.spring.framework.beans.factory.support;

import com.ldc.spring.framework.beans.factory.config.BeanDefinition;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @className: CglibSubclassingInstantiationStrategy
 * @description: TODO 类描述
 * @author: charles
 * @date: 2022/6/30 08:52
 **/
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object... args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        return enhancer.create(constructor.getParameterTypes(), args);
    }
}
