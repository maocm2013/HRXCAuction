/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrxc.auction.dao;

import com.hrxc.auction.domain.GoodsList;
import com.hrxc.auction.util.Configuration;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author user
 */
public class mybatisTest {

    public static void main(String[] args) throws IOException, Exception {
        //初始化log4j
        Configuration.initLog4j();
        
        String resource = "com/hrxc/auction/dao/mapper/jdbc-mybatis.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,Configuration.loadProperties("config/system.properties"));
        SqlSession session = sqlSessionFactory.openSession();
        
        GoodsList goods = new GoodsList();
        goods.setProjectNo("20130728-001");
        List list = session.selectList("GoodsList.getAllObjectInfo",goods);
        System.out.println("list.size=" + list.size());
        session.close();
    }
}
