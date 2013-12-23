/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrxc.auction.util;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author user
 */
public class Configuration {

    private static Logger log = Logger.getLogger(Configuration.class);
    private static final Configuration configuration = new Configuration();
    private String goodsImageRootPath;
    private String goodsImageTempPath;
    
    public static Configuration getInstance() {
        return configuration;
    }

    /**
     * 初始化系统参数环境
     */
    public void initSystemContext() {
        Properties props = Configuration.loadProperties("config/system.properties");

        //获取拍品图像存储根路径
        this.goodsImageRootPath = props.getProperty("goods.images.rootPath");
        UITools.checkOrSaveDir(this.goodsImageRootPath);
        log.debug("拍品图像存储根路径：" + this.goodsImageRootPath);

        //获取拍品图像存储临时路径
        this.goodsImageTempPath = props.getProperty("goods.images.tempPath");
        UITools.checkOrSaveDir(this.getGoodsImageTempPath());
        log.debug("拍品图像存储临时路径：" + this.goodsImageTempPath);
    }

    /**
     * 初始化log4j配置信息
     *
     * @throws Exception
     */
    public static void initLog4j() throws Exception {
        Properties props = loadProperties("config/log4j.properties");
        PropertyConfigurator.configure(props);
    }

    /**
     * 根据文件路径读取资源信息
     *
     * @param filePath
     * @return
     */
    public static Properties loadProperties(String filePath) {
        FileInputStream istream = null;
        Properties props = null;
        try {
            props = new Properties();
            istream = new FileInputStream(filePath);
            props.load(istream);//从输入流中读取属性列表
        } catch (Exception ex) {
            log.error("loadProperties.error:", ex);
        } finally {
            try {
                istream.close();
            } catch (Exception ex) {
                log.error("loadProperties.error:", ex);
            }
        }
        return props;
    }

    public String getGoodsImageRootPath() {
        return goodsImageRootPath;
    }

    public String getGoodsImageTempPath() {
        return goodsImageTempPath;
    }
}
