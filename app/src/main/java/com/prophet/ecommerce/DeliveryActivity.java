package com.prophet.ecommerce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.prophet.ecommerce.adapter.cart.CartAdapter;
import com.prophet.ecommerce.model.cart.CartItemModel;

import java.util.ArrayList;
import java.util.List;

public class DeliveryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button editAddressButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Delivery");

        recyclerView = findViewById(R.id.activity_delivery_recyclerview);
        editAddressButton = findViewById(R.id.shipping_detail_layout_button);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        List<CartItemModel> cartItemModelList = new ArrayList<>();
        cartItemModelList.add(new CartItemModel(0, R.mipmap.d1, "Iphone X (64GB)", 2, "$ 1,099", "$ 1,199", 1, 0, 0));
        cartItemModelList.add(new CartItemModel(0, R.mipmap.d1, "Iphone X (64GB)", 0, "$ 1,099", "$ 1,199", 1, 1, 0));
        cartItemModelList.add(new CartItemModel(0, R.mipmap.d1, "Iphone X (64GB)", 2, "$ 1,099", "$ 1,199", 1, 0, 0));
        cartItemModelList.add(new CartItemModel(1, "Price (1 item)", "$ 1,099", "Free", "$ 1,099", "$ 1,199"));

        CartAdapter cartAdapter = new CartAdapter(cartItemModelList);
        recyclerView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();
        editAddressButton.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
