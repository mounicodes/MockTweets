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
import com.bumptech.glide.Glide;
import com.mounica.mocktweets.adapters.ViewPagerAdapter;
import com.mounica.mocktweets.R;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
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
  private TwitterApiClient mTwitterApiClient;
  private TabLayout mTabLayout;
  private TwitterSession mSession;
  private com.mounica.mocktweets.models.User mUser;
  private User mUser1;

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

    mTwitterApiClient = TwitterCore.getInstance().getApiClient();

    // Navigation drawer
    updateNavigationView();

    // Tabs
    mTabLayout = findViewById(R.id.tabs);
    mViewPager = findViewById(R.id.viewpager);
    mFragmentPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), mTwitterApiClient,
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
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        composeTweet();
      }
    });
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
    mTwitterApiClient.getAccountService().verifyCredentials(true, false, false).enqueue(
        new Callback<User>() {
          @Override
          public void success(Result<User> result) {
            Log.i(TAG, "success: " + "loading user details");
            mUser1 = result.data;
            mUserName.setText(mUser1.name);
            Glide.with(getBaseContext())
                .load(mUser1.profileImageUrl)
                .into(mUserDisplayImage);
            mScreenName.setText("@" + mUser1.screenName);
            mFollowers.setText(String
                .format(getResources().getString(R.string.followers_count), mUser1.followersCount));
            mFollowing.setText(String
                .format(getResources().getString(R.string.following_count), mUser1.friendsCount));
          }

          @Override
          public void failure(TwitterException exception) {
            Log.e(TAG, "failure: " + exception.getMessage());
          }
        });

    mNavigationView.setNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
          case R.id.profile:
            //TODO Replace with bundle and pass user object. Parcelable error since an object in User object doesn't implement serializable
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("name", mUser1.name);
            intent.putExtra("screen_name", mUser1.screenName);
            intent.putExtra("followers", mUser1.followersCount);
            intent.putExtra("following", mUser1.friendsCount);
            intent.putExtra("bg_image", mUser1.profileBackgroundImageUrlHttps);
            intent.putExtra("profile_image", mUser1.profileImageUrlHttps);
            startActivity(intent);
            break;
        }
        return true;
      }
    });
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    //TODO implement on nav items selected
    return super.onOptionsItemSelected(item);
  }
}