package com.alamin_tanveer.supplychain.utils;

import org.springframework.security.core.context.SecurityContextHolder;

public class CurrentUser {
    public static String getCurrentUserName(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
