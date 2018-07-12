package com.mounica.mocktweets.views;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.mounica.mocktweets.R;
import com.mounica.mocktweets.adapters.TrendsAdapter;
import com.mounica.mocktweets.models.Trend;
import com.mounica.mocktweets.network.RetrofitApi;
import com.mounica.mocktweets.network.TwitterInterface;
import java.util.ArrayList;
import java.util.List;
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
    RetrofitApi.getClient().create(TwitterInterface.class).getTrends(1).enqueue(
        new Callback<List<Trend>>() {
          @Override
          public void onResponse(Call<List<Trend>> call, Response<List<Trend>> response) {
            if (response.isSuccessful()) {
              mTrendsList.addAll(response.body());
              mTrendsAdapter.notifyDataSetChanged();
            }
          }

          @Override
          public void onFailure(Call<List<Trend>> call, Throwable t) {
            Log.e(TAG, "onFailure: " + t.getMessage());
            Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
          }
        });

    return view;
  }
}
