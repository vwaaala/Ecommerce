package com.prophet.ecommerce.model;

public class RewardModel {
    private String title;
    private String validity;
    private String body;

    public RewardModel(String title, String validity, String body) {
        this.title = title;
        this.validity = validity;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
