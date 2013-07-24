package com.hrxc.auction.util;

import com.hrxc.auction.domain.UserInfo;

/**
 *
 * @author user
 */
public class SystemContext {
    private static final SystemContext context = new SystemContext();
    
    private UserInfo user;

    private SystemContext(){
        
    }
    
    public static SystemContext getInstance(){
        return context;
    }
    
    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }
    
}
