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
    private String goodsNo;
    private String goodsName;
    private String goodsIntact;
    private String goodsSize;
    private String certificateNo;
    private Integer keepPrice;
    private Integer marketPrice;
    private Integer onsetPrice;

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

    @Override
    public String toString() {
        return "GoodsList{" + "pkId=" + pkId + ", goodsNo=" + goodsNo + ", goodsName=" + goodsName + ", goodsIntact=" + goodsIntact + ", goodsSize=" + goodsSize + ", certificateNo=" + certificateNo + ", keepPrice=" + keepPrice + ", marketPrice=" + marketPrice + ", onsetPrice=" + onsetPrice + '}';
    }
    
    
}
