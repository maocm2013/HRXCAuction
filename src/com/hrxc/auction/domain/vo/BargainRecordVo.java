package com.hrxc.auction.domain.vo;

import com.hrxc.auction.domain.BargainRecord;

/**
 *
 * @author maochangming
 */
public class BargainRecordVo extends BargainRecord {

    private String goodsName;
    private String clientNo;
    /**
     * 竞买人姓名
     */
    private String custName;
    /**
     * 证件号码
     */
    private String certNo;
    /**
     * 联系电话
     */
    private String custTel;

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

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getCustTel() {
        return custTel;
    }

    public void setCustTel(String custTel) {
        this.custTel = custTel;
    }
    
}
