package com.example.filter.config;

import com.example.filter.interceptor.OpenApiInterceptor;
import lombok.Builder;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Builder
@Configuration
public class WebConfig implements WebMvcConfigurer {
    // OpenApiInterceptor 인스턴스를 주입받는다.
    private final OpenApiInterceptor openApiInterceptor;

    // 인터셉트를 등록하는 메서드이다.
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // OpenApiInterceptor를 등록하고, 모든 경로에 대해 적용한다.
        registry.addInterceptor(openApiInterceptor)
                .addPathPatterns("/**");
    }
}
