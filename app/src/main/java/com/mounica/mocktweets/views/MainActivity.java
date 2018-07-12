package com.mounica.mocktweets.views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.FileProvider;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.MenuItem;
import android.widget.TextView;
import com.mounica.mocktweets.adapters.ViewPagerAdapter;
import com.mounica.mocktweets.R;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;
import com.twitter.sdk.android.tweetcomposer.TweetComposer.Builder;
import java.io.File;

public class MainActivity extends AppCompatActivity {

  private static final int TAB_COUNT = 4;
  private static int[] TAB_ICONS_ARRAY = {
      R.drawable.ic_vector_home_stroke,
      R.drawable.ic_vector_search_stroke,
      R.drawable.ic_vector_notifications_stroke,
      R.drawable.ic_vector_messages_stroke
  };
  private static final String TAG = "MainActivity";
  private DrawerLayout mDrawerLayout;
  private ActionBarDrawerToggle mToggle;
  private TextView mFollowers, mFollowing;
  private ViewPager mViewPager;
  private FragmentStatePagerAdapter mFragmentPagerAdapter;
  private Toolbar mToolBar;
  private TwitterApiClient mTwitterApiClient;
  private TabLayout mTabLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mToolBar = findViewById(R.id.toolbar);
    mToolBar.setTitle(R.string.home);
    setSupportActionBar(mToolBar);

    //Navigation drawer
    drawNavigationView();

    mTwitterApiClient = TwitterCore.getInstance().getApiClient();

    //Tabs
    mTabLayout = findViewById(R.id.tabs);
    mViewPager = findViewById(R.id.viewpager);
    mFragmentPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), mTwitterApiClient,
        TAB_COUNT);
    mViewPager.setAdapter(mFragmentPagerAdapter);
    mTabLayout.setupWithViewPager(mViewPager);
    for (int count = 0; count < TAB_COUNT; count++) {
      mTabLayout.getTabAt(count).setIcon(TAB_ICONS_ARRAY[count]);
    }

    //ViewPager set tabs;
    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      //TODO to be implemented
      @Override
      public void onClick(View view) {
        composeTweet();
      }
    });
  }

  private void composeTweet() {

    TweetComposer.Builder composer = new Builder(MainActivity.this)
        .text(getResources().getString(R.string.compose_hint));
    composer.show();

  }

  private void drawNavigationView() {
    //Set Navigation Toggle
    mDrawerLayout = findViewById(R.id.drawer);
    mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar, R.string.drawer_open,
        R.string.drawer_close);
    mDrawerLayout.addDrawerListener(mToggle);
    mToggle.syncState();

    // Get the NavigationView's Header view
    View headerView = ((NavigationView) findViewById(R.id.nav_view)).getHeaderView(0);
    mFollowers = headerView.findViewById(R.id.text_followers);
    mFollowing = headerView.findViewById(R.id.text_following);

    mFollowers.setText(String.format(getResources().getString(R.string.followers_count), 20));
    mFollowing.setText(String.format(getResources().getString(R.string.following_count), 40));
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    //TODO implement on nav items selected
    return super.onOptionsItemSelected(item);
  }

}
