package com.prophet.ecommerce.model.wishlist;

public class WishListModel {
    private int imageResource;
    private String title;
    private int freeCoupon;
    private String rating;
    private int totalRating;
    private String productPrice;
    private String cuttedPrice;
    private String paymentMethod;

    public WishListModel(int imageResource, String title, int freeCoupon, String rating, int totalRating, String productPrice, String cuttedPrice, String paymentMethod) {
        this.imageResource = imageResource;
        this.title = title;
        this.freeCoupon = freeCoupon;
        this.rating = rating;
        this.totalRating = totalRating;
        this.productPrice = productPrice;
        this.cuttedPrice = cuttedPrice;
        this.paymentMethod = paymentMethod;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFreeCoupon() {
        return freeCoupon;
    }

    public void setFreeCoupon(int freeCoupon) {
        this.freeCoupon = freeCoupon;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(int totalRating) {
        this.totalRating = totalRating;
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
