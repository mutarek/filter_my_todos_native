package com.example.filtermytodos.apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static String base_url = "https://jsonplaceholder.typicode.com/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofitClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
