package com.prophet.ecommerce.model.homeFragment;

public class ProductModelLite {
    private int image;
    private String title;
    private String description;
    private String price;

    public ProductModelLite() {
    }

    public ProductModelLite(int image, String title, String description, String price) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
