package com.ldc.spring.framework.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @className: PropertyValue
 * @description: TODO 类描述
 * @author: charles
 * @date: 2022/7/1 09:29
 **/
@Setter
@Getter
@AllArgsConstructor
public class PropertyValue {
    private String name;
    private Object value;
}
