package com.coolbanter.leaderboard;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "https://gadsapi.herokuapp.com";
    private static final String BASE_URL_FORM = "https://docs.google.com/forms/d/e";
    private static Retrofit mRetrofit = null;

    public static Retrofit getRetrofit() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;

    }

    public static APIService getHourService() {
        return getRetrofit().create(APIService.class);

    }


    public static APIService getScoresService() {
        return getRetrofit().create(APIService.class);
    }



    public static APIService getFormService() {
        return getRetrofit().create(APIService.class);
    }


}


//    private static Retrofit getRetrofit() {
//        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
//        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
//
//        return new Retrofit.Builder()
//                .baseUrl("https://gadsapi.herokuapp.com")
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(okHttpClient)
//                .build();
//
//
//
//    }
//    public static APIService getApiService() {
//        return getRetrofit().create(APIService.class);
//    }

