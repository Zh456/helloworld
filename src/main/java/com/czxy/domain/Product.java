package com.czxy.domain;

import java.util.Date;

/**
 * @author ZHANGHUI
 * @version v 1.0
 * @date 2019/6/24
 */
public class Product {
    private String pid;
    private String pname;
    private Double marketPrice;
    private Double shopPrice;
    private String pimage;
    private Date pdate;
    private String isHot;
    private String pdesc;
    private Integer pflag;
    private String cid;

    public Product() {
    }

    public Product(String pid, String pname, Double marketPrice, Double shopPrice, String pimage, Date pdate, String isHot, String pdesc, Integer pflag, String cid) {
        this.pid = pid;
        this.pname = pname;
        this.marketPrice = marketPrice;
        this.shopPrice = shopPrice;
        this.pimage = pimage;
        this.pdate = pdate;
        this.isHot = isHot;
        this.pdesc = pdesc;
        this.pflag = pflag;
        this.cid = cid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Double getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(Double shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public String getIsHot() {
        return isHot;
    }

    public void setIsHot(String isHot) {
        this.isHot = isHot;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public Integer getPflag() {
        return pflag;
    }

    public void setPflag(Integer pflag) {
        this.pflag = pflag;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", marketPrice=" + marketPrice +
                ", shopPrice=" + shopPrice +
                ", pimage='" + pimage + '\'' +
                ", pdate=" + pdate +
                ", isHot='" + isHot + '\'' +
                ", pdesc='" + pdesc + '\'' +
                ", pflag=" + pflag +
                ", cid='" + cid + '\'' +
                '}';
    }

}
