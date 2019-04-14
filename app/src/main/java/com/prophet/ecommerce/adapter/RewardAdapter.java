package com.prophet.ecommerce.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.prophet.ecommerce.R;
import com.prophet.ecommerce.model.RewardModel;

import java.util.List;

public class RewardAdapter extends RecyclerView.Adapter<RewardAdapter.ViewHolder> {

    private List<RewardModel> modelList;

    public RewardAdapter(List<RewardModel> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.reward_item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String title = modelList.get(i).getTitle();
        String validity = modelList.get(i).getValidity();
        String body = modelList.get(i).getBody();
        viewHolder.setData(title, validity, body);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView validity;
        private TextView body;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.reward_item_layout_coupon_title);
            validity = itemView.findViewById(R.id.reward_item_layout_coupon_validity);
            body = itemView.findViewById(R.id.reward_item_layout_coupon_body);
        }

        private void setData(String titleText, String validityText, String bodyText){
            title.setText(titleText);
            validity.setText(validityText);
            body.setText(bodyText);
        }
    }
}
