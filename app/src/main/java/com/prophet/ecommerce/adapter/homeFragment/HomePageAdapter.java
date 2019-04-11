package com.prophet.ecommerce.adapter.homeFragment;

import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.prophet.ecommerce.R;
import com.prophet.ecommerce.model.homeFragment.HomePageModel;
import com.prophet.ecommerce.model.homeFragment.ProductModelLite;
import com.prophet.ecommerce.model.homeFragment.Slider;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomePageAdapter extends RecyclerView.Adapter {

    private List<HomePageModel> homePageModelList;

    public HomePageAdapter(List<HomePageModel> homePageModelList) {
        this.homePageModelList = homePageModelList;
    }


    /**
     * This method invokes first before inflating layout
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        switch (homePageModelList.get(position).getType()) {

            case 0:
                return HomePageModel.STATIC_SLIDER;

            case 1:
                return HomePageModel.STATIC_STRIP_ADD;

            case 2:
                return HomePageModel.STATIC_DEALS;

            case 3:
                return HomePageModel.STATIC_GRID;

            default:
                return -1;
        }
    }

    /**
     * From getItemViewType(int position)
     * get the each viewType position
     * and using switch statement
     * we can inflate all layouts
     *
     * @param viewGroup
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        switch (viewType) {
            // Cases for layouts to inflate

            case HomePageModel.STATIC_SLIDER:
                View sliderView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.homefragment_slider_viewpager_layout, viewGroup, false);
                return new SliderViewHolder(sliderView);

            case HomePageModel.STATIC_STRIP_ADD:
                View stripView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.homefragment_strip_layout, viewGroup, false);
                return new StripAdViewHolder(stripView);

            case HomePageModel.STATIC_DEALS:
                View dealsView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.homefragment_deals_layout, viewGroup, false);
                return new DealsViewHolder(dealsView);

            case HomePageModel.STATIC_GRID:
                View gridView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.homefragment_grid_product_layout, viewGroup, false);
                return new GridLayoutViewHolder(gridView);

            default:
                return null;
        }
    }

    /**
     * @param viewHolder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        switch (homePageModelList.get(position).getType()) {

            case HomePageModel.STATIC_SLIDER:
                List<Slider> sliders = homePageModelList.get(position).getSliderList();
                // Calling SliderViewHolder
                // casting viewHolder parameter
                ((SliderViewHolder) viewHolder).setSliderViewPager(sliders);
                break;

            case HomePageModel.STATIC_STRIP_ADD:
                int imageId = homePageModelList.get(position).getImageId();
                String color = homePageModelList.get(position).getColor();
                ((StripAdViewHolder) viewHolder).setStripImage(imageId, color);
                break;

            case HomePageModel.STATIC_DEALS:
                String title = homePageModelList.get(position).getTitle();
                List<ProductModelLite> productModelLiteList = homePageModelList.get(position).getDealsList();
                ((DealsViewHolder) viewHolder).setDealsView(productModelLiteList, title);
                break;

            case HomePageModel.STATIC_GRID:
                String gridTitle = homePageModelList.get(position).getTitle();
                List<ProductModelLite> gridList = homePageModelList.get(position).getDealsList();
                ((GridLayoutViewHolder) viewHolder).setGridView(gridList, gridTitle);
                break;
            default:
                return;
        }
    }

    @Override
    public int getItemCount() {
        return homePageModelList.size();
    }

    /**
     * StripAdvertise viewHolder
     */
    public class StripAdViewHolder extends RecyclerView.ViewHolder {
        private ImageView stripImage;
        private ConstraintLayout stripContainer;

        public StripAdViewHolder(@NonNull View itemView) {
            super(itemView);

            stripImage = itemView.findViewById(R.id.strip_ad_imageView);
            stripContainer = itemView.findViewById(R.id.strip_ad_container);
        }

        private void setStripImage(int imageId, String color) {
            stripImage.setImageResource(imageId);
            stripContainer.setBackgroundColor(Color.parseColor(color));
        }
    }


    /**
     * Slider viewHolder
     */
    public class SliderViewHolder extends RecyclerView.ViewHolder {
        private ViewPager sliderViewPager;
        private int dummyInt = 2;
        private Timer timer;
        final private long DELAY_TIME = 2000;
        final private long PERIOD_TIME = 2000;

        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            sliderViewPager = itemView.findViewById(R.id.banner_slider_viewpager);
        }

        private void setSliderViewPager(final List<Slider> sliderList) {
            SliderAdapter sliderAdapter = new SliderAdapter(sliderList);
            sliderViewPager.setAdapter(sliderAdapter);
            sliderViewPager.setClipToPadding(false);
            sliderViewPager.setPageMargin(20);
            sliderViewPager.setCurrentItem(dummyInt);
            sliderAdapter.notifyDataSetChanged();
            //// page listener
            ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int i, float v, int i1) {

                }

                @Override
                public void onPageSelected(int i) {
                    dummyInt = i;
                }

                @Override
                public void onPageScrollStateChanged(int i) {
                    if (i == ViewPager.SCROLL_STATE_IDLE) {
                        pagerLooper(sliderList);
                    }
                }
            };
            sliderViewPager.addOnPageChangeListener(onPageChangeListener);

            startSlideShow(sliderList);

            // touch listener
            sliderViewPager.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    pagerLooper(sliderList);
                    stopSliderShow();
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        startSlideShow(sliderList);
                    }
                    return false;
                }

            });
        }

        private void pagerLooper(List<Slider> sliderList) {
            if (dummyInt == sliderList.size() - 2) {
                dummyInt = 2;
                sliderViewPager.setCurrentItem(dummyInt, false);
            }

            if (dummyInt == 1) {
                dummyInt = sliderList.size() - 3;
                sliderViewPager.setCurrentItem(dummyInt, false);
            }


        }

        private void startSlideShow(final List<Slider> sliderList) {
            final Handler handler = new Handler();
            final Runnable update = new Runnable() {
                @Override
                public void run() {
                    if (dummyInt >= sliderList.size()) {
                        dummyInt = 1;
                    }
                    sliderViewPager.setCurrentItem(dummyInt++, true);
                }
            };
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(update);
                }
            }, DELAY_TIME, PERIOD_TIME);
        }

        private void stopSliderShow() {
            timer.cancel();
        }
    }


    /**
     * Deals viewHolder
     */
    public class DealsViewHolder extends RecyclerView.ViewHolder {
        private TextView dealsLayoutTile;
        private Button dealsViewAllButton;
        private RecyclerView dealsRecyclerView;

        public DealsViewHolder(@NonNull View itemView) {
            super(itemView);

            dealsLayoutTile = itemView.findViewById(R.id.deals_layout_title);
            dealsViewAllButton = itemView.findViewById(R.id.deals_layout_button);
            dealsRecyclerView = itemView.findViewById(R.id.deals_layout_recyclerView);
        }

        private void setDealsView(List<ProductModelLite> productModelLites, String title) {
            dealsLayoutTile.setText(title);
            if (productModelLites.size() > 8) {
                dealsViewAllButton.setVisibility(View.VISIBLE);
            } else {
                dealsViewAllButton.setVisibility(View.INVISIBLE);
            }
            DealsAdapter dealsAdapter = new DealsAdapter(productModelLites);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            dealsRecyclerView.setLayoutManager(linearLayoutManager);
            dealsRecyclerView.setAdapter(dealsAdapter);
            dealsAdapter.notifyDataSetChanged();
        }
    }

    /**
     * GridLayoutModel viewHolder
     */
    public class GridLayoutViewHolder extends RecyclerView.ViewHolder {
        private TextView gridLayoutTitle;
        private Button gridViewAllButton;
        private GridView gridLayoutGridView;

        public GridLayoutViewHolder(@NonNull View itemView) {
            super(itemView);

            gridLayoutTitle = itemView.findViewById(R.id.homefragment_grid_product_title);
            gridViewAllButton = itemView.findViewById(R.id.homefragment_grid_product_button);
            gridLayoutGridView = itemView.findViewById(R.id.homefragment_grid_product_gridview);
        }

        private void setGridView(List<ProductModelLite> list, String title) {
            gridLayoutTitle.setText(title);
            if (list.size() > 4) {
                gridViewAllButton.setVisibility(View.VISIBLE);
            } else {
                gridViewAllButton.setVisibility(View.INVISIBLE);
            }
            gridLayoutGridView.setAdapter(new GridProductAdapter(list));
        }
    }
}
