package com.example.filter.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target 애노테이션은 이 커스텀 애노테이션이 어디에 적용될 수 있는지 지정한다.
@Target(value = {ElementType.METHOD, ElementType.TYPE})
//@Retention 애노테이션은 이 커스텀 애노테이션의 유지 정책을 지정한다.
@Retention(RetentionPolicy.RUNTIME)
public @interface OpenApi {
}
