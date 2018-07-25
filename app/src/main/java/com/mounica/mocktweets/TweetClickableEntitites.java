package com.mounica.mocktweets;

import android.content.Context;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.mounica.mocktweets.utils.Constants;

public class TweetClickableEntitites extends ClickableSpan {

  private String mClickableText = null;
  private Context mContext;

  public TweetClickableEntitites(String clickableText, Context context) {
    mClickableText = clickableText;
    mContext = context;
  }

  @Override
  public void onClick(View widget) {
    switch (mClickableText.charAt(0)) {
      case '#':
      case '@':
      default:
        Snackbar.make(widget, Constants.TO_BE_IMPLEMENTED, BaseTransientBottomBar.LENGTH_SHORT).show();
        break;
    }
  }

  @Override
  public void updateDrawState(TextPaint ds) {
    ds.setColor(mContext.getResources().getColor(R.color.colorPrimaryDark));
    ds.setUnderlineText(false);
  }
}
