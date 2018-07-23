package com.mounica.mocktweets.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.mounica.mocktweets.R;

public class ProfileActivity extends AppCompatActivity {

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

    Intent userDetailsIntent = getIntent();

    CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
    collapsingToolbarLayout.setTitle(userDetailsIntent.getStringExtra("name"));
    Glide.with(this)
        .load(userDetailsIntent.getStringExtra("bg_image"))
        .fitCenter()
        .into(imageView);
    userName.setText(userDetailsIntent.getStringExtra("name"));
    screenName.setText(userDetailsIntent.getStringExtra("screen_name"));
    followers.setText(userDetailsIntent.getStringExtra("followers"));
    following.setText(userDetailsIntent.getStringExtra("following"));
  }
}
