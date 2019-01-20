package com.crazyraccoonsteam.testproject.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.crazyraccoonsteam.testproject.R;

import java.util.ArrayList;
import java.util.List;

public class HomeRVAdapter extends RecyclerView.Adapter<HomeRVAdapter.HomeRVHolder> {

    private List<String> dummy;

    public HomeRVAdapter(List<String> dummy){
        this.dummy = dummy;
    }

    @NonNull
    @Override
    public HomeRVHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_rv_item, null, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);

        HomeRVHolder homeRVHolder;
        homeRVHolder = new HomeRVHolder(view);
        return homeRVHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRVHolder homeRVHolder, int i) {
        homeRVHolder.mName.setText(dummy.get(i));
    }

    @Override
    public int getItemCount() {
        return dummy.size();
    }

    class HomeRVHolder extends RecyclerView.ViewHolder{

        TextView mName;

        public HomeRVHolder(@NonNull View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.homeRVItemName);
        }
    }
}
