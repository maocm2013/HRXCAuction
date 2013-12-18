package com.hrxc.auction.util;

import com.alibaba.fastjson.JSON;
import java.util.Map;

/**
 * 数据字典
 *
 * @author user
 */
public class DictEnum {
    private static final DictEnum dictEnum = new DictEnum();
    
    private DictEnum(){
    }
    
    public static DictEnum getInstance(){
        return dictEnum;
    }

    /**
     * 获取数据字典描述
     * @param dataMap
     * @param value
     * @return 
     */
    public static String getDictDesc(Map dataMap, String value) {
        return value + "-" + (String) dataMap.get(value);
    }

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
         * 01-已成交未复核
         */
        public static final String BARGAIN = "01";
        /**
         * 02-已复核未结算
         */
        public static final String RECHECKED = "02";
        /**
         * 03-已结算
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
        
        /**
         * 09-已失效
         */
        public static final String INVALID = "09";
        
        public static final Map dataMap = JSON.parseObject("{\"01\":\"未结清\",\"02\":\"已结清\",\"09\":\"已失效\"}");
    }
    
    /**
     * 是否保号号牌
     */
    public static class IsKeepNo{
        /**
         * Y-是
         */
        public static final String IS_KEEP_NO_Y = "Y";
        /**
         * N-否
         */
        public static final String IS_KEEP_NO_N = "N";
        
        public static final Map dataMap = JSON.parseObject("{\"N\":\"否\",\"Y\":\"是\"}");
    }
}
