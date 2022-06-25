package com.example.demo.config;

import com.example.demo.interceptor.ParamLogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Configure implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //registry.addInterceptor(new ParamLogInterceptor());
    }

//    @Bean
//    public FilterRegistrationBean requestIDFilterRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(requestIDFilter());
//        registration.addUrlPatterns("/*");
//        registration.setOrder(6);
//        return registration;
//    }
//
//    @Bean
//    public FilterRegistrationBean httpWrapperFilterRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(httpWrapperFilter());
//        registration.addUrlPatterns("/*");
//        registration.setOrder(7);
//        return registration;
//    }

    //
//    @Bean
//    public FilterRegistrationBean responseLogFilterRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(responseLoggingFilter());
//        registration.addUrlPatterns("/*");
//        registration.setOrder(8);
//        return registration;
//    }
//
//    @Bean
//    public RequestLogFilter requestLoggingFilter() {
//        RequestLogFilter loggingFilter = new RequestLogFilter();
//        loggingFilter.setIncludeHeaders(true);
//        // 客户端 IP信息
//        // loggingFilter.setIncludeClientInfo(true);
//        loggingFilter.setIncludeQueryString(true);
//        loggingFilter.setIncludePayload(true);
//        loggingFilter.setMaxPayloadLength(2000);
//        return loggingFilter;
//    }
//
//    @Bean
//    public HttpWrapperFilter httpWrapperFilter() {
//        return new HttpWrapperFilter();
//    }
//
//    @Bean
//    public RequestIDFilter requestIDFilter() {
//        return new RequestIDFilter();
//    }


}
