package com.hrxc.auction.dao;

import com.hrxc.auction.domain.UserInfo;
import com.hrxc.auction.domain.vo.UserInfoVo;
import com.hrxc.auction.util.MyBatisUtils;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class UserInfoDao {

    private static final Logger log = Logger.getLogger(UserInfoDao.class);
    private static final String SQL_QUERY_SINGLE_USER = "select pk_Id pkId,user_no userNo,user_Name userName,password password from user_info where user_no=? ";
    private static final String SQL_UPDATE_PASSWORD = "update user_info set password=? where user_no=?";

    /**
     * 根据用户编号查询用户信息
     *
     * @param userNo
     * @return
     * @throws SQLException
     */
    public UserInfo getUserInfo(String userNo) throws SQLException {
        UserInfoVo condition = new UserInfoVo();
        condition.setUserNo(userNo);
        return (UserInfo) MyBatisUtils.selectOne("UserInfo.getAllObjectInfo", condition);
    }

    /**
     * 修改用户密码
     *
     * @param userNo
     * @param password
     * @throws SQLException
     */
    public void modifyPassword(String userNo, String password) throws SQLException {
        UserInfo dto = new UserInfo();
        dto.setUserNo(userNo);
        dto.setPassword(password);
        MyBatisUtils.selectOne("UserInfo.updateObjectById", dto);
    }
}
