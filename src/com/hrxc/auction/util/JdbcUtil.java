package com.hrxc.auction.util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.commons.dbcp.cpdsadapter.DriverAdapterCPDS;
import org.apache.commons.dbcp.datasources.SharedPoolDataSource;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class JdbcUtil {

    private static final Logger log = Logger.getLogger(JdbcUtil.class);
    private static final JdbcUtil jdbcUtil = new JdbcUtil();
    private static SharedPoolDataSource tds;
    private static DriverAdapterCPDS cpds;

    public static JdbcUtil getInstance() {
        return jdbcUtil;
    }

    static {
        try {
            cpds = new DriverAdapterCPDS();
            cpds.setDriver("org.sqlite.JDBC");
            String filePath = System.getProperty("user.dir").concat(File.separator).concat("config").concat(File.separator).concat("data.db");
            log.debug("db_filePath=" + filePath);
            cpds.setUrl("jdbc:sqlite:" + filePath);
            tds = new SharedPoolDataSource();
            tds.setConnectionPoolDataSource(cpds);
            tds.setMaxActive(5);
            tds.setMaxWait(60000);
            tds.setMaxIdle(1);
        } catch (Exception ex) {
            log.error("init dbpool error:", ex);
        }


    }

    /**
     * 获取数据库连接
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConn() throws SQLException {
        return tds.getConnection();
    }
}
