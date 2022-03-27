package com.booking.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class InterceptorRegistryConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private Interceptor interceptor;

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(interceptor);
    }
}
