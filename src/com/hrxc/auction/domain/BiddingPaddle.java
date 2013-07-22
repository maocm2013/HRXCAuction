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
    private String paddleNo;
    private String custName;
    private String certType;
    private String certNo;
    private String custTel;
    private String custAddr;
    private Integer cashDeposit;
    private String remarks;

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

    @Override
    public String toString() {
        return "BiddingPaddle{" + "pkId=" + pkId + ", paddleNo=" + paddleNo + ", custName=" + custName + ", certType=" + certType + ", certNo=" + certNo + ", custTel=" + custTel + ", custAddr=" + custAddr + ", cashDeposit=" + cashDeposit + ", remarks=" + remarks + '}';
    }
    
}
