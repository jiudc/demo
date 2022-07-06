package com.ldc.spring.framework.beans.factory.support;

import com.ldc.spring.framework.beans.factory.config.BeanDefinition;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@NoArgsConstructor
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegister {

    Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);

    @Override
    BeanDefinition getBeanDefinition(String beanName) {
        return beanDefinitionMap.get(beanName);
    }


    @Override
    public void resisterBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
