package com.hrxc.auction.util;

import com.alibaba.fastjson.JSON;
import java.util.Map;

/**
 * 数据字典
 * @author user
 */
public class DictEnum {
    public static class ProjectState{
        /**
         * 01-进行中
         */
        public static final String PROCESSING = "01";
        /**
         * 02-已完结
         */
        public static final String FINISHED = "02";
        
        public static final Map dataMap = JSON.parseObject("{\"01\":\"进行中\",\"02\":\"已完结\"}");
    }
}
