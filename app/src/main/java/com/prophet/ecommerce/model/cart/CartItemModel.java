package com.prophet.ecommerce.model.cart;

public class CartItemModel {
    public static final int CART_ITEM = 0;
    public static final int TOTAL_AMOUNT = 1;

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    /////////
    //Cart item
    private int productImage;
    private String productTitle;
    private int freeCoupon;
    private String productPrice;
    private String cuttedPrice;
    private int productQuantity;
    private int offerApplied;
    private int couponApplied;

    public CartItemModel(int type, int productImage, String productTitle, int freeCoupon, String productPrice, String cuttedPrice, int productQuantity, int offerApplied, int couponApplied) {
        this.type = type;
        this.productImage = productImage;
        this.productTitle = productTitle;
        this.freeCoupon = freeCoupon;
        this.productPrice = productPrice;
        this.cuttedPrice = cuttedPrice;
        this.productQuantity = productQuantity;
        this.offerApplied = offerApplied;
        this.couponApplied = couponApplied;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getFreeCoupon() {
        return freeCoupon;
    }

    public void setFreeCoupon(int freeCoupon) {
        this.freeCoupon = freeCoupon;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getCuttedPrice() {
        return cuttedPrice;
    }

    public void setCuttedPrice(String cuttedPrice) {
        this.cuttedPrice = cuttedPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getOfferApplied() {
        return offerApplied;
    }

    public void setOfferApplied(int offerApplied) {
        this.offerApplied = offerApplied;
    }

    public int getCouponApplied() {
        return couponApplied;
    }

    public void setCouponApplied(int couponApplied) {
        this.couponApplied = couponApplied;
    }
    //////////


    /////////
    //Cart Total
    private String totalItems;
    private String totalItemPrice;
    private String deliveryCost;
    private String savedAmount;
    private String totalAmount;

    public CartItemModel(int type, String totalItems, String totalItemPrice, String deliveryCost, String totalAmount, String savedAmount) {
        this.type = type;
        this.totalItems = totalItems;
        this.totalItemPrice = totalItemPrice;
        this.deliveryCost = deliveryCost;
        this.totalAmount = totalAmount;
        this.savedAmount = savedAmount;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(String totalItems) {
        this.totalItems = totalItems;
    }

    public String getTotalItemPrice() {
        return totalItemPrice;
    }

    public void setTotalItemPrice(String totalItemPrice) {
        this.totalItemPrice = totalItemPrice;
    }

    public String getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(String deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public String getSavedAmount() {
        return savedAmount;
    }

    public void setSavedAmount(String savedAmount) {
        this.savedAmount = savedAmount;
    }
}
