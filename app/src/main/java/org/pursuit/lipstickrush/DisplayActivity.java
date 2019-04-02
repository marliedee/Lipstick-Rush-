package org.pursuit.lipstickrush;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Arrays;

public class DisplayActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView brand;
    private TextView name;
    private TextView vegan;
    private TextView descrip;
    private TextView urlLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();

        brand = findViewById(R.id.brand_display);
        name = findViewById(R.id.productname_display);
        vegan = findViewById(R.id.productname_type);
        descrip = findViewById(R.id.decrip_display);
        urlLink = findViewById(R.id.link_display);
        imageView = findViewById(R.id.image_display);

        String brandName = intent.getStringExtra("brand");
        String productName = intent.getStringExtra("name");
        String[] productType = intent.getStringArrayExtra("vegan");
        String descriptionText = intent.getStringExtra("description");
        String websiteLink = intent.getStringExtra("website");
        String arrayToString = Arrays.toString(productType).replace("]", "").substring(1);


        brand.setText(brandName);
        name.setText(productName);
        if (arrayToString.isEmpty()) {
            vegan.setText("");
        } else {
            vegan.setText(getString(R.string.vegan_tags) + arrayToString);
        }
        descrip.setText(Html.fromHtml(descriptionText));
        urlLink.setText(websiteLink);

        Picasso.get().load(intent.getStringExtra("image")).into(imageView);
    }
}
