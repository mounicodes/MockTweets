package com.mounica.mocktweets;

import android.os.AsyncTask;
import android.util.Log;
import com.mounica.mocktweets.utils.Constants;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AuthenticationTask extends AsyncTask<Void, Void, Void> {

  private static final String TAG = "AuthenticationTask";
  HttpURLConnection httpConnection = null;
  OutputStream outputStream = null;
  BufferedReader bufferedReader = null;
  StringBuilder response = new StringBuilder();
  AsyncTokenListener asyncTokenListener;

  @Override
  protected Void doInBackground(Void... voids) {
//    try {
//      URL url = new URL(Constants.BASE_URL_TWITTER + Constants.AUTHENTICATION_URL);
//      httpConnection = (HttpURLConnection) url.openConnection();
//      httpConnection.setRequestMethod("POST");
//      httpConnection.setDoOutput(true);
//      httpConnection.setDoInput(true);
//
//      String accessCredential = Constants.CONSUMER_KEY + ":"
//          + Constants.CONSUMER_SECRET;
//      String authorization = "Basic "
//          + Base64.encodeToString(accessCredential.getBytes(),
//          Base64.NO_WRAP);
//      String param = "grant_type=client_credentials";
//
//      httpConnection.addRequestProperty("Authorization", authorization);
//      httpConnection.setRequestProperty("Content-Type",
//          "application/x-www-form-urlencoded;charset=UTF-8");
//      httpConnection.connect();
//
//      outputStream = httpConnection.getOutputStream();
//      outputStream.write(param.getBytes());
//      outputStream.flush();
//      outputStream.close();
//      // int statusCode = httpConnection.getResponseCode();
//      // String reason =httpConnection.getResponseMessage();
//
//      bufferedReader = new BufferedReader(new InputStreamReader(
//          httpConnection.getInputStream()));
//      String line;
//      response = new StringBuilder();
//
//      while ((line = bufferedReader.readLine()) != null) {
//        response.append(line);
//      }
//
//      Log.d(TAG,
//          "POST response code: "
//              + String.valueOf(httpConnection.getResponseCode()));
//      Log.d(TAG, "JSON response: " + response.toString());
////      asyncTokenListener.getToken(response.toString());
//
//    } catch (Exception e) {
//      Log.e(TAG, "POST error: " + Log.getStackTraceString(e));
//
//    } finally {
//      if (httpConnection != null) {
//        httpConnection.disconnect();
//      }
//    }

    try {
      URL url = new URL(Constants.URL_TRENDING);
      httpConnection = (HttpURLConnection) url.openConnection();
      httpConnection.setRequestMethod("GET");

      String token = "bearer" + Constants.TOKEN
          + "";
      httpConnection.setRequestProperty("Authorization", token);

      httpConnection.setRequestProperty("Authorization", token);
      httpConnection.setRequestProperty("Content-Type",
          "application/json");
      httpConnection.connect();

      bufferedReader = new BufferedReader(new InputStreamReader(
          httpConnection.getInputStream()));

      String line = null;
      while ((line = bufferedReader.readLine()) != null) {
        response.append(line);
      }

      Log.d(TAG,
          "GET response code: "
              + String.valueOf(httpConnection
              .getResponseCode()));
      Log.d(TAG, "JSON response: " + response.toString());

    } catch (Exception e) {
      Log.e(TAG, "GET error: " + Log.getStackTraceString(e));

    } finally {
      if (httpConnection != null) {
        httpConnection.disconnect();

      }
    }
    return null;
  }


  public interface AsyncTokenListener {

    void getToken(String token);
  }
}
