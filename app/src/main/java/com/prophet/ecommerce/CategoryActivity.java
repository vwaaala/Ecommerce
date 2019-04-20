package com.prophet.ecommerce;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.prophet.ecommerce.adapter.homeFragment.HomePageAdapter;
import com.prophet.ecommerce.model.homeFragment.HomePageModel;
import com.prophet.ecommerce.model.homeFragment.ProductModelLite;
import com.prophet.ecommerce.model.homeFragment.Slider;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView categoryRecyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String title = getIntent().getStringExtra("CategoryName");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(title);

        categoryRecyclerview = findViewById(R.id.category_activity_recyclerVIew);



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

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        categoryRecyclerview.setLayoutManager(linearLayoutManager);
        List<HomePageModel> homePageModels = new ArrayList<>();
        homePageModels.add(new HomePageModel(0, sliderList));
        homePageModels.add(new HomePageModel(1, R.mipmap.d1, "#000000"));
        homePageModels.add(new HomePageModel(2,  "Deals of the day", productModelLiteList));
        homePageModels.add(new HomePageModel(3, "Featured Product", productModelLiteList));

        HomePageAdapter homePageAdapter = new HomePageAdapter(homePageModels);
        categoryRecyclerview.setAdapter(homePageAdapter);
        homePageAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            // todo: search
            return true;
        } else if ( id == android.R.id.home){
            // Backbutton on appbar
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
