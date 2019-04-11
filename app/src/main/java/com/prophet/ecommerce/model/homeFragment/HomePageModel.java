package com.prophet.ecommerce.model.homeFragment;

import java.util.List;

public class HomePageModel {

    // Use publicly and yet cant be change
    public static final int STATIC_SLIDER = 0;
    public static final int STATIC_STRIP_ADD = 1;
    public static final int STATIC_DEALS = 2;
    public static final int STATIC_GRID = 3;

    private int type;


    // Slider
    private List<Slider> sliderList;

    public HomePageModel(int type, List<Slider> sliderList) {
        this.type = type;
        this.sliderList = sliderList;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Slider> getSliderList() {
        return sliderList;
    }

    public void setSliderList(List<Slider> sliderList) {
        this.sliderList = sliderList;
    }


    // Strip advertise
    private int imageId;
    private String color;

    public HomePageModel(int type, int imageId, String color) {
        this.type = type;
        this.imageId = imageId;
        this.color = color;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    // Deals
    private String dealsLayoutTitile;
    private List<ProductModelLite> dealsList;

    public HomePageModel(int type, String dealsLayoutTitile, List<ProductModelLite> dealsList) {
        this.type = type;
        this.dealsLayoutTitile = dealsLayoutTitile;
        this.dealsList = dealsList;
    }

    public String getTitle() {
        return dealsLayoutTitile;
    }

    public void setTitle(String dealsLyaoutTitile) {
        this.dealsLayoutTitile = dealsLyaoutTitile;
    }

    public List<ProductModelLite> getDealsList() {
        return dealsList;
    }

    public void setDealsList(List<ProductModelLite> dealsList) {
        this.dealsList = dealsList;
    }

    // Grid layout
    private String gridLyaoutTitle;
    private List<GridLayoutModel> gridList;


}
