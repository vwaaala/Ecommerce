package com.prophet.ecommerce.adapter;

import android.content.res.ColorStateList;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.prophet.ecommerce.R;
import com.prophet.ecommerce.model.order.OrderItem;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private List<OrderItem> orderItemList;

    public OrderAdapter(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.order_item_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        int image = orderItemList.get(i).getProductImage();
        String title = orderItemList.get(i).getProductTitle();
        String status = orderItemList.get(i).getDeliveryStatus();
        int rating = orderItemList.get(i).getRating();
        viewHolder.setData(title, image, status, rating);
    }

    @Override
    public int getItemCount() {
        return orderItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView deliveryStatus;
        private ImageView image;
        private ImageView indicator;
        private LinearLayout ratingContainer;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.order_item_layout_title);
            deliveryStatus = itemView.findViewById(R.id.order_item_layout_delivery_status);
            image = itemView.findViewById(R.id.order_item_layout_image);
            indicator = itemView.findViewById(R.id.order_item_layout_indicator);
            ratingContainer = itemView.findViewById(R.id.order_item_layout__star_container);
        }
        private void setData(String titleText, int productImage, String status, int rating){
            title.setText(titleText);
            if (status.equals("Cancelled")){
                indicator.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.buttonRed)));

            } else {
                indicator.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.colorPrimary)));
            }
            deliveryStatus.setText(status);
            image.setImageResource(productImage);

            setRating(rating);
            for (int i = 0; i < ratingContainer.getChildCount(); i++){
                final int starPosition = i;
                ratingContainer.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setRating(starPosition);
                    }
                });
            }
        }

        private void setRating(int starPosition){
            for (int i = 0; i < ratingContainer.getChildCount(); i++){
                ImageView star = (ImageView) ratingContainer.getChildAt(i);
                star.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.colorAccent)));
                if (i <= starPosition){
                    star.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.colorPrimary)));
                }
            }
        }
    }
}
