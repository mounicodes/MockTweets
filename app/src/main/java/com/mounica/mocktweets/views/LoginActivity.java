package com.mounica.mocktweets.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import com.mounica.mocktweets.R;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

/**
 * Authentication using Twitter Login Button
 */
public class LoginActivity extends AppCompatActivity {

  private static final String TAG = "LoginActivity";
  private TwitterLoginButton mLoginButton;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    mLoginButton = findViewById(R.id.login_button);
    mLoginButton.setCallback(new Callback<TwitterSession>() {
      @Override
      public void success(Result<TwitterSession> result) {
        Intent sessionIntent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(sessionIntent);
      }

      @Override
      public void failure(TwitterException exception) {
        Log.e(TAG, "failure: " + R.string.login_fail);
        Toast.makeText(LoginActivity.this, R.string.login_fail, Toast.LENGTH_LONG).show();
      }
    });
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    mLoginButton.onActivityResult(requestCode, resultCode, data);
  }
}
