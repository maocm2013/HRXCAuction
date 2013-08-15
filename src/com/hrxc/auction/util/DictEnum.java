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
    public static class SettleState {

        /**
         * 已成交未复核
         */
        public static final String BARGAIN = "01";
        /**
         * 已复核未结算
         */
        public static final String RECHECKED = "02";
        /**
         * 已结算
         */
        public static final String SETTLED = "03";
        public static final Map dataMap = JSON.parseObject("{\"01\":\"已成交未复核\",\"02\":\"已复核未结算\",\"03\":\"已结算\"}");
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
         * 02-已抵扣
         */
        public static final String HAVE_USED = "02";
        /**
         * 03-已退还
         */
        public static final String GIVE_BACK = "03";
        public static final Map dataMap = JSON.parseObject("{\"01\":\"未使用\",\"02\":\"已抵扣\",\"03\":\"已退还\"}");
    }

    /**
     * 付款状态
     */
    public static class PaymentState {

        /**
         * 01-未结清
         */
        public static final String NOT_SETTLED = "01";
        /**
         * 02-已结清
         */
        public static final String HAVE_SETTLED = "02";
        
        public static final Map dataMap = JSON.parseObject("{\"01\":\"未结清\",\"02\":\"已结清\"}");
    }
}
