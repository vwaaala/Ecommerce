package com.prophet.ecommerce.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prophet.ecommerce.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDetailDescriptionFragment extends Fragment {


    public ProductDetailDescriptionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_detail_description, container, false);
    }

}
