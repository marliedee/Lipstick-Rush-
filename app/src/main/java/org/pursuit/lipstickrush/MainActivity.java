package org.pursuit.lipstickrush;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button goToProductsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToProductsButton = findViewById(R.id.go_to_list);

        goToProductsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSecond = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intentSecond);

            }
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
                Intent linkedIn = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/marliedee/"));
                startActivity(linkedIn);
                return true;
            case R.id.github:
                Intent github = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/marliedee"));
                startActivity(github);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
