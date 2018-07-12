package com.mounica.mocktweets.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.mounica.mocktweets.adapters.HomeAdapter;
import com.mounica.mocktweets.R;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.StatusesService;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Implementation of the Fragment for Home tab. This basically retrieves the Home Timeline of the
 * user from the Twitter Api Client. Max number of tweets are set to 198. Twitter allows a max of
 * 200 tweets per call.
 */
public class HomeFragment extends Fragment {

  private static final String TAG = "HomeFragment";
  private static TwitterApiClient mTwitterApiClient;
  private List<Tweet> mHomeTimeline;
  private HomeAdapter mHomeAdapter;

  public static HomeFragment newInstance(TwitterApiClient twitterApiClient) {
    mTwitterApiClient = twitterApiClient;
    HomeFragment fragment = new HomeFragment();
    return fragment;
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_home, null);
    RecyclerView recyclerView = view.findViewById(R.id.rv_timeline);
    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
        LinearLayoutManager.VERTICAL, false);
    recyclerView.setLayoutManager(layoutManager);
    DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
        recyclerView.getContext(), layoutManager.getOrientation());
    recyclerView.addItemDecoration(dividerItemDecoration);
    mHomeTimeline = new ArrayList<>();
    mHomeAdapter = new HomeAdapter(mHomeTimeline);
    recyclerView.setAdapter(mHomeAdapter);

    //Home Timeline
    StatusesService statusesService = mTwitterApiClient.getStatusesService();
    statusesService.homeTimeline(198, null, null, null, null, null, null).enqueue(
        new Callback<List<Tweet>>() {
          @Override
          public void onResponse(Call<List<Tweet>> call, Response<List<Tweet>> response) {
            mHomeTimeline.addAll(response.body());
            mHomeAdapter.notifyDataSetChanged();
          }

          @Override
          public void onFailure(Call<List<Tweet>> call, Throwable t) {
            Log.e(TAG, "onFailure: " + R.string.hometimeline_Fail);
            Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
          }
        });

    return view;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
  }
}
