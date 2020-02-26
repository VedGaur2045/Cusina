package com.example.cusina.AdapterClass.productImageAndNameRecycler;

public class productHolder {
    private String productNameArr;
    private Integer productImgArr;

    public productHolder(String productNameArr, Integer productImgArr) {
        this.productNameArr = productNameArr;
        this.productImgArr = productImgArr;
    }

    public String getProductNameArr() {
        return productNameArr;
    }

    public void setProductNameArr(String productNameArr) {
        this.productNameArr = productNameArr;
    }

    public Integer getProductImgArr() {
        return productImgArr;
    }

    public void setProductImgArr(Integer productImgArr) {
        this.productImgArr = productImgArr;
    }
}
