package com.mounica.mocktweets.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.mounica.mocktweets.R;
import com.mounica.mocktweets.utils.Constants;
import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.tweetui.TweetTimelineRecyclerViewAdapter;

public class SearchActivity extends AppCompatActivity {

  private String mQuery;
  private static final int MAX_ITEMS_PER_REQUEST = 50;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search);
    mQuery = getIntent().getStringExtra(Constants.INTENT_QUERY);
    RecyclerView recyclerView = findViewById(R.id.rv_searchtimeline);
    recyclerView
        .setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    final SearchTimeline searchTimeline = new SearchTimeline.Builder()
        .query(mQuery)
        .maxItemsPerRequest(MAX_ITEMS_PER_REQUEST)
        .build();
    final TweetTimelineRecyclerViewAdapter adapter = new TweetTimelineRecyclerViewAdapter.Builder(
        this)
        .setTimeline(searchTimeline)
        .build();
    recyclerView.setAdapter(adapter);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater menuInflater = getMenuInflater();
    menuInflater.inflate(R.menu.menu_search, menu);
    MenuItem search = menu.findItem(R.id.action_search);
    SearchView searchView = (SearchView) search.getActionView();
    searchView.setIconifiedByDefault(false);
    searchView.setQuery(mQuery, false);
    searchView.setOnQueryTextListener(new OnQueryTextListener() {
      @Override
      public boolean onQueryTextSubmit(String query) {
        Intent intent = new Intent();
        intent.putExtra(Constants.INTENT_QUERY, query);
        startActivity(intent);
        return true;
      }

      @Override
      public boolean onQueryTextChange(String newText) {
        return false;
      }
    });
    return super.onCreateOptionsMenu(menu);
  }
}
