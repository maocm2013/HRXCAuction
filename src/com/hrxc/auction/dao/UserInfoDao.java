package com.hrxc.auction.dao;

import com.hrxc.auction.domain.UserInfo;
import com.hrxc.auction.util.JdbcUtil;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
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
        Connection conn = null;
        QueryRunner queryRunner = null;
        UserInfo dto = null;
        try {
            conn = JdbcUtil.getConn();
            queryRunner = new QueryRunner();
            dto = (UserInfo) queryRunner.query(conn, SQL_QUERY_SINGLE_USER, new BeanHandler(UserInfo.class), userNo);
        } finally {
            DbUtils.close(conn);
        }
        return dto;
    }

    /**
     * 修改用户密码
     * @param userNo
     * @param password
     * @throws SQLException 
     */
    public void modifyPassword(String userNo, String password) throws SQLException {
        Connection conn = null;
        QueryRunner queryRunner = null;
        try {
            conn = JdbcUtil.getConn();
            queryRunner = new QueryRunner();
            Object[] params = new Object[2];
            int seq = 0;
            params[seq++] = password;
            params[seq++] = userNo;
            queryRunner.update(conn, SQL_UPDATE_PASSWORD, params);
        } finally {
            DbUtils.close(conn);
        }
    }
}
