package org.pursuit.lipstickrush.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.pursuit.lipstickrush.DisplayActivity;
import org.pursuit.lipstickrush.R;
import org.pursuit.lipstickrush.model.MakeupPOJO;

import java.util.List;

public class LipstickRushViewHolder extends RecyclerView.ViewHolder {
    private TextView textViewRV;
    private TextView textViewRV2;
    private TextView textViewRV4;
    private Button button;
    private List<MakeupPOJO> makeupPOJOList;

    public LipstickRushViewHolder(@NonNull View itemView) {
        super(itemView);
        button = itemView.findViewById(R.id.RV_button);
        textViewRV = itemView.findViewById(R.id.brandname);
        textViewRV2 = itemView.findViewById(R.id.productname);
        textViewRV4 = itemView.findViewById(R.id.description);

    }

    public void onBind(final MakeupPOJO makeupPOJO) {
        setItems(makeupPOJO);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAdapterPosition();
                sendIntent(makeupPOJO);
            }
        });
    }

    private void sendIntent(MakeupPOJO makeupPOJO) {
        Intent intentToSecond = new Intent(itemView.getContext(), DisplayActivity.class);
        intentToSecond.putExtra("brand", makeupPOJO.getBrand());
        intentToSecond.putExtra("name", makeupPOJO.getName());
        intentToSecond.putExtra("vegan", makeupPOJO.getTag_list());
        intentToSecond.putExtra("description", makeupPOJO.getDescription());
        intentToSecond.putExtra("website", makeupPOJO.getWebsite_link());
        intentToSecond.putExtra("image", makeupPOJO.getImage_link());
        itemView.getContext().startActivity(intentToSecond);
    }

    private void setItems(final MakeupPOJO makeupPOJO) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIntent(makeupPOJO);
            }
        });
        textViewRV.setText(makeupPOJO.getBrand());
        textViewRV2.setText(makeupPOJO.getName());
        textViewRV4.setText(makeupPOJO.getDescription());
        textViewRV4.setText(Html.fromHtml(makeupPOJO.getDescription()));

    }
}
