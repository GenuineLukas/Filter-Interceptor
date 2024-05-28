package com.example.filter.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class OpenApiInterceptor implements HandlerInterceptor {
    //컨트롤러의 실제 핸들러 메서드가 호출되기 전에 실행되는 메서드
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("pre handle");
        //return true 면 controller 전달, false 면 전달하지 않는다.

        // 핸들러가 HandlerMethod 타입인지 확인 후 캐스팅
        var handlerMethod = (HandlerMethod)handler;

        // 메서드 레벨에서 OpenApi 애노테이션을 확인
        var methodLevel = handlerMethod.getMethodAnnotation(OpenApi.class);
        if(methodLevel != null) {
            log.info("method level"); //메서드 레벨 애노테이션 존재 로그
            return true; //애노테이션이 존재하면 요청을 컨트롤러로 전달
        }

        // 클래스 레벨에서 OpenApi 애노테이션을 확인
        var classLevel = handlerMethod.getBeanType().getAnnotation(OpenApi.class);
        if(classLevel != null){
            log.info("class level"); //클래스 레벨 애노테이션 졵 로그
            return true; //애노테이션이 존재하면 요청을 컨트롤러로 전달
        }

        //애노테이션이 없는 경우 요청을 차단하고 로그 출력
        log.info("open api 아닙니다 : {}", request.getRequestURI());
        return false; //애노테이션이 없으면 요청을 컨트롤러로 전달하지 않음
    }

    //컨트롤러가 실행된 후, 뷰가 렌더링 되기 전에 싱행되는 메서드
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle"); //postHandle 메서드 진입 로그
    }

    //뷰 렌더링 후, 요청 처리가 완료된 후 실행되는 메서드
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion");
    }
}
