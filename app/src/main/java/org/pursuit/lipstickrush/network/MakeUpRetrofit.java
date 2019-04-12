package org.pursuit.lipstickrush.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MakeUpRetrofit {

    private static Retrofit lipstickRetroInstance;

    public static Retrofit getInstance() {
        if (lipstickRetroInstance != null) {
            return lipstickRetroInstance;
        }
        lipstickRetroInstance = new Retrofit.Builder()
                .baseUrl("https://gist.githubusercontent.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return lipstickRetroInstance;
    }

    private MakeUpRetrofit() {
    }
}

