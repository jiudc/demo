package com.ldc.spring.framework.beans.factory.support;

import com.ldc.spring.framework.beans.factory.BeanFactory;
import com.ldc.spring.framework.beans.factory.config.BeanDefinition;

import java.lang.reflect.InvocationTargetException;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegister implements BeanFactory {
    @Override
    public Object getBean(String beanName) throws InstantiationException, IllegalAccessException {
        Object singletonBean = this.getSingletonBean(beanName);
        if (null == singletonBean) {
            BeanDefinition beanDefinition = getBeanDefinition(beanName);
            singletonBean = createBean(beanName, beanDefinition);
            this.addSingletonBean(beanName, singletonBean);
        }
        return singletonBean;
    }

    @Override
    public Object getBean(String beanName, Object... args) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Object bean = this.getSingletonBean(beanName);
        if (null != bean) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        Object bean1 = createBean(beanName, beanDefinition, args);
        return bean1;
    }

    abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws InstantiationException, IllegalAccessException;

    abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object... args) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException;

    abstract BeanDefinition getBeanDefinition(String beanName);
}

