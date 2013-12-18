/**
 * 竞买号牌信息
 */
package com.hrxc.auction.domain;

/**
 *
 * @author user
 */
public class BiddingPaddle {

    private String pkId;
    /**
     * 竞买号牌编号
     */
    private String paddleNo;
    /**
     * 竞买人姓名
     */
    private String custName;
    /**
     * 证件类型
     */
    private String certType;
    /**
     * 证件号码
     */
    private String certNo;
    /**
     * 联系电话
     */
    private String custTel;
    /**
     * 通讯地址
     */
    private String custAddr;
    /**
     * 保证金
     */
    private Integer cashDeposit;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 项目编号
     */
    private String projectNo;
    /**
     * 保证金使用状态
     */
    private String cashDepositState;
    
    /**
     * 保证金付款编号
     */
    private String cashDepositPaymentNo;
    /**
     * 是否保留号牌 Y-是 N-否
     */
    private String isKeepNo;

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

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
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

    public String getCustAddr() {
        return custAddr;
    }

    public void setCustAddr(String custAddr) {
        this.custAddr = custAddr;
    }

    public Integer getCashDeposit() {
        return cashDeposit;
    }

    public void setCashDeposit(Integer cashDeposit) {
        this.cashDeposit = cashDeposit;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getCashDepositState() {
        return cashDepositState;
    }

    public void setCashDepositState(String cashDepositState) {
        this.cashDepositState = cashDepositState;
    }

    public String getCashDepositPaymentNo() {
        return cashDepositPaymentNo;
    }

    public void setCashDepositPaymentNo(String cashDepositPaymentNo) {
        this.cashDepositPaymentNo = cashDepositPaymentNo;
    }

    public String getIsKeepNo() {
        return isKeepNo;
    }

    public void setIsKeepNo(String isKeepNo) {
        this.isKeepNo = isKeepNo;
    }

    @Override
    public String toString() {
        return "BiddingPaddle{" + "pkId=" + pkId + ", paddleNo=" + paddleNo + ", custName=" + custName + ", certType=" + certType + ", certNo=" + certNo + ", custTel=" + custTel + ", custAddr=" + custAddr + ", cashDeposit=" + cashDeposit + ", remarks=" + remarks + ", projectNo=" + projectNo + ", cashDepositState=" + cashDepositState + ", cashDepositPaymentNo=" + cashDepositPaymentNo + ", isKeepNo=" + isKeepNo + '}';
    }
    

}
