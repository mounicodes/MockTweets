package com.mounica.mocktweets.views;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.mounica.mocktweets.AuthenticationTask;
import com.mounica.mocktweets.R;
import com.mounica.mocktweets.adapters.TrendsAdapter;
import com.mounica.mocktweets.models.Trend;
import com.mounica.mocktweets.models.TrendsList;
import com.mounica.mocktweets.network.RetrofitApi;
import com.mounica.mocktweets.network.TwitterInterface;
import com.mounica.mocktweets.utils.Constants;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrendsFragment extends Fragment {

  private static final String TAG = "TrendsFragment";
  private List<Trend> mTrendsList = new ArrayList<>();
  private TrendsAdapter mTrendsAdapter;

  public static TrendsFragment newInstance() {
    TrendsFragment fragment = new TrendsFragment();
    return fragment;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_trends, container, false);
    mTrendsAdapter = new TrendsAdapter(mTrendsList);
    RecyclerView recyclerView = view.findViewById(R.id.rv_trends);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
        LinearLayoutManager.VERTICAL, false);
    recyclerView.setLayoutManager(linearLayoutManager);
    recyclerView.setAdapter(mTrendsAdapter);
    //check authentication
    new AuthenticationTask().execute();

//    getTimelineForSearchTerm(getContext());
//    RetrofitApi.getClient()
//        .create(TwitterInterface.class)
//        .getTrends(Constants.ACCESS_TOKEN, 1).enqueue(
//        new Callback<List<Trend>>() {
//          @Override
//          public void onResponse(Call<List<Trend>> call, Response<List<Trend>> response) {
//            Log.i(TAG, "onResponse: ");
//            if (response.isSuccessful()) {
//              mTrendsList.addAll(response.body());
//              mTrendsAdapter.notifyDataSetChanged();
//            }
//          }
//
//          @Override
//          public void onFailure(Call<List<Trend>> call, Throwable t) {
//            Log.e(TAG, "onFailure: " + t.getMessage());
//            Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
//          }
//        });
    //
//    RetrofitApi.getClient()
//        .create(TwitterInterface.class)
//        .getTrends(1)
//        .enqueue(new Callback<TrendsList>() {
//          @Override
//          public void onResponse(Call<TrendsList> call, Response<TrendsList> response) {
//            mTrendsAdapter.notifyDataSetChanged();
//            Log.i(TAG, "onResponse: " + response.body());
//          }
//
//          @Override
//          public void onFailure(Call<TrendsList> call, Throwable t) {
//            Log.e(TAG, "onFailure: " + t.getMessage(), t);
//          }
//        });

    //

    setHasOptionsMenu(true);
    return view;
  }

  @Override
  public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    inflater.inflate(R.menu.menu_search, menu);
    MenuItem item = menu.findItem(R.id.action_search);
    final SearchView searchView = (SearchView) item.getActionView();
    searchView.setIconifiedByDefault(false);
    searchView.setQueryHint("Search Twitter");
    searchView.setOnQueryTextListener(new OnQueryTextListener() {
      @Override
      public boolean onQueryTextSubmit(String query) {
        Intent intent = new Intent(getContext(), SearchActivity.class);
        intent.putExtra("query", query);
        startActivity(intent);
        return true;
      }

      @Override
      public boolean onQueryTextChange(String newText) {
        return false;
      }
    });
    super.onCreateOptionsMenu(menu, inflater);
  }

  private static String appAuthentication() {
    HttpURLConnection httpConnection = null;
    OutputStream outputStream = null;
    BufferedReader bufferedReader = null;
    StringBuilder response = null;

    try {
      URL url = new URL(Constants.AUTHENTICATION_URL);
      httpConnection = (HttpURLConnection) url.openConnection();
      httpConnection.setRequestMethod("POST");
      httpConnection.setDoOutput(true);
      httpConnection.setDoInput(true);

      String accessCredential = Constants.CONSUMER_KEY + ":"
          + Constants.CONSUMER_SECRET;
      String authorization = "Basic "
          + Base64.encodeToString(accessCredential.getBytes(),
          Base64.NO_WRAP);
      String param = "grant_type=client_credentials";

      httpConnection.addRequestProperty("Authorization", authorization);
      httpConnection.setRequestProperty("Content-Type",
          "application/x-www-form-urlencoded;charset=UTF-8");
      httpConnection.connect();

      outputStream = httpConnection.getOutputStream();
      outputStream.write(param.getBytes());
      outputStream.flush();
      outputStream.close();
      // int statusCode = httpConnection.getResponseCode();
      // String reason =httpConnection.getResponseMessage();

      bufferedReader = new BufferedReader(new InputStreamReader(
          httpConnection.getInputStream()));
      String line;
      response = new StringBuilder();

      while ((line = bufferedReader.readLine()) != null) {
        response.append(line);
      }

      Log.d(TAG,
          "POST response code: "
              + String.valueOf(httpConnection.getResponseCode()));
      Log.d(TAG, "JSON response: " + response.toString());

    } catch (Exception e) {
      Log.e(TAG, "POST error: " + Log.getStackTraceString(e));

    } finally {
      if (httpConnection != null) {
        httpConnection.disconnect();
      }
    }
    return response.toString();
  }

  public static String getTimelineForSearchTerm(Context context) {
    HttpURLConnection httpConnection = null;
    BufferedReader bufferedReader = null;
    StringBuilder response = new StringBuilder();

    try {
      URL url = new URL(Constants.URL_TRENDING);
      httpConnection = (HttpURLConnection) url.openConnection();
      httpConnection.setRequestMethod("GET");

      String jsonString = appAuthentication();
      JSONObject jsonObjectDocument = new JSONObject(jsonString);
      String token = jsonObjectDocument.getString("token_type") + " "
          + jsonObjectDocument.getString("access_token");
      httpConnection.setRequestProperty("Authorization", token);

      httpConnection.setRequestProperty("Authorization", token);
      httpConnection.setRequestProperty("Content-Type",
          "application/json");
      httpConnection.connect();

      bufferedReader = new BufferedReader(new InputStreamReader(
          httpConnection.getInputStream()));

      String line;
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
    return response.toString();
  }


}
