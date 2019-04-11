package com.prophet.ecommerce.adapter.product;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class ProductDetailImageAdapter extends PagerAdapter {

    private List<Integer> productImages;

    public ProductDetailImageAdapter(List<Integer> productImages) {
        this.productImages = productImages;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        // Creating ImageView
        ImageView imageView = new ImageView(container.getContext());
        imageView.setImageResource(productImages.get(position));
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }

    @Override
    public int getCount() {
        return productImages.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
