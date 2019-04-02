package org.pursuit.lipstickrush.network;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MakeUpRetrofit {

    private static Retrofit lipstickRetroInstance;

//    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder()
//            .connectTimeout(10, TimeUnit.SECONDS)
//            .writeTimeout(10, TimeUnit.SECONDS)
//            .readTimeout(20, TimeUnit.SECONDS)
//            .build();

    public static Retrofit getInstance() {
        if (lipstickRetroInstance != null) {
            return lipstickRetroInstance;
        }
        lipstickRetroInstance = new Retrofit.Builder()
                .baseUrl("https://gist.githubusercontent.com")
//                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return lipstickRetroInstance;
    }

    private MakeUpRetrofit() {
    }
}

