/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrxc.auction.action;

import com.hrxc.auction.dao.UserInfoDao;
import com.hrxc.auction.domain.UserInfo;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class UserInfoAction {
    
    private static final Logger log = Logger.getLogger(UserInfoAction.class);
    private static final UserInfoDao dao = new UserInfoDao();
    
    /**
     * 
     * @param userNo
     * @return 
     */
    public static UserInfo getUserInfo(String userNo) {
        UserInfo dto = null;
        try {
            dto = dao.getUserInfo(userNo);
        } catch (Exception ex) {
            log.error("UserInfoAction.getUserInfo.error:", ex);
        }
        return dto;
    }

    /**
     * 修改用户密码
     *
     * @param userNo
     * @param password
     */
    public static void modifyPassword(String userNo, String password) {
        try {
            dao.modifyPassword(userNo, password);
        } catch (Exception ex) {
            log.error("UserInfoAction.modifyPassword:", ex);
        }
        
    }
}
