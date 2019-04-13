package org.pursuit.lipstickrush;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.pursuit.lipstickrush.controller.LipstickRushAdapter;
import org.pursuit.lipstickrush.model.MakeupPOJO;
import org.pursuit.lipstickrush.network.MakeUpRetrofit;
import org.pursuit.lipstickrush.network.MakeUpService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class SecondActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private RecyclerView recyclerView;
    private LipstickRushAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private Retrofit retro;
    private String TAG = "SECOND_ACTIVITY";
    private SearchView searchView;
    private List<MakeupPOJO> makeupList = new ArrayList<>();
    private ProgressBar progressBar;
    private TextView noResultTextView;
    private Button button;

    @NonNull
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        noResultTextView = findViewById(R.id.tv_no_results);

        searchView = findViewById(R.id.searchViewTwo);
        searchView.setOnQueryTextListener(this);

        recyclerView = findViewById(R.id.lipstick_rush_RV);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        button = findViewById(R.id.moreDetailsButton);

        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(linearLayoutManager);
        progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);
    }

    @SuppressLint("CheckResult")
    @Override
    protected void onStart() {
        super.onStart();
        retro = MakeUpRetrofit.getInstance();
        MakeUpService service = retro.create(MakeUpService.class);
        Observable<List<MakeupPOJO>> makeupPOJOCall = service.getMakeUpDetails();
        makeupPOJOCall.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(makeupPOJOS -> {
                    makeupList.addAll(makeupPOJOS);
                    adapter = new LipstickRushAdapter(makeupList);
                    progressBar.setVisibility(View.INVISIBLE);
                    noResultTextView.setVisibility(View.VISIBLE);
                    recyclerView.setAdapter(adapter);
                }, throwable -> Log.d(TAG, "onResponse: " + throwable.getMessage()));

    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        List<MakeupPOJO> newList = new ArrayList<>();
        for (MakeupPOJO makeup : makeupList) {
            if (makeup.getBrand() == null) {
                continue;
            }
            if (makeup.getBrand().toLowerCase().startsWith(newText.toLowerCase()) ||
                    makeup.getName().toLowerCase().startsWith(newText.toLowerCase())) {
                newList.add(makeup);
            }

        }
        adapter.setData(newList);

        return false;
    }

    public static SecondActivity getInstance() {
        SecondActivity secondActivity = new SecondActivity();
        return secondActivity;
    }

}




