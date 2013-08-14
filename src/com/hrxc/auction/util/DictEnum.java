package com.hrxc.auction.util;

import com.alibaba.fastjson.JSON;
import java.util.Map;

/**
 * 数据字典
 *
 * @author user
 */
public class DictEnum {

    /**
     * 项目状态
     */
    public static class ProjectState {

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

    /**
     * 结算状态
     */
    public static class IsSettled {

        /**
         * 未结算
         */
        public static final String NO_SETTLED = "N";
        /**
         * 已结算
         */
        public static final String HAVE_SETTLED = "Y";
        public static final Map dataMap = JSON.parseObject("{\"N\":\"未结算\",\"Y\":\"已结算\"}");
    }

    /**
     * 保证金使用状态
     */
    public static class CashDepositState {

        /**
         * 01-未使用
         */
        public static final String NOT_USE = "01";
        /**
         * 02-已使用
         */
        public static final String HAVE_USED = "02";
        public static final Map dataMap = JSON.parseObject("{\"01\":\"未使用\",\"02\":\"已使用\"}");
    }
}
