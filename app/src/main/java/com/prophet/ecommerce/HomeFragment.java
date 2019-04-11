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
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.prophet.ecommerce.adapter.category.CategoryAdapter;
import com.prophet.ecommerce.adapter.homeFragment.GridProductAdapter;
import com.prophet.ecommerce.adapter.homeFragment.SliderAdapter;
import com.prophet.ecommerce.adapter.homeFragment.DealsAdapter;
import com.prophet.ecommerce.adapter.homeFragment.HomePageAdapter;
import com.prophet.ecommerce.model.homeFragment.Category;
import com.prophet.ecommerce.model.homeFragment.HomePageModel;
import com.prophet.ecommerce.model.homeFragment.ProductModelLite;
import com.prophet.ecommerce.model.homeFragment.Slider;

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
    private RecyclerView homeContentRecyclerView;
    public HomeFragment() {
        // Required empty public constructor
    }


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


        List<Slider> sliderList = new ArrayList<>();



        sliderList.add(new Slider(R.mipmap.s1, "#ffffff"));
        sliderList.add(new Slider(R.mipmap.s2, "#ffffff"));
        sliderList.add(new Slider(R.mipmap.s3, "#ffffff"));

        sliderList.add(new Slider(R.mipmap.s4, "#ffffff"));
        sliderList.add(new Slider(R.mipmap.s5, "#ffffff"));
        sliderList.add(new Slider(R.mipmap.s6, "#ffffff"));
        sliderList.add(new Slider(R.mipmap.d5, "#ffffff"));
        sliderList.add(new Slider(R.mipmap.d5, "#ffffff"));
        sliderList.add(new Slider(R.mipmap.s1, "#ffffff"));

        sliderList.add(new Slider(R.mipmap.s2, "#ffffff"));
        sliderList.add(new Slider(R.mipmap.s3, "#ffffff"));
        sliderList.add(new Slider(R.mipmap.s4, "#ffffff"));




        List<ProductModelLite> productModelLiteList = new ArrayList<>();
        productModelLiteList.add(new ProductModelLite(R.mipmap.d1, "Redmi 5", "Snapdragon 450", "$199"));
        productModelLiteList.add(new ProductModelLite(R.mipmap.d2, "Redmi 5", "Snapdragon 450", "$199"));
        productModelLiteList.add(new ProductModelLite(R.mipmap.d3, "Redmi 5", "Snapdragon 450", "$199"));
        productModelLiteList.add(new ProductModelLite(R.mipmap.d4, "Redmi 5", "Snapdragon 450", "$199"));
        productModelLiteList.add(new ProductModelLite(R.mipmap.d5, "Redmi 5", "Snapdragon 450", "$199"));
        productModelLiteList.add(new ProductModelLite(R.mipmap.d6, "Redmi 5", "Snapdragon 450", "$199"));
        productModelLiteList.add(new ProductModelLite(R.mipmap.d1, "Redmi 5", "Snapdragon 450", "$199"));
        productModelLiteList.add(new ProductModelLite(R.mipmap.d3, "Redmi 5", "Snapdragon 450", "$199"));
        productModelLiteList.add(new ProductModelLite(R.mipmap.d6, "Redmi 5", "Snapdragon 450", "$199"));
        productModelLiteList.add(new ProductModelLite(R.mipmap.d1, "Redmi 5", "Snapdragon 450", "$199"));
        productModelLiteList.add(new ProductModelLite(R.mipmap.d3, "Redmi 5", "Snapdragon 450", "$199"));



        // HomePage Content recyclerView
        homeContentRecyclerView = view.findViewById(R.id.home_fragment_content);
        LinearLayoutManager testM = new LinearLayoutManager(getContext());
        testM.setOrientation(LinearLayoutManager.VERTICAL);
        homeContentRecyclerView.setLayoutManager(testM);
        List<HomePageModel> homePageModels = new ArrayList<>();
        homePageModels.add(new HomePageModel(0, sliderList));
        homePageModels.add(new HomePageModel(1, R.mipmap.stripadd, "#000000"));
        homePageModels.add(new HomePageModel(2,  "Deals of the day", productModelLiteList));
        homePageModels.add(new HomePageModel(3, "Featured Product", productModelLiteList));

        HomePageAdapter homePageAdapter = new HomePageAdapter(homePageModels);
        homeContentRecyclerView.setAdapter(homePageAdapter);
        homePageAdapter.notifyDataSetChanged();
        return view;
    }

}
