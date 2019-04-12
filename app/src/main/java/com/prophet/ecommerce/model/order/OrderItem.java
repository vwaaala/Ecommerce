package com.prophet.ecommerce.model.order;

public class OrderItem {

    private int productImage;
    private String productTitle;
    private String deliveryStatus;
    private int rating;

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

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public OrderItem(String productTitle, int productImage, String deliveryStatus, int rating) {
        this.productTitle = productTitle;
        this.productImage = productImage;
        this.deliveryStatus = deliveryStatus;
        this.rating = rating;
    }
}
