package com.prophet.ecommerce.adapter.homeFragment;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.prophet.ecommerce.R;
import com.prophet.ecommerce.model.homeFragment.Slider;

import java.util.List;

public class SliderAdapter extends PagerAdapter {

    private List<Slider> sliderList;

    public SliderAdapter(List<Slider> sliderList) {
        this.sliderList = sliderList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.homefragment_slider_item, container, false);
        ImageView banner = view.findViewById(R.id.sliderImageView);

        ConstraintLayout sliderContainer = view.findViewById(R.id.sliderContainer);
        // Changing slider image background to layout background color
        // so that we see the image corner radius
        sliderContainer.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(sliderList.get(position).getColor())));

        banner.setImageResource(sliderList.get(position).getBanner());
        container.addView(view, 0);
        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return sliderList.size();
    }


}
