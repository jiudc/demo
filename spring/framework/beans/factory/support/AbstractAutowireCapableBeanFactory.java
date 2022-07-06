package com.ldc.spring.framework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.ldc.spring.framework.beans.PropertyValue;
import com.ldc.spring.framework.beans.PropertyValues;
import com.ldc.spring.framework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    InstantiationStrategy CglibSubclassingInstantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    Object createBean(String beanName, BeanDefinition beanDefinition) throws InstantiationException, IllegalAccessException {
        Object bean = beanDefinition.getBeanClass().newInstance();
        applyPropertyValues(beanName, beanDefinition, bean);
        this.addSingletonBean(beanName, bean);
        return bean;
    }

    @Override
    Object createBean(String beanName, BeanDefinition beanDefinition, Object... args) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Object beanInstance = createBeanInstance(beanName, beanDefinition, args);
        applyPropertyValues(beanName, beanDefinition, beanInstance);
        this.addSingletonBean(beanName, beanInstance);
        return beanInstance;
    }

    Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object... args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Constructor<?>[] declaredConstructors = beanDefinition.getBeanClass().getDeclaredConstructors();
        Constructor constructor2 = null;
        for (Constructor constructor : declaredConstructors) {
            if (null != constructor && constructor.getParameterCount() == args.length) {
                constructor2 = constructor;
            }
        }
        return CglibSubclassingInstantiationStrategy.instantiate(beanDefinition, beanName, constructor2, args);
    }

    void applyPropertyValues(String beanName, BeanDefinition beanDefinition, Object bean) throws InstantiationException, IllegalAccessException {
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
            Object value = propertyValue.getValue();
            String propertyName = propertyValue.getName();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                String beanName1 = beanReference.getBeanName();
                value = getBean(beanName1);
            }
            BeanUtil.setFieldValue(bean, propertyName, value);

        }
    }
}
