package com.prophet.ecommerce.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.prophet.ecommerce.DeliveryActivity;
import com.prophet.ecommerce.R;
import com.prophet.ecommerce.adapter.cart.CartAdapter;
import com.prophet.ecommerce.model.cart.CartItemModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {


    public CartFragment() {
        // Required empty public constructor
    }
    private RecyclerView recyclerView;
    private Button continueButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("My Cart");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        recyclerView = view.findViewById(R.id.cart_fragment_recyclerview);
        continueButton = view.findViewById(R.id.fragment_cart_buy_now_button);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
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

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DeliveryActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
