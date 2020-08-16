package com.example.dynamicdatasourcerouting.configuration;

import com.example.dynamicdatasourcerouting.domain.BranchEnum;
import org.springframework.context.annotation.Configuration;

public class BranchContextHolder {

    private static ThreadLocal<BranchEnum> threadLocal = new ThreadLocal<>();

    public static void setBranchContext(BranchEnum branchEnum){
        threadLocal.set(branchEnum);
    }

    public static BranchEnum getBranchContext(){
        return threadLocal.get();
    }

    public static void clearBranchContext(){
        threadLocal.remove();
    }


}
