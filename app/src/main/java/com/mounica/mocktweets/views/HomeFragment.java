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
import com.mounica.mocktweets.utils.Constants;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.StatusesService;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Implementation of the Fragment for Home tab_selector.xml. This basically retrieves the Home
 * Timeline/User Timeline of the user from the Twitter Api Client. Max number of tweets are set to
 * 198. Twitter allows a max of 200 tweets per call.
 */
public class HomeFragment extends Fragment {

  private static final String TAG = "HomeFragment";
  private static final String CALLER_HOME = "home";
  private static final String CALLER_PROFILE = "profile";
  private static final int TWEET_COUNT = 198;
  private List<Tweet> mTimeline;
  private HomeAdapter mHomeAdapter;
  private static String mCaller = null;
  private StatusesService mStatusService;

  public static HomeFragment newInstance(String caller, Bundle bundle) {
    HomeFragment fragment = new HomeFragment();
    mCaller = caller;
    Bundle infoBundle = new Bundle();
    infoBundle.putBundle("information", bundle);
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
    mTimeline = new ArrayList<>();
    mHomeAdapter = new HomeAdapter(mTimeline);
    recyclerView.setAdapter(mHomeAdapter);
    mStatusService = Constants.TWITTER_API_CLIENT.getStatusesService();

    // Differentiate the caller and display either user timeline or home timeline
    if (mCaller.equals(CALLER_PROFILE)) {
      makeUserTimelineCall(getArguments().getBundle("information"));
    } else if (mCaller.equals(CALLER_HOME)) {
      makeHomeTimelineCall();
    }
    return view;
  }

  private void makeHomeTimelineCall() {
    mStatusService.homeTimeline(TWEET_COUNT, null, null, null, null, null, null).enqueue(
        new Callback<List<Tweet>>() {
          @Override
          public void onResponse(Call<List<Tweet>> call, Response<List<Tweet>> response) {
            mTimeline.addAll(response.body());
            mHomeAdapter.notifyDataSetChanged();
          }

          @Override
          public void onFailure(Call<List<Tweet>> call, Throwable t) {
            Log.e(TAG, "onFailure: " + R.string.hometimeline_fail);
            Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
          }
        });
  }

  private void makeUserTimelineCall(Bundle bundle) {
    mStatusService
        .userTimeline(null, bundle.getString("screen_name"), 20, null, null, false, true, false,
            false).enqueue(new Callback<List<Tweet>>() {
      @Override
      public void onResponse(Call<List<Tweet>> call, Response<List<Tweet>> response) {
        mTimeline.addAll(response.body());
        mHomeAdapter.notifyDataSetChanged();
      }

      @Override
      public void onFailure(Call<List<Tweet>> call, Throwable t) {
        Log.e(TAG, "onFailure: " + R.string.usertimeline_fail);
        Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
      }
    });
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
  }
}
