package com.prophet.ecommerce.model;

public class Slider {
    private int banner;
    private String color;

    public Slider(int banner, String color) {
        this.banner = banner;
        this.color = color;
    }

    public int getBanner() {
        return banner;
    }

    public void setBanner(int banner) {
        this.banner = banner;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
