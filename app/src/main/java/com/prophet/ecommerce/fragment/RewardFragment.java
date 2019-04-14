package com.prophet.ecommerce.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prophet.ecommerce.R;
import com.prophet.ecommerce.adapter.RewardAdapter;
import com.prophet.ecommerce.model.RewardModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RewardFragment extends Fragment {


    public RewardFragment() {
        // Required empty public constructor
    }

    private RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rewards, container, false);
        recyclerView = view.findViewById(R.id.fragment_reward_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        List<RewardModel> rewardModel = new ArrayList<>();
        rewardModel.add(new RewardModel("Discount", "till, 4th Dec'19", "Get 5% off on any product above $50"));
        rewardModel.add(new RewardModel("Cash back", "till, 14th Jan'20", "Get 15% off on any product above $50 and below $5"));
        rewardModel.add(new RewardModel("Discount", "till, 4th Dec'19", "Buy 1 get 1 Free on above $50"));
        rewardModel.add(new RewardModel("Discount", "till, 4th Dec'19", "Get 5% off on any product above $50"));
        rewardModel.add(new RewardModel("Cash back", "till, 14th Jan'20", "Get 15% off on any product above $50 and below $5"));
        rewardModel.add(new RewardModel("Discount", "till, 4th Dec'19", "Buy 1 get 1 Free on above $50"));
        rewardModel.add(new RewardModel("Discount", "till, 4th Dec'19", "Get 5% off on any product above $50"));
        rewardModel.add(new RewardModel("Cash back", "till, 14th Jan'20", "Get 15% off on any product above $50 and below $5"));
        rewardModel.add(new RewardModel("Discount", "till, 4th Dec'19", "Buy 1 get 1 Free on above $50"));

        RewardAdapter adapter = new RewardAdapter(rewardModel);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return view;
    }

}
