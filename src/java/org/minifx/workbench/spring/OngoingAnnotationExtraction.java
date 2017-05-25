/**
 * Copyright (c) 2017 European Organisation for Nuclear Research (CERN), All Rights Reserved.
 */

package org.minifx.workbench.spring;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Optional;

import org.springframework.core.annotation.AnnotationUtils;

public class OngoingAnnotationExtraction {

    private final Method factoryMethod;
    private final Object bean;

    private OngoingAnnotationExtraction(Method factoryMethod, Object bean) {
        this.factoryMethod = factoryMethod;
        this.bean = Objects.requireNonNull(bean, "bean must not be null");
    }

    public static OngoingAnnotationExtraction from(Method factoryMethod, Object bean) {
        return new OngoingAnnotationExtraction(factoryMethod, bean);
    }

    public <T extends Annotation> Optional<T> getAnnotation(Class<T> annotationClass) {
        Optional<T> annotation = getFromFactoryMethod(annotationClass);
        if (annotation.isPresent()) {
            return annotation;
        }
        return Optional.ofNullable(AnnotationUtils.findAnnotation(bean.getClass(), annotationClass));
    }

    private <T extends Annotation> Optional<T> getFromFactoryMethod(Class<T> annotationClass) {
        if (factoryMethod != null) {
            return Optional.ofNullable(AnnotationUtils.findAnnotation(factoryMethod, annotationClass));
        }
        return Optional.empty();
    }

}
