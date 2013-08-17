package com.hrxc.auction.util;

import java.io.Reader;
import java.util.Properties;
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
    
    private static SqlSessionFactory sqlSessionFactory;

    public static JdbcUtil getInstance() {
        return jdbcUtil;
    }

    static {
        try {
            Properties props = Configuration.loadProperties("config/system.properties");
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
    public SqlSession getSession(){
        return sqlSessionFactory.openSession(true);
    }
    
    /**
     * 获取mybatis数据库连接
     * @return 
     */
    public SqlSession getSession4Transaction(){
        return sqlSessionFactory.openSession();
    }
}
