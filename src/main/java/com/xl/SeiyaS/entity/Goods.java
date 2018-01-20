package com.xl.SeiyaS.entity;

public class Goods {

    //2test
    private int id;
    private String goodCode;
    private String goodName;
    private String goodPic;
    private Double goodPrice;
    private String goodInfo;

    public Goods() {
    }

    public Goods(int id, String goodCode, String goodName, String goodPic, Double goodPrice, String goodInfo) {
        this.id = id;
        this.goodCode = goodCode;
        this.goodName = goodName;
        this.goodPic = goodPic;
        this.goodPrice = goodPrice;
        this.goodInfo = goodInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodPic() {
        return goodPic;
    }

    public void setGoodPic(String goodPic) {
        this.goodPic = goodPic;
    }

    public Double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(Double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public String getGoodInfo() {
        return goodInfo;
    }

    public void setGoodInfo(String goodInfo) {
        this.goodInfo = goodInfo;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodCode='" + goodCode + '\'' +
                ", goodName='" + goodName + '\'' +
                ", goodPic='" + goodPic + '\'' +
                ", goodPrice=" + goodPrice +
                ", goodInfo='" + goodInfo + '\'' +
                '}';
    }
}
