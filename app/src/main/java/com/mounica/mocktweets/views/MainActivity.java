package com.mounica.mocktweets.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.design.widget.TabLayout.Tab;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.mounica.mocktweets.adapters.ViewPagerAdapter;
import com.mounica.mocktweets.R;
import com.mounica.mocktweets.utils.Constants;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.User;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;
import com.twitter.sdk.android.tweetcomposer.TweetComposer.Builder;

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
  private NavigationView mNavigationView;
  private TextView mFollowers, mFollowing;
  private TextView mUserName;
  private TextView mScreenName;
  private ImageView mUserDisplayImage;
  private ViewPager mViewPager;
  private FragmentStatePagerAdapter mFragmentPagerAdapter;
  private Toolbar mToolBar;
  private TabLayout mTabLayout;
  private User mUser;

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mToolBar = findViewById(R.id.toolbar);
    mToolBar.setTitle(R.string.home);
    setSupportActionBar(mToolBar);

    // Navigation drawer
    updateNavigationView();

    // Tabs
    mTabLayout = findViewById(R.id.tabs);
    mViewPager = findViewById(R.id.viewpager);
    mFragmentPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),
        TAB_COUNT);
    mViewPager.setAdapter(mFragmentPagerAdapter);
    mTabLayout.setupWithViewPager(mViewPager);
    for (int count = 0; count < TAB_COUNT; count++) {
      mTabLayout.getTabAt(count).setIcon(TAB_ICONS_ARRAY[count]);
    }

    mTabLayout.addOnTabSelectedListener(new OnTabSelectedListener() {
      @Override
      public void onTabSelected(Tab tab) {
        switch (tab.getPosition()) {
          case 0:
            mToolBar.setTitle(R.string.home);
            break;
          case 2:
            mToolBar.setTitle(R.string.notifications);
            break;
          case 3:
            mToolBar.setTitle(R.string.messages);
            break;
        }
      }

      @Override
      public void onTabUnselected(Tab tab) {

      }

      @Override
      public void onTabReselected(Tab tab) {

      }
    });

    // ViewPager set tabs;
    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(view -> composeTweet());
  }

  private void composeTweet() {
    TweetComposer.Builder composer = new Builder(MainActivity.this);
    composer.show();
  }

  private void updateNavigationView() {

    // Set Navigation Toggle
    mNavigationView = findViewById(R.id.nav_view);
    mDrawerLayout = findViewById(R.id.drawer);
    mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar, R.string.drawer_open,
        R.string.drawer_close);
    mDrawerLayout.addDrawerListener(mToggle);
    mToggle.syncState();

    //  Get the NavigationView's Header view
    View headerView = ((NavigationView) findViewById(R.id.nav_view)).getHeaderView(0);
    mUserName = headerView.findViewById(R.id.text_username);
    mUserDisplayImage = headerView.findViewById(R.id.image_dp);
    mScreenName = headerView.findViewById(R.id.text_screenname);
    mFollowers = headerView.findViewById(R.id.text_followers);
    mFollowing = headerView.findViewById(R.id.text_following);

    // Populate User Details
    Constants.TWITTER_API_CLIENT.getAccountService().verifyCredentials(true, false, false).enqueue(
        new Callback<User>() {
          @Override
          public void success(Result<User> result) {
            mUser = result.data;
            mUserName.setText(mUser.name);
            Glide.with(getBaseContext())
                .load(mUser.profileImageUrlHttps.replaceFirst("_normal.", "."))
                .into(mUserDisplayImage);
            mScreenName.setText("@" + mUser.screenName);
            mFollowers.setText(String
                .format(getResources().getString(R.string.followers_count), mUser.followersCount));
            mFollowing.setText(String
                .format(getResources().getString(R.string.following_count), mUser.friendsCount));
          }

          @Override
          public void failure(TwitterException exception) {
            Log.e(TAG, "failure: " + exception.getMessage());
          }
        });

    mNavigationView.setNavigationItemSelectedListener(item -> {
      switch (item.getItemId()) {
        case R.id.profile:
//          Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
//          intent.putExtra(Constants.INTENT_USER, mUser.name);
//          intent.putExtra(Constants.INTENT_SCREEN_NAME, mUser.screenName);
//          intent.putExtra(Constants.INTENT_FOLLOWERS, mUser.followersCount);
//          intent.putExtra(Constants.INTENT_FOLLOWING, mUser.friendsCount);
//          intent.putExtra(Constants.INTENT_BG_IMAGE, mUser.profileBackgroundImageUrlHttps);
//          intent.putExtra(Constants.INTENT_PROFILE_IMG, mUser.profileImageUrlHttps);
//          startActivity(intent);
        case R.id.lists:
        case R.id.bookmarks:
        case R.id.moments:
        default:
          Toast.makeText(MainActivity.this, Constants.TO_BE_IMPLEMENTED, Toast.LENGTH_SHORT).show();
          break;
      }
      return true;
    });
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    return super.onOptionsItemSelected(item);
  }
}