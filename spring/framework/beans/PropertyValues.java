package com.ldc.spring.framework.beans;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: PropertyValues
 * @description: TODO 类描述
 * @author: charles
 * @date: 2022/7/1 09:30
 **/
@NoArgsConstructor
public class PropertyValues {
    List<PropertyValue> propertyValueList=new ArrayList<>(256);

    public void addPropertyValue(PropertyValue propertyValue) {
        this.propertyValueList.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue propertyValue : this.propertyValueList) {
            if (propertyName.equals(propertyValue.getName())) {
                return propertyValue;
            }
        }
        return null;
    }
}
