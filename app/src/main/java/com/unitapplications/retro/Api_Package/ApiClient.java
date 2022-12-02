package com.unitapplications.retro.Api_Package;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
  private static final  String url="http://192.168.0.7/meme_api/";
    private static ApiClient apiClient;
    private static Retrofit retrofit=null;

    public static Retrofit getClient(){
        if (retrofit==null) {
            OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();
            Gson gson = new GsonBuilder().create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson)).build();
        }
        return retrofit;
    }


/*    ApiClient(){
        retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }*/
//    public static synchronized ApiClient getInstance(){
//
//        if (apiClient==null)
//            apiClient = new ApiClient();
//        return apiClient;
//        }
//        public ApiSet getApi(){
//        return retrofit.create(ApiSet.class);
//    }

}