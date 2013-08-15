package com.hrxc.auction.domain;

/**
 *
 * @author user
 */
public class PaymentList {
    /**
     * 主键
     */
    private String pkId;
    /**
     * 付款编号
     */
    private String paymentNo;
    /**
     * 项目编号
     */
    private String projectNo;
    /**
     * 号牌编号
     */
    private String paddleNo;
    /**
     * 拍品数量
     */
    private Integer goodsNum;
    /**
     * 总金额
     */
    private Integer totalAmount;
    /**
     * 已付款
     */
    private Integer accountPaid;
    /**
     * 未付款
     */
    private Integer nonPayment;
    /**
     * 保证金使用状态
     */
    private String cashDepositState;
    /**
     * 付款状态
     */
    private String paymentState;

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getPaddleNo() {
        return paddleNo;
    }

    public void setPaddleNo(String paddleNo) {
        this.paddleNo = paddleNo;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
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

    public String getCashDepositState() {
        return cashDepositState;
    }

    public void setCashDepositState(String cashDepositState) {
        this.cashDepositState = cashDepositState;
    }

    public String getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState;
    }

    @Override
    public String toString() {
        return "PaymentList{" + "pkId=" + pkId + ", paymentNo=" + paymentNo + ", projectNo=" + projectNo + ", paddleNo=" + paddleNo + ", goodsNum=" + goodsNum + ", totalAmount=" + totalAmount + ", accountPaid=" + accountPaid + ", nonPayment=" + nonPayment + ", cashDepositState=" + cashDepositState + ", paymentState=" + paymentState + '}';
    }
}
