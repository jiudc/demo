package com.ldc.spring.framework.beans.factory.support;

import com.ldc.spring.framework.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegister {
    void resisterBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
