package com.prophet.ecommerce.adapter.product;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.prophet.ecommerce.R;
import com.prophet.ecommerce.model.product.ProductSpecificationModel;

import java.util.List;

public class ProductSpecificationAdapter extends RecyclerView.Adapter<ProductSpecificationAdapter.ViewHolder> {
    private List<ProductSpecificationModel> modelList;

    public ProductSpecificationAdapter(List<ProductSpecificationModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (modelList.get(position).getType()) {
            case 0:
                return ProductSpecificationModel.SPECIFICATION_TITLE;
            case 1:
                return ProductSpecificationModel.SPECIFICATION_BODY;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public ProductSpecificationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        switch (viewType) {

            case ProductSpecificationModel.SPECIFICATION_TITLE:
                TextView title = new TextView(viewGroup.getContext());
                title.setTypeface(null, Typeface.BOLD);
                title.setTextColor(Color.parseColor("#000000"));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                layoutParams.setMargins(setDP(16, viewGroup.getContext()), setDP(16, viewGroup.getContext()), setDP(16, viewGroup.getContext()), setDP(8, viewGroup.getContext()));
                title.setLayoutParams(layoutParams);
                return new ViewHolder(title);

            case ProductSpecificationModel.SPECIFICATION_BODY:
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_product_detail_specification_item, viewGroup, false);
                return new ViewHolder(view);
            default:
                return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull ProductSpecificationAdapter.ViewHolder viewHolder, int i) {
        switch (modelList.get(i).getType()) {
            case ProductSpecificationModel.SPECIFICATION_TITLE:
                viewHolder.setTitle(modelList.get(i).getHeader());
                break;
            case ProductSpecificationModel.SPECIFICATION_BODY:
                String name = modelList.get(i).getFeatureName();
                String value = modelList.get(i).getFeatureValue();
                viewHolder.setData(name, value);
                break;
            default:
                return;
        }
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView value;
        private TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        private void setTitle(String titleText) {
            title = (TextView) itemView;
            title.setText(titleText);
        }

        private void setData(String titleText, String valuetext) {
            name = itemView.findViewById(R.id.fragment_product_detail_specifiaction_item_title);
            value = itemView.findViewById(R.id.fragment_product_detail_specifiaction_item_value);
            name.setText(titleText);
            value.setText(valuetext);
        }
    }

    private int setDP(int dp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }
}
