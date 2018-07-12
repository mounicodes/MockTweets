package com.mounica.mocktweets;

import android.app.Application;
import android.util.Log;
import com.mounica.mocktweets.utils.Constants;
import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;

/**
 * Application file for Authenticating user
 */
public class TwitterApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    TwitterConfig config = new TwitterConfig.Builder(this)
        .logger(new DefaultLogger(Log.DEBUG))
        .twitterAuthConfig(new TwitterAuthConfig(Constants.CONSUMER_KEY,
            Constants.CONSUMER_SECRET))
        .debug(true)
        .build();
    Twitter.initialize(config);
  }
}