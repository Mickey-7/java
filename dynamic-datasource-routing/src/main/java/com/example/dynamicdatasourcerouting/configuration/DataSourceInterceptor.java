package com.example.dynamicdatasourcerouting.configuration;

import com.example.dynamicdatasourcerouting.domain.BranchEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class DataSourceInterceptor extends HandlerInterceptorAdapter {
    //alt+insert
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String branch = request.getHeader("branch");
        if (BranchEnum.BANGKOK.toString().equalsIgnoreCase(branch)){
            BranchContextHolder.setBranchContext(BranchEnum.BANGKOK);
        }else {
            BranchContextHolder.setBranchContext(BranchEnum.HONGKONG);
        }

        return super.preHandle(request, response, handler);
    }
}
