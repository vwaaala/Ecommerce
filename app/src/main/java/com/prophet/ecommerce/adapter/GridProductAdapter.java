package com.prophet.ecommerce.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.prophet.ecommerce.R;
import com.prophet.ecommerce.model.homeFragment.ProductModelLite;

import java.util.List;

public class GridProductAdapter extends BaseAdapter {

    List<ProductModelLite> productList;

    public GridProductAdapter(List<ProductModelLite> productList) {
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.homefragment_deals_item, parent, false);
            view.setElevation(0);
            view.setBackgroundColor(Color.parseColor("#ffffff"));
            ImageView imageView = view.findViewById(R.id.homefragment_deals_item_image);
            TextView title = view.findViewById(R.id.homefragment_deals_item_title);
            TextView description = view.findViewById(R.id.homefragment_deals_item_description);
            TextView price = view.findViewById(R.id.homefragment_deals_item_price);

            imageView.setImageResource(productList.get(position).getImage());
            title.setText(productList.get(position).getTitle());
            description.setText(productList.get(position).getDescription());
            price.setText(productList.get(position).getPrice());
        }else {
            view = convertView;
        }
        return view;
    }
}
