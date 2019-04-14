package com.prophet.ecommerce.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.prophet.ecommerce.R;
import com.prophet.ecommerce.model.wishlist.WishListModel;

import java.util.List;

public class WishListAdapter extends RecyclerView.Adapter<WishListAdapter.ViewHolder> {

    private List<WishListModel> modelList;

    public WishListAdapter(List<WishListModel> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wishlist_item_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        int image = modelList.get(position).getImageResource();
        String title = modelList.get(position).getTitle();
        int coupon = modelList.get(position).getFreeCoupon();
        String rating = modelList.get(position).getRating();
        int totalRating = modelList.get(position).getTotalRating();
        String price = modelList.get(position).getProductPrice();
        String cutPrice = modelList.get(position).getCuttedPrice();
        String payment = modelList.get(position).getPaymentMethod();

        viewHolder.setData(image, title, coupon, rating, totalRating, price, cutPrice, payment);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView productImage;
        private TextView title;
        private ImageView couponIcon;
        private TextView couponText;
        private TextView rating;
        private TextView totalRating;
        private TextView price;
        private View divider;
        private TextView cuttedPrice;
        private TextView paymentMethod;
        private ImageButton delete;
        private LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.wishlist_item_layout_product_image);
            title = itemView.findViewById(R.id.wishlist_item_layout_product_title);
            couponIcon = itemView.findViewById(R.id.wishlist_item_layout_coupon_icon);
            couponText = itemView.findViewById(R.id.wishlist_item_layout_coupon_text);
            rating = itemView.findViewById(R.id.wishlist_item_layout_rating_miniView);
            totalRating = itemView.findViewById(R.id.wishlist_item_layout_product_total_rating);
            price = itemView.findViewById(R.id.wishlist_item_layout_product_price);
            cuttedPrice = itemView.findViewById(R.id.wishlist_item_layout_product_cutted_price);
            divider = itemView.findViewById(R.id.divider);
            paymentMethod = itemView.findViewById(R.id.wishlist_item_layout_payment_method);
            delete = itemView.findViewById(R.id.wishlist_item_layout_delete_button);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }

        private void setData(int image, String titleText, int freeCoupon, String ratingText, int totalRatingText, String priceText, String priceCut, String paymentInfo){
            productImage.setImageResource(image);
            title.setText(titleText);
            if (freeCoupon > 0){
                couponIcon.setVisibility(View.VISIBLE);
                if (freeCoupon == 1){
                    couponText.setText("free "+ freeCoupon + " coupon available");
                }else {
                    couponText.setText("free "+ freeCoupon + " coupons available");
                }
            }else {
                couponIcon.setVisibility(View.INVISIBLE);
                couponText.setVisibility(View.INVISIBLE);
            }
            rating.setText(ratingText);
            if (totalRatingText > 0){
                linearLayout.setVisibility(View.VISIBLE);
                if (totalRatingText == 1){
                    totalRating.setText("Rated by " + totalRatingText + " user");
                } else {
                    totalRating.setText("Rated by " + totalRatingText + " users");
                }
            }else {
                linearLayout.setVisibility(View.INVISIBLE);
                totalRating.setVisibility(View.INVISIBLE);
            }
            price.setText(priceText);
            if (priceCut != null){
                divider.setVisibility(View.VISIBLE);
                cuttedPrice.setText(priceCut);
            }else {
                divider.setVisibility(View.INVISIBLE);
                cuttedPrice.setVisibility(View.INVISIBLE);
            }
            paymentMethod.setText(paymentInfo);
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "Delete button", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
