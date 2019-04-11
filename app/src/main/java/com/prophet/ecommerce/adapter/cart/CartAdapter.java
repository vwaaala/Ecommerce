package com.prophet.ecommerce.adapter.cart;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.prophet.ecommerce.R;
import com.prophet.ecommerce.model.cart.CartItemModel;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter {

    private List<CartItemModel> list;

    public CartAdapter(List<CartItemModel> list) {
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        switch (list.get(position).getType()) {
            case 0:
                return CartItemModel.CART_ITEM;
            case 1:
                return CartItemModel.TOTAL_AMOUNT;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        switch (viewType) {
            case CartItemModel.CART_ITEM:
                View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_item_layout, viewGroup, false);
                return new CartItemViewHolder(itemView);

            case CartItemModel.TOTAL_AMOUNT:
                View totalView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_total_amount_layout, viewGroup, false);
                return new CartTotalAmountViewHolder(totalView);

            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (list.get(i).getType()) {
            case CartItemModel.CART_ITEM:
                int resource = list.get(i).getProductImage();
                String title = list.get(i).getProductTitle();
                int freeCoupon = list.get(i).getFreeCoupon();
                String price = list.get(i).getProductPrice();
                String cuttedPrice = list.get(i).getCuttedPrice();
                int offereApplied = list.get(i).getOfferApplied();
                ((CartItemViewHolder) viewHolder).setItemDetail(resource, title, freeCoupon, price, cuttedPrice, offereApplied);
                break;
            case CartItemModel.TOTAL_AMOUNT:
                String totalItem = list.get(i).getTotalItems();
                String totalItemPrice = list.get(i).getTotalItemPrice();
                String deliveryPrice = list.get(i).getDeliveryCost();
                String totalAmount = list.get(i).getTotalAmount();
                String saved = list.get(i).getSavedAmount();
                ((CartTotalAmountViewHolder) viewHolder).setTotalItemDetail(totalItem, totalItemPrice, deliveryPrice, totalAmount, saved);
                break;
            default:
                return;
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class CartItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView productImage;
        private TextView productTitle;
        private ImageView couponIcon;
        private TextView freeCoupons;
        private TextView productPrice;
        private TextView cuttedPrice;
        private TextView offerApplied;
        private TextView couponApplied;
        private TextView productQuantity;

        public CartItemViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.cart_item_product_imageview);
            productTitle = itemView.findViewById(R.id.cart_item_product_title);
            freeCoupons = itemView.findViewById(R.id.cart_item_free_coupon_text);
            couponIcon = itemView.findViewById(R.id.cart_item_free_coupon_ic);
            productPrice = itemView.findViewById(R.id.cart_item_layout_item_price);
            cuttedPrice = itemView.findViewById(R.id.cart_item_layout_item_cutted_price);
            offerApplied = itemView.findViewById(R.id.cart_item_layout_offers_applied);
            couponApplied = itemView.findViewById(R.id.cart_item_layout_coupon_applied);
            productQuantity = itemView.findViewById(R.id.cart_item_layout_item_quantity);
        }

        private void setItemDetail(int imageResource, String title, int coupon, String price, String cutPrice, int offer) {
            productImage.setImageResource(imageResource);
            productTitle.setText(title);
            if (coupon > 0) {
                couponIcon.setVisibility(View.VISIBLE);
                freeCoupons.setVisibility(View.VISIBLE);
                if (coupon == 1) {
                    freeCoupons.setText("free " + coupon + "coupon");
                } else {
                    freeCoupons.setText("free " + coupon + "coupons");
                }
            } else {
                couponIcon.setVisibility(View.INVISIBLE);
                freeCoupons.setVisibility(View.INVISIBLE);
            }
        }
    }

    class CartTotalAmountViewHolder extends RecyclerView.ViewHolder {
        private TextView totalItem;
        private TextView totalItemPrice;
        private TextView deliveryCost;
        private TextView totalAmount;
        private TextView savedAmount;

        public CartTotalAmountViewHolder(@NonNull View itemView) {
            super(itemView);
            totalItem = itemView.findViewById(R.id.cart_total_amount_layout_total_items);
            totalItemPrice = itemView.findViewById(R.id.cart_total_amount_layout_total_item_price);
            deliveryCost = itemView.findViewById(R.id.cart_total_amount_layout_delivery_price);
            totalAmount = itemView.findViewById(R.id.cart_total_amount_layout_total_amount);
            savedAmount = itemView.findViewById(R.id.cart_total_amount_saved_amount);
        }

        private void setTotalItemDetail(String items, String price, String delivery, String total, String saved) {
            totalItem.setText(items);
            totalItemPrice.setText(price);
            deliveryCost.setText(delivery);
            totalAmount.setText(total);
            savedAmount.setText(saved);
        }

    }
}
