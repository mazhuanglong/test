package com.example.todayinformation.base;

import java.lang.annotation.ElementType;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)//运行时注解
@Target(ElementType.TYPE)//类、接口注解
public @interface ViewInject {
    int mainlayoutid() default  -1;

}
