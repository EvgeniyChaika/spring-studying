package com.chaika.spring.scheduling.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by echaika on 07.02.2019
 */
@Component
public class SheduledAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Method field = null;
        try {
            field = bean.getClass().getMethod("wakeUp", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (Objects.nonNull(field)) {
            Annotation[] annotations = field.getAnnotations();
            Scheduled[] annotationsByType = field.getAnnotationsByType(Scheduled.class);
            Scheduled[] declaredAnnotationsByType = field.getDeclaredAnnotationsByType(Scheduled.class);
            Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
            System.out.println(Arrays.toString(annotations));
            System.out.println(Arrays.toString(annotationsByType));
            System.out.println(Arrays.toString(declaredAnnotations));
            System.out.println(Arrays.toString(declaredAnnotationsByType));
        }
        return bean;
    }
}
