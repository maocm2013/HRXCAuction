/**
 * 成交记录
 */
package com.hrxc.auction.domain;

/**
 *
 * @author user
 */
public class BargainRecord {
    private String pkId;
    /**
     * 号牌编号
     */
    private String paddleNo;
    /**
     * 拍品编号
     */
    private String goodsNo;
    /**
     * 成交确认书编号
     */
    private String bargainConfirmNo;
    /**
     * 落锤价
     */
    private Integer hammerPrice;
    /**
     * 佣金
     */
    private Integer commission;
    /**
     * 其它款项
     */
    private Integer otherFund;
    /**
     * 成交总价
     */
    private Integer bargainPrice;
    /**
     * 已付款
     */
    private Integer accountPaid;
    /**
     * 未付款
     */
    private Integer nonPayment;

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    public String getPaddleNo() {
        return paddleNo;
    }

    public void setPaddleNo(String paddleNo) {
        this.paddleNo = paddleNo;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getBargainConfirmNo() {
        return bargainConfirmNo;
    }

    public void setBargainConfirmNo(String bargainConfirmNo) {
        this.bargainConfirmNo = bargainConfirmNo;
    }

    public Integer getHammerPrice() {
        return hammerPrice;
    }

    public void setHammerPrice(Integer hammerPrice) {
        this.hammerPrice = hammerPrice;
    }

    public Integer getCommission() {
        return commission;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    public Integer getOtherFund() {
        return otherFund;
    }

    public void setOtherFund(Integer otherFund) {
        this.otherFund = otherFund;
    }

    public Integer getBargainPrice() {
        return bargainPrice;
    }

    public void setBargainPrice(Integer bargainPrice) {
        this.bargainPrice = bargainPrice;
    }

    public Integer getAccountPaid() {
        return accountPaid;
    }

    public void setAccountPaid(Integer accountPaid) {
        this.accountPaid = accountPaid;
    }

    public Integer getNonPayment() {
        return nonPayment;
    }

    public void setNonPayment(Integer nonPayment) {
        this.nonPayment = nonPayment;
    }

    @Override
    public String toString() {
        return "BargainRecord{" + "pkId=" + pkId + ", paddleNo=" + paddleNo + ", goodsNo=" + goodsNo + ", bargainConfirmNo=" + bargainConfirmNo + ", hammerPrice=" + hammerPrice + ", commission=" + commission + ", otherFund=" + otherFund + ", bargainPrice=" + bargainPrice + ", accountPaid=" + accountPaid + ", nonPayment=" + nonPayment + '}';
    }
    
}
