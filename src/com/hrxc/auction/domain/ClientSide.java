package com.hrxc.auction.domain;

/**
 *
 * @author user
 */
public class ClientSide {

    /**
     * 主键
     */
    private String pkId;
    /**
     * 委托方编号
     */
    private String clientNo;
    /**
     * 委托方名称
     */
    private String clientName;

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public String toString() {
        return "ClientSide{" + "pkId=" + pkId + ", clientNo=" + clientNo + ", clientName=" + clientName + '}';
    }
}
