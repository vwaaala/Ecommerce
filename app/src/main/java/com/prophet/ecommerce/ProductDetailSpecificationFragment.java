package com.prophet.ecommerce;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prophet.ecommerce.adapter.product.ProductSpecificationAdapter;
import com.prophet.ecommerce.model.product.ProductSpecificationModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDetailSpecificationFragment extends Fragment {


    public ProductDetailSpecificationFragment() {
        // Required empty public constructor
    }

    private RecyclerView recyclerView;
    private List<ProductSpecificationModel> modelList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_detail_specification, container, false);
        recyclerView = view.findViewById(R.id.fragment_product_detail_specification_recyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        modelList = new ArrayList<>();
        modelList.add(new ProductSpecificationModel(0, "General"));
        modelList.add(new ProductSpecificationModel(1,"Ram", "4GB"));
        modelList.add(new ProductSpecificationModel(1,"Ram", "4GB"));
        modelList.add(new ProductSpecificationModel(1,"Ram", "4GB"));

        ProductSpecificationAdapter specificationAdapter = new ProductSpecificationAdapter(modelList);
        recyclerView.setAdapter(specificationAdapter);
        specificationAdapter.notifyDataSetChanged();
        return view;
    }

}
