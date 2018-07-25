package com.mounica.mocktweets.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.mounica.mocktweets.R;
import com.mounica.mocktweets.adapters.ProfileViewPagerAdapter;
import com.mounica.mocktweets.utils.Constants;

public class ProfileActivity extends AppCompatActivity {

  private static final int TAB_COUNT = 4;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_profile);
    Toolbar toolbar = findViewById(R.id.toolbar_profile);
    setSupportActionBar(toolbar);

    getSupportActionBar().setHomeButtonEnabled(true);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    ImageView imageView = findViewById(R.id.image_profle);
    TextView userName = findViewById(R.id.text_profile_name);
    TextView screenName = findViewById(R.id.text_profile_screenname);
    TextView followers = findViewById(R.id.text_profile_followers);
    TextView following = findViewById(R.id.text_profile_following);
    ViewPager viewPager = findViewById(R.id.vp_profile);
    TabLayout tabLayout = findViewById(R.id.tab_profile);

    Intent userDetailsIntent = getIntent();

    // Update user details
    CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
    collapsingToolbarLayout.setTitle(userDetailsIntent.getStringExtra("name"));
    Glide.with(this)
        .load(userDetailsIntent.getStringExtra(Constants.INTENT_BG_IMAGE))
        .fitCenter()
        .into(imageView);
    userName.setText(userDetailsIntent.getStringExtra(Constants.INTENT_USER));
    screenName.setText("@" + userDetailsIntent.getStringExtra(Constants.INTENT_SCREEN_NAME));
    followers.setText(userDetailsIntent.getStringExtra(Constants.INTENT_FOLLOWERS));
    following.setText(userDetailsIntent.getStringExtra(Constants.INTENT_FOLLOWING));

    // ViewPages formulation
    ProfileViewPagerAdapter profileViewPagerAdapter = new ProfileViewPagerAdapter(
        getSupportFragmentManager(), TAB_COUNT,
        userDetailsIntent.getStringExtra(Constants.INTENT_SCREEN_NAME));
    tabLayout.addTab(tabLayout.newTab().setText(R.string.tweets));
    tabLayout.addTab(tabLayout.newTab().setText(R.string.tweetsnreplies));
    tabLayout.addTab(tabLayout.newTab().setText(R.string.media));
    tabLayout.addTab(tabLayout.newTab().setText(R.string.likes));
    viewPager.setAdapter(profileViewPagerAdapter);
    tabLayout.setupWithViewPager(viewPager);
  }
}
