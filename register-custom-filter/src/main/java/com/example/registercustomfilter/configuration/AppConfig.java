package com.example.registercustomfilter.configuration;

import com.example.registercustomfilter.filter.CustomURLFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public FilterRegistrationBean<CustomURLFilter> filterFilterRegistrationBean(){
        FilterRegistrationBean<CustomURLFilter> registrationBean = new FilterRegistrationBean<>();
        CustomURLFilter customURLFilter = new CustomURLFilter();

        registrationBean.setFilter(customURLFilter);
        registrationBean.addUrlPatterns("/greetings");
        registrationBean.setOrder(2);
        return registrationBean;
    }
}
