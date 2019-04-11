package com.prophet.ecommerce;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.prophet.ecommerce.adapter.product.ProductDetailDescriptionAdapter;
import com.prophet.ecommerce.adapter.product.ProductDetailImageAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailActivity extends AppCompatActivity {

    private ViewPager imageViewPager;
    private TabLayout viewPagerIndicator;
    private FloatingActionButton wishlistButton;
    private static Boolean alreadyWishlist = false;


    ////////////
    // TabLayout
    private TabLayout productDescriptionTabLayout;
    private ViewPager productDescriptionViewPager;
    ///////////

    ///////////
    // Rating layout
    private LinearLayout rateNowContainer;
    ///////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Disable activity title on app bar
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageViewPager = findViewById(R.id.product_detail_image_viewpager);
        viewPagerIndicator = findViewById(R.id.product_detail_image_indicator);
        wishlistButton = findViewById(R.id.product_detail_image_btn_wishlist);

        ///////////
        // TabLayout
        productDescriptionTabLayout = findViewById(R.id.product_detail_description_tablayout);
        productDescriptionViewPager = findViewById(R.id.product_detail_description_viewpager);
        ///////////

        ///////////
        //Rating
        rateNowContainer = findViewById(R.id.product_rating_layout_star_container);
        for (int i = 0; i < rateNowContainer.getChildCount(); i++){
            final int starPosition = i;
            rateNowContainer.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setRating(starPosition);
                }
            });
        }

        ///////////
        final List<Integer> imagesList = new ArrayList<>();
        imagesList.add(R.mipmap.d1);
        imagesList.add(R.mipmap.d2);
        imagesList.add(R.mipmap.d3);
        imagesList.add(R.mipmap.d4);

        ProductDetailImageAdapter imageAdapter = new ProductDetailImageAdapter(imagesList);
        imageViewPager.setAdapter(imageAdapter);
        imageAdapter.notifyDataSetChanged();
        viewPagerIndicator.setupWithViewPager(imageViewPager, true);

        wishlistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (alreadyWishlist == true) {
                    alreadyWishlist = false;
                    wishlistButton.setSupportImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                } else{
                    alreadyWishlist = true;
                    wishlistButton.setSupportImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimary)));
                }
            }
        });

        productDescriptionViewPager.setAdapter(new ProductDetailDescriptionAdapter(getSupportFragmentManager(), productDescriptionTabLayout.getTabCount()));
        productDescriptionViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productDescriptionTabLayout));
        productDescriptionTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                productDescriptionViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.product_detail_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
            return true;
        } else if (id == R.id.action_search) {
            // todo: search
            return true;
        } else if (id == R.id.action_cart) {
            // todo: cart
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    ///////////
    //Rating
    private void setRating(int starPosition){
        for (int i = 0; i < rateNowContainer.getChildCount(); i++){
            ImageView star = (ImageView) rateNowContainer.getChildAt(i);
            star.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
            if (i <= starPosition){
                star.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimary)));
            }
        }
    }
    ///////////
}
