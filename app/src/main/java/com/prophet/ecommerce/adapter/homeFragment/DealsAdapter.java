package com.prophet.ecommerce.adapter.homeFragment;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.prophet.ecommerce.ProductDetailActivity;
import com.prophet.ecommerce.R;
import com.prophet.ecommerce.model.homeFragment.ProductModelLite;

import java.util.List;

public class DealsAdapter extends RecyclerView.Adapter<DealsAdapter.ViewHolder> {

    private List<ProductModelLite> deals;

    public DealsAdapter(List<ProductModelLite> deals) {
        this.deals = deals;
    }

    @NonNull
    @Override
    public DealsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.homefragment_deals_item, viewGroup, false);
        return new ViewHolder(view);
    }

    /**
     * Extracting list and binding to view holder
     * @param viewHolder
     * @param position
     */

    @Override
    public void onBindViewHolder(@NonNull DealsAdapter.ViewHolder viewHolder, int position) {
        int image = deals.get(position).getImage();
        String title = deals.get(position).getTitle();
        String description = deals.get(position).getDescription();
        String price = deals.get(position).getPrice();

        // Setting view in viewholder
        viewHolder.setImageView(image);
        viewHolder.setTitleView(title);
        viewHolder.setDescriptionView(description);
        viewHolder.setPriceView(price);
    }

    @Override
    public int getItemCount() {
        if (deals.size() > 8){
            return 8;
        } else {
            return deals.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView tileView;
        private TextView descriptionView;
        private TextView priceView;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.homefragment_deals_item_image);
            tileView = itemView.findViewById(R.id.homefragment_deals_item_title);
            descriptionView = itemView.findViewById(R.id.homefragment_deals_item_description);
            priceView = itemView.findViewById(R.id.homefragment_deals_item_price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), ProductDetailActivity.class);
                    itemView.getContext().startActivity(intent);
                }
            });
        }

        private void setImageView(int resource){
            imageView.setImageResource(resource);
        }

        private void setTitleView(String title){
            tileView.setText(title);
        }

        private void setDescriptionView(String description){
            descriptionView.setText(description);
        }

        private void setPriceView(String price){
            priceView.setText(price);
        }
    }
}
