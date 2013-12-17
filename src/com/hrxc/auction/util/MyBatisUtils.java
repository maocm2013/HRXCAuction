package com.hrxc.auction.util;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class MyBatisUtils {

    private static final Logger log = Logger.getLogger(MyBatisUtils.class);

    public static Object selectOne(String statement) {
        SqlSession session = null;
        try {
            session = JdbcUtil.getInstance().getSession();
            return session.selectOne(statement);
        } finally {
            session.close();
        }
    }

    public static Object selectOne(String statement, Object parameter) {
        SqlSession session = null;
        try {
            session = JdbcUtil.getInstance().getSession();
            return session.selectOne(statement, parameter);
        } finally {
            session.close();
        }
    }

    public static Map selectMap(String statement, String mapKey) {
        SqlSession session = null;
        try {
            session = JdbcUtil.getInstance().getSession();
            return session.selectMap(statement, mapKey);
        } finally {
            session.close();
        }
    }

    public static Map selectMap(String statement, Object parameter, String mapKey) {
        SqlSession session = null;
        try {
            session = JdbcUtil.getInstance().getSession();
            return session.selectMap(statement, parameter, mapKey);
        } finally {
            session.close();
        }
    }

    public static Map selectMap(String statement, Object parameter, String mapKey, RowBounds rowBounds) {
        SqlSession session = null;
        try {
            session = JdbcUtil.getInstance().getSession();
            return session.selectMap(statement, parameter, mapKey, rowBounds);
        } finally {
            session.close();
        }
    }

    public static List selectList(String statement) {
        SqlSession session = null;
        try {
            session = JdbcUtil.getInstance().getSession();
            return session.selectList(statement);
        } finally {
            session.close();
        }
    }

    public static List selectList(String statement, Object parameter) {
        SqlSession session = null;
        try {
            session = JdbcUtil.getInstance().getSession();
            return session.selectList(statement, parameter);
        } finally {
            session.close();
        }
    }

    public static List selectList(String statement, Object parameter, RowBounds rowBounds) {
        SqlSession session = null;
        try {
            session = JdbcUtil.getInstance().getSession();
            return session.selectList(statement, parameter, rowBounds);
        } finally {
            session.close();
        }
    }

    public static void select(String statement, ResultHandler handler) {
        SqlSession session = null;
        try {
            session = JdbcUtil.getInstance().getSession();
            session.select(statement, handler);
        } finally {
            session.close();
        }
    }

    public static void select(String statement, Object parameter, ResultHandler handler) {
        SqlSession session = null;
        try {
            session = JdbcUtil.getInstance().getSession();
            session.select(statement, parameter, handler);
        } finally {
            session.close();
        }
    }

    public static void select(String statement, Object parameter, RowBounds rowBounds, ResultHandler handler) {
        SqlSession session = null;
        try {
            session = JdbcUtil.getInstance().getSession();
            session.select(statement, parameter, rowBounds, handler);
        } finally {
            session.close();
        }
    }

    public static int insert(String statement) {
        SqlSession session = null;
        try {
            session = JdbcUtil.getInstance().getSession();
            return session.insert(statement);
        } finally {
            session.close();
        }
    }

    public static int insert(String statement, Object parameter) {
        SqlSession session = null;
        try {
            session = JdbcUtil.getInstance().getSession();
            return session.insert(statement, parameter);
        } finally {
            session.close();
        }
    }

    public static void insertOnTransaction(String statement, List<?> params) {
        SqlSession session = null;
        try {
            session = JdbcUtil.getInstance().getSession4Transaction();

            if (params != null && params.size() > 0) {
                for (int i = 0; i < params.size(); i++) {
                    session.insert(statement, params.get(i));
                }
            }
            session.commit();
        } finally {
            session.close();
        }
    }

    public static int update(String statement) {
        SqlSession session = null;
        try {
            session = JdbcUtil.getInstance().getSession();
            return session.update(statement);
        } finally {
            session.close();
        }
    }

    public static int update(String statement, Object parameter) {
        SqlSession session = null;
        try {
            session = JdbcUtil.getInstance().getSession();
            return session.update(statement, parameter);
        } finally {
            session.close();
        }
    }

    public static int delete(String statement) {
        SqlSession session = null;
        try {
            session = JdbcUtil.getInstance().getSession();
            return session.delete(statement);
        } finally {
            session.close();
        }
    }

    public static int delete(String statement, Object parameter) {
        SqlSession session = null;
        try {
            session = JdbcUtil.getInstance().getSession();
            return session.delete(statement, parameter);
        } finally {
            session.close();
        }
    }

    public static void deleteOnTransaction(String statement, List<?> params) {
        SqlSession session = null;
        try {
            session = JdbcUtil.getInstance().getSession4Transaction();
            if (params != null && params.size() > 0) {
                for (int i = 0; i < params.size(); i++) {
                    session.delete(statement, params.get(i));
                }
            }
            session.commit();
        } finally {
            session.close();
        }
    }

    public static <T> T getMapper(Class<T> type) {
        SqlSession session = null;
        try {
            session = JdbcUtil.getInstance().getSession();
            return session.getMapper(type);
        } finally {
            session.close();
        }
    }
}
