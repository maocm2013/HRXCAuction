package com.hrxc.auction.domain.vo;

import com.hrxc.auction.domain.BargainRecord;

/**
 *
 * @author maochangming
 */
public class BargainRecordVo extends BargainRecord{
    private String goodsName;
    private String clientNo;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }
    
}
