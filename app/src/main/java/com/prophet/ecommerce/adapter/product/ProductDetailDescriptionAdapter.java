package com.prophet.ecommerce.adapter.product;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.prophet.ecommerce.ProductDetailDescriptionFragment;
import com.prophet.ecommerce.ProductDetailSpecificationFragment;

public class ProductDetailDescriptionAdapter extends FragmentPagerAdapter {
    private int totalTabs;

    public ProductDetailDescriptionAdapter(FragmentManager fm, int totalTabs) {
        super(fm);
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                ProductDetailDescriptionFragment productDetailDescriptionFragment1 = new ProductDetailDescriptionFragment();
                return productDetailDescriptionFragment1;
            case 1:
                ProductDetailSpecificationFragment productDetailSpecificationFragment = new ProductDetailSpecificationFragment();
                return productDetailSpecificationFragment;
            case 2:
                ProductDetailDescriptionFragment productDetailDescriptionFragment2 = new ProductDetailDescriptionFragment();
                return productDetailDescriptionFragment2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
