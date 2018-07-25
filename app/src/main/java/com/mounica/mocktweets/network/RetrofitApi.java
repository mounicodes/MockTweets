package com.mounica.mocktweets.network;

import com.mounica.mocktweets.utils.Constants;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {

  private static String mToken = "bearer" + " "
      + Constants.TOKEN;

  public static Retrofit getClient() {
    OkHttpClient okHttpClient = new OkHttpClient
        .Builder()
        .addInterceptor(new Interceptor() {
          @Override
          public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            request = request.newBuilder()
                .addHeader("Authorization", mToken)
                .addHeader("Content-Type", "application/json")
                .build();
            return chain.proceed(request);
          }
        }).build();

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(Constants.BASE_URL_TWITTER)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    return retrofit;
  }
}
