package com.prophet.ecommerce.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prophet.ecommerce.R;
import com.prophet.ecommerce.adapter.WishListAdapter;
import com.prophet.ecommerce.model.wishlist.WishListModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class WishListFragment extends Fragment {


    public WishListFragment() {
        // Required empty public constructor
    }
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wish_list, container, false);
        recyclerView = view.findViewById(R.id.wishlist_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        List<WishListModel> wishListModelList = new ArrayList<>();
        wishListModelList.add(new WishListModel(R.mipmap.d1, "OnePlus 6T (64GB)", 1, "4.7", 9, "$ 599", null, "Cash on delivery available" ));
        wishListModelList.add(new WishListModel(R.mipmap.d2, "OnePlus 6T (64GB)", 0, "4.7", 9, "$ 599", "$ 699", "Cash on delivery available" ));
        wishListModelList.add(new WishListModel(R.mipmap.d3, "OnePlus 6T (64GB)", 1, "4.7", 9, "$ 599", null, "Cash on delivery available" ));
        wishListModelList.add(new WishListModel(R.mipmap.d4, "OnePlus 6T (64GB)", 1, "4.7", 9, "$ 599", "$ 699", "Cash on delivery available" ));
        wishListModelList.add(new WishListModel(R.mipmap.d5, "OnePlus 6T (64GB)", 0, "4.7", 9, "$ 599", null, "Cash on delivery available" ));

        WishListAdapter adapter = new WishListAdapter(wishListModelList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return view;
    }

}
