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
     * 项目编号
     */
    private String projectNo;
    /**
     * 结算状态
     */
    private String settleState;
    /**
     * 付款编号
     */
    private String paymentNo;

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

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }

    public String getSettleState() {
        return settleState;
    }

    public void setSettleState(String settleState) {
        this.settleState = settleState;
    }

    @Override
    public String toString() {
        return "BargainRecord{" + "pkId=" + pkId + ", paddleNo=" + paddleNo + ", goodsNo=" + goodsNo + ", bargainConfirmNo=" + bargainConfirmNo + ", hammerPrice=" + hammerPrice + ", commission=" + commission + ", otherFund=" + otherFund + ", bargainPrice=" + bargainPrice + ", projectNo=" + projectNo + ", settleState=" + settleState + ", paymentNo=" + paymentNo + '}';
    }

}
