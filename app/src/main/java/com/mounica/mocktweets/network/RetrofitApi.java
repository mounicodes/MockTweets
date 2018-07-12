package com.mounica.mocktweets.network;

import com.mounica.mocktweets.utils.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {

  public static Retrofit getClient() {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(Constants.BASE_URL_TWITTER)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    return retrofit;
  }
}
