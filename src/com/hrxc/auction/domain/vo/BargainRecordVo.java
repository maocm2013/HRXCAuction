package com.hrxc.auction.domain.vo;

import com.hrxc.auction.domain.BargainRecord;

/**
 *
 * @author maochangming
 */
public class BargainRecordVo extends BargainRecord {

    /**
     * 拍品名称
     */
    private String goodsName;
    /**
     * 委托方编号
     */
    private String clientNo;
    /**
     * 联系方式
     */
    private String custTel;
    /**
     * 保留价
     */
    private Integer keepPrice;
    /**
     * 竞买人姓名
     */
    private String custName;
    /**
     * 证件号码
     */
    private String certNo;
    /**
     * 是否保号
     */
    private String isKeepNo;

    /**
     * 联系电话
     */
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

    public Integer getKeepPrice() {
        return keepPrice;
    }

    public void setKeepPrice(Integer keepPrice) {
        this.keepPrice = keepPrice;
    }

    public String getIsKeepNo() {
        return isKeepNo;
    }

    public void setIsKeepNo(String isKeepNo) {
        this.isKeepNo = isKeepNo;
    }

    @Override
    public String toString() {
        return "BargainRecordVo{" + "goodsName=" + goodsName + ", clientNo=" + clientNo + ", custTel=" + custTel + ", keepPrice=" + keepPrice + ", custName=" + custName + ", certNo=" + certNo + ", isKeepNo=" + isKeepNo + '}';
    }
}
