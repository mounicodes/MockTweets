package com.mounica.mocktweets.views;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.mounica.mocktweets.R;
import com.mounica.mocktweets.adapters.TrendsAdapter;
import com.mounica.mocktweets.models.Trend;
import com.mounica.mocktweets.models.TrendsList;
import com.mounica.mocktweets.network.RetrofitApi;
import com.mounica.mocktweets.network.TwitterInterface;
import com.mounica.mocktweets.utils.Constants;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrendsFragment extends Fragment {

  private static final String TAG = "TrendsFragment";
  private static final String SEARCH_HINT = "Search Twitter";
  private List<Trend> mTrendsList = new ArrayList<>();
  private TrendsAdapter mTrendsAdapter;
  private int mTotalNoOfTrends = 20;

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
    Integer mWoeid = 1;
    View view = inflater.inflate(R.layout.fragment_trends, container, false);
    Toolbar toolbar = view.findViewById(R.id.toolbar_trends);
    if (mWoeid == 1) {
      toolbar.setTitle(getContext().getResources().getString(R.string.global));
    } else {
      toolbar.setTitle(getContext().getResources().getString(R.string.local));
    }
    mTrendsAdapter = new TrendsAdapter(mTrendsList);
    RecyclerView recyclerView = view.findViewById(R.id.rv_trends);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
        LinearLayoutManager.VERTICAL, false);
    recyclerView.addItemDecoration(
        new DividerItemDecoration(getContext(), linearLayoutManager.getOrientation()));
    recyclerView.setLayoutManager(linearLayoutManager);
    recyclerView.setAdapter(mTrendsAdapter);

    RetrofitApi.getClient()
        .create(TwitterInterface.class)
        .getTrends(mWoeid)
        .enqueue(new Callback<TrendsList[]>() {
          @Override
          public void onResponse(Call<TrendsList[]> call, Response<TrendsList[]> response) {
            for (int noOfTrends = 0; noOfTrends < mTotalNoOfTrends; noOfTrends++) {
              mTrendsList.add(response.body()[0].getTrends().get(noOfTrends));
            }
            mTrendsAdapter.notifyDataSetChanged();
          }

          @Override
          public void onFailure(Call<TrendsList[]> call, Throwable t) {
            Log.e(TAG, "onFailure: " + t.getMessage(), t);
          }
        });

    setHasOptionsMenu(true);
    return view;
  }

  @Override
  public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    inflater.inflate(R.menu.menu_search, menu);
    MenuItem item = menu.findItem(R.id.action_search);
    final SearchView searchView = (SearchView) item.getActionView();
    searchView.setIconifiedByDefault(false);
    searchView.setQueryHint(SEARCH_HINT);
    searchView.setOnQueryTextListener(new OnQueryTextListener() {

      @Override
      public boolean onQueryTextSubmit(String query) {
        Intent intent = new Intent(getContext(), SearchActivity.class);
        intent.putExtra(Constants.INTENT_QUERY, query);
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
}
