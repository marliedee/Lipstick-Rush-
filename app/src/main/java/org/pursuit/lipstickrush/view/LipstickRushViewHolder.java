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


public class LipstickRushViewHolder extends RecyclerView.ViewHolder {
    private TextView brandName;
    private TextView productName;
    private TextView description;
    private Button moreDetails;

    public LipstickRushViewHolder(@NonNull View itemView) {
        super(itemView);
        moreDetails = itemView.findViewById(R.id.moreDetailsButton);
        brandName = itemView.findViewById(R.id.brandname);
        productName = itemView.findViewById(R.id.productname);
        description = itemView.findViewById(R.id.description);

    }

    public void onBind(final MakeupPOJO makeupPOJO) {
        setItems(makeupPOJO);
    }

    private void sendIntent(MakeupPOJO makeupPOJO) {
        Intent intentToDisplay = new Intent(itemView.getContext(), DisplayActivity.class);
        intentToDisplay.putExtra("brand", makeupPOJO.getBrand());
        intentToDisplay.putExtra("name", makeupPOJO.getName());
        intentToDisplay.putExtra("tags", makeupPOJO.getTag_list());
        intentToDisplay.putExtra("description", makeupPOJO.getDescription());
        intentToDisplay.putExtra("website", makeupPOJO.getWebsite_link());
        intentToDisplay.putExtra("image", makeupPOJO.getImage_link());
        itemView.getContext().startActivity(intentToDisplay);
    }

    private void setItems(final MakeupPOJO makeupPOJO) {
        moreDetails.setOnClickListener(v -> sendIntent(makeupPOJO));
        brandName.setText(makeupPOJO.getBrand());
        productName.setText(makeupPOJO.getName());
        description.setText(Html.fromHtml(makeupPOJO.getDescription()));

    }
}
