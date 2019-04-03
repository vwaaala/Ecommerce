package com.prophet.ecommerce.model.homeFragment;

public class Category {
    private String iconLink;
    private String categoryName;

    public Category(String iconLink, String categoryName) {
        this.iconLink = iconLink;
        this.categoryName = categoryName;
    }

    public Category(){}

    public String getIconLink() {
        return iconLink;
    }

    public void setIconLink(String iconLink) {
        this.iconLink = iconLink;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
