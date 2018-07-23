package com.mounica.mocktweets;

import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.mounica.mocktweets.views.ProfileActivity;

public class TweetClickableEntitites extends ClickableSpan {

  private String mClickableText = null;
  private Context mContext;

  public TweetClickableEntitites(String clickableText, Context context) {
    mClickableText = clickableText;
    mContext = context;
  }

  @Override
  public void onClick(View widget) {
    if (mClickableText.charAt(0) == '#') {
      //TODO route to search activity
    } else if (mClickableText.charAt(0) == '@') {
      Intent sendProfile = new Intent(mContext, ProfileActivity.class);
      mContext.startActivity(sendProfile);
    } else {
      //TODO open url
    }
  }

  @Override
  public void updateDrawState(TextPaint ds) {
    ds.setColor(mContext.getResources().getColor(R.color.colorPrimaryDark));
    ds.setUnderlineText(false);
  }
}
