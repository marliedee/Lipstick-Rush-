package org.pursuit.lipstickrush;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button goToProductsListButton;
    private final String LINKEDIN = "https://www.linkedin.com/in/marliedee";
    private final String GITHUB = "https://github.com/marliedee";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToProductsListButton = findViewById(R.id.go_to_list);

        goToProductsListButton.setOnClickListener(v -> {
            Intent intentToSecond = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intentToSecond);
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.linkedIn:
                Intent linkedIn = new Intent(Intent.ACTION_VIEW, Uri.parse(LINKEDIN));
                startActivity(linkedIn);
                return true;
            case R.id.github:
                Intent github = new Intent(Intent.ACTION_VIEW, Uri.parse(GITHUB));
                startActivity(github);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
