package org.pursuit.lipstickrush;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.lipstickrush.fragments.WebViewFragment;

import java.util.Arrays;

public class DisplayActivity extends AppCompatActivity{
    private ImageView imageView;
    private TextView brand;
    private TextView name;
    private TextView tagLists;
    private TextView descripText;
    private TextView urlLink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        brand = findViewById(R.id.brand_display);
        name = findViewById(R.id.productname_display);
        tagLists = findViewById(R.id.productname_type);
        descripText = findViewById(R.id.decrip_display);
        imageView = findViewById(R.id.image_display);
        urlLink = findViewById(R.id.link_display);

        Intent intent = getIntent();

        String brandName = intent.getStringExtra("brand");
        String productName = intent.getStringExtra("name");
        String[] productType = intent.getStringArrayExtra("tags");
        String descriptionText = intent.getStringExtra("description");
        String websiteLink = intent.getStringExtra("website");
        String arrayToString = Arrays.toString(productType).replace("]", "").substring(1);


        brand.setText(brandName);
        name.setText(productName);
        if (arrayToString.isEmpty()) {
            tagLists.setText("");
        } else {
            tagLists.setText(getString(R.string.tagLists) + arrayToString);
        }
        descripText.setText(Html.fromHtml(descriptionText));
        urlLink.setText(websiteLink);
        urlLink.setOnClickListener(v -> {
            WebViewFragment webViewFragment = WebViewFragment.getInstance(websiteLink);
            getSupportFragmentManager().beginTransaction().replace(R.id.test_name, webViewFragment).addToBackStack(null).commit();
        });
        Picasso.get().load(intent.getStringExtra("image")).into(imageView);

    }
}
