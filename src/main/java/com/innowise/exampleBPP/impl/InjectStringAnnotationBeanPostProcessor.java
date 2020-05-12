package com.innowise.exampleBPP.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

@Configuration
public class InjectStringAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectString annotation = field.getAnnotation(InjectString.class);
            if (annotation != null) {
                field.setAccessible(true);
                String value = annotation.value();
                ReflectionUtils.setField(field, bean, value);
            }
        }
        return bean;
    }

}
