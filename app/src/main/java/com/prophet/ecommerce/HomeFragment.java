package com.prophet.ecommerce;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.prophet.ecommerce.adapter.CategoryAdapter;
import com.prophet.ecommerce.adapter.SliderAdapter;
import com.prophet.ecommerce.model.Category;
import com.prophet.ecommerce.model.Slider;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    public HomeFragment() {
        // Required empty public constructor
    }



    ////////////////////////////
    // todo: Slider advertisement

    private ViewPager sliderViewPager;
    private List<Slider> sliderList;
    private int dummyInt = 2;
    private Timer timer;
    final private long DELAY_TIME = 2000;
    final private long PERIOD_TIME = 2000;

    ////////////////////////////


    //////////////////////
    // todo: Strip add
    private ImageView stripImage;
    private ConstraintLayout stripContainer;
    //////////////////////


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // Casting recyclerview from layout
        categoryRecyclerView = view.findViewById(R.id.category_recyclerView);
        // Creating layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        List<Category> categories = new ArrayList<>();
        categories.add(new Category("link", "Home"));
        categories.add(new Category("link", "Furniture"));
        categories.add(new Category("link", "Home Appliance"));
        categories.add(new Category("link", "Kitchen Appliance"));
        categories.add(new Category("link", "Electronics"));
        categories.add(new Category("link", "Men"));
        categories.add(new Category("link", "Women"));
        categories.add(new Category("link", "Kid"));
        categories.add(new Category("link", "Books"));
        categories.add(new Category("link", "Medicine"));


        categoryAdapter = new CategoryAdapter(categories);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();



        /////////////////////
        // todo: Slider advertisement

        sliderViewPager = view.findViewById(R.id.banner_slider_viewpager);
        sliderList = new ArrayList<>();



        // laster da
        sliderList.add(new Slider(R.mipmap.s5, "#ffffff"));
        sliderList.add(new Slider(R.mipmap.s6, "#ffffff"));

        // mal
        sliderList.add(new Slider(R.mipmap.s1, "#ffffff"));
        sliderList.add(new Slider(R.mipmap.s2, "#ffffff"));
        sliderList.add(new Slider(R.mipmap.s3, "#ffffff"));
        sliderList.add(new Slider(R.mipmap.s4, "#ffffff"));
        sliderList.add(new Slider(R.mipmap.s5, "#ffffff"));
        sliderList.add(new Slider(R.mipmap.s6, "#ffffff"));
        // pothom da

        sliderList.add(new Slider(R.mipmap.s1, "#ffffff"));
        sliderList.add(new Slider(R.mipmap.s2, "#ffffff"));

        SliderAdapter sliderAdapter = new SliderAdapter(sliderList);
        sliderViewPager.setAdapter(sliderAdapter);
        sliderViewPager.setClipToPadding(false);
        sliderViewPager.setPageMargin(20);
        sliderViewPager.setCurrentItem(dummyInt);
        sliderAdapter.notifyDataSetChanged();
        //// page listener
        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                dummyInt = i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if (i == ViewPager.SCROLL_STATE_IDLE){
                    pagerLooper();
                }
            }
        };
        sliderViewPager.addOnPageChangeListener(onPageChangeListener);

        startSlideShow();

        // touch listener
        sliderViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pagerLooper();
                stopSliderShow();
                if (event.getAction() == MotionEvent.ACTION_UP){
                    startSlideShow();
                }
                return false;
            }


        });
        //////////////////



        //////////////////
        // todo: strip add body
        stripImage = view.findViewById(R.id.strip_ad_imageView);
        stripContainer = view.findViewById(R.id.strip_ad_container);

        stripImage.setImageResource(R.mipmap.s1);
        stripContainer.setBackgroundColor(Color.parseColor("#000000"));


        //////////////////

        return view;
    }



    ////////////////////

    private void pagerLooper(){
        if (dummyInt == sliderList.size() - 2){
            dummyInt = 2;
            sliderViewPager.setCurrentItem(dummyInt, false);
        }

        if (dummyInt == 1){
            dummyInt = sliderList.size() - 3;
            sliderViewPager.setCurrentItem(dummyInt, false);
        }


    }

    private void startSlideShow(){
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (dummyInt >= sliderList.size()){
                    dummyInt = 1;
                }
                sliderViewPager.setCurrentItem(dummyInt++, true);
            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, DELAY_TIME, PERIOD_TIME);
    }

    private void stopSliderShow(){
        timer.cancel();
    }
    ////////////////////

}
