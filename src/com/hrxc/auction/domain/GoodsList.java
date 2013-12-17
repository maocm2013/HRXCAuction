/**
 * 拍品清单
 */
package com.hrxc.auction.domain;

/**
 *
 * @author user
 */
public class GoodsList {

    private String pkId;
    /**
     * 拍品编号
     */
    private String goodsNo;
    /**
     * 名称
     */
    private String goodsName;
    /**
     * 完残度
     */
    private String goodsIntact;
    /**
     * 尺寸
     */
    private String goodsSize;
    /**
     * 证书编号
     */
    private String certificateNo;
    /**
     * 保留价
     */
    private Integer keepPrice;
    /**
     * 市场估价
     */
    private Integer marketPrice;
    /**
     * 起拍价
     */
    private Integer onsetPrice;
    /**
     * 项目编号
     */
    private String projectNo;
    /**
     * 委托方编号
     */
    private String clientNo;
    /**
     * 入库号
     */
    private String depotNo;
    /**
     * 作者
     */
    private String author;

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsIntact() {
        return goodsIntact;
    }

    public void setGoodsIntact(String goodsIntact) {
        this.goodsIntact = goodsIntact;
    }

    public String getGoodsSize() {
        return goodsSize;
    }

    public void setGoodsSize(String goodsSize) {
        this.goodsSize = goodsSize;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public Integer getKeepPrice() {
        return keepPrice;
    }

    public void setKeepPrice(Integer keepPrice) {
        this.keepPrice = keepPrice;
    }

    public Integer getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Integer marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Integer getOnsetPrice() {
        return onsetPrice;
    }

    public void setOnsetPrice(Integer onsetPrice) {
        this.onsetPrice = onsetPrice;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getDepotNo() {
        return depotNo;
    }

    public void setDepotNo(String depotNo) {
        this.depotNo = depotNo;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "GoodsList{" + "pkId=" + pkId + ", goodsNo=" + goodsNo + ", goodsName=" + goodsName + ", goodsIntact=" + goodsIntact + ", goodsSize=" + goodsSize + ", certificateNo=" + certificateNo + ", keepPrice=" + keepPrice + ", marketPrice=" + marketPrice + ", onsetPrice=" + onsetPrice + ", projectNo=" + projectNo + ", clientNo=" + clientNo + ", depotNo=" + depotNo + ", author=" + author + '}';
    }
    

}
