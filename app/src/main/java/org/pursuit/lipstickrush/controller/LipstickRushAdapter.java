package org.pursuit.lipstickrush.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.pursuit.lipstickrush.R;
import org.pursuit.lipstickrush.model.MakeupPOJO;
import org.pursuit.lipstickrush.view.LipstickRushViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LipstickRushAdapter extends RecyclerView.Adapter<LipstickRushViewHolder> {
    private List<MakeupPOJO> makeupPOJOList;

    public LipstickRushAdapter(List<MakeupPOJO> makeupPOJOList) {
        this.makeupPOJOList = makeupPOJOList;
    }

    @NonNull
    @Override
    public LipstickRushViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.makeup_list_view, parent, false);
        return new LipstickRushViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull LipstickRushViewHolder lipstickRushViewHolder, int position) {
        lipstickRushViewHolder.onBind(makeupPOJOList.get(position));

    }

    @Override
    public int getItemCount() {
        return makeupPOJOList.size();
    }


    public void setData(final List<MakeupPOJO> newNameList) {
        this.makeupPOJOList = newNameList;
        notifyDataSetChanged();
    }
}



