package com.hrxc.auction.util;

import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.commons.dbcp.cpdsadapter.DriverAdapterCPDS;
import org.apache.commons.dbcp.datasources.SharedPoolDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
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
    
    private static SqlSessionFactory sqlSessionFactory;

    public static JdbcUtil getInstance() {
        return jdbcUtil;
    }

    static {
        try {
            Properties props = Configuration.loadProperties("config/system.properties");
            String jdbcDriver = props.getProperty("jdbc.driver");
            String jdbcUrl = props.getProperty("jdbc.url");

            cpds = new DriverAdapterCPDS();
            cpds.setDriver(jdbcDriver);
            cpds.setUrl(jdbcUrl);
            tds = new SharedPoolDataSource();
            tds.setConnectionPoolDataSource(cpds);
            tds.setMaxActive(3);
            tds.setMaxWait(60000);
            tds.setMaxIdle(1);

            //初始化mybatis数据库连接工厂
            String resource = "com/hrxc/auction/dao/mapper/jdbc-mybatis.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, props);
        } catch (Exception ex) {
            log.error("init dbpool error:", ex);
        }
    }
    
    /**
     * 获取mybatis数据库连接，mybatis默认连接不自动提交
     * @return 
     */
    public static SqlSession getSession(){
        return sqlSessionFactory.openSession(true);
    }
    
    /**
     * 获取mybatis数据库连接
     * @return 
     */
    public static SqlSession getSession4Transaction(){
        return sqlSessionFactory.openSession();
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
