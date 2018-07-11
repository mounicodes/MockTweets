package com.mounica.mocktweets.Adapters;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.mounica.mocktweets.R;
import com.twitter.sdk.android.core.models.HashtagEntity;
import com.twitter.sdk.android.core.models.MentionEntity;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.UrlEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the Adapter for Home Timeline.
 */


public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeTimelineVh> {

  private static final String TAG = "HomeAdapter";
  private List<Tweet> mHomeTimeLine = new ArrayList<>();

  public HomeAdapter(List<Tweet> homeTimeLine) {
    mHomeTimeLine = homeTimeLine;
  }

  @Override
  public HomeTimelineVh onCreateViewHolder(ViewGroup parent, int viewType) {
    return new HomeTimelineVh(
        LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_rv_home, parent, false));
  }

  @Override
  public void onBindViewHolder(HomeTimelineVh holder, int position) {
    List<UrlEntity> urlEntityList = new ArrayList<>();
    List<HashtagEntity> hashtagEntityList = new ArrayList<>();
    List<MentionEntity> mentionEntityList = new ArrayList<>();

    Tweet tweet = mHomeTimeLine.get(position);
    urlEntityList = tweet.entities.urls;
    hashtagEntityList = tweet.entities.hashtags;
    mentionEntityList = tweet.entities.userMentions;
    Glide.with(holder.mUserImage.getContext())
        .load(tweet.user.profileImageUrl)
        .into(holder.mUserImage);

    // UserName formulation Begin
    SpannableStringBuilder userNameBuilder = new SpannableStringBuilder(tweet.user.name);
    if (tweet.user.verified) {
      ImageSpan verificationIcon = new ImageSpan(holder.mUserName.getContext(),
          R.drawable.ps__ic_verified);
      userNameBuilder.setSpan(new StyleSpan(Typeface.BOLD), 0, tweet.user.name.length(),
          Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
      userNameBuilder.append(" ")
          .setSpan(verificationIcon, userNameBuilder.length() - 1, userNameBuilder.length(),
              Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
    userNameBuilder.append(" @" + tweet.user.screenName);
    holder.mUserName.setText(userNameBuilder);
    holder.mTweetText.setText(tweet.text);
    holder.mRetweet.setText(String.valueOf(tweet.retweetCount));
    holder.mFavourite.setText(String.valueOf(tweet.favoriteCount));
    holder.mShare.setText("");
  }

  @Override
  public int getItemCount() {
    Log.d(TAG, "getItemCount: ");
    return mHomeTimeLine == null ? 0 : mHomeTimeLine.size();
  }


  public class HomeTimelineVh extends ViewHolder {

    private ImageView mUserImage;
    private TextView mUserName;
    private TextView mTweetText;
    private TextView mComment;
    private TextView mRetweet;
    private TextView mFavourite;
    private TextView mShare;

    public HomeTimelineVh(View itemView) {
      super(itemView);
      mUserImage = itemView.findViewById(R.id.image_user);
      mUserName = itemView.findViewById(R.id.text_username);
      mTweetText = itemView.findViewById(R.id.text_tweet);
      mComment = itemView.findViewById(R.id.text_comment);
      mRetweet = itemView.findViewById(R.id.text_retweet);
      mFavourite = itemView.findViewById(R.id.text_favourite);
      mShare = itemView.findViewById(R.id.text_share);
      mComment.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_vector_reply_stroke, 0, 0, 0);
      mRetweet
          .setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_vector_retweet_stroke, 0, 0, 0);
      mFavourite
          .setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_vector_heart_stroke, 0, 0, 0);
      mShare.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_vector_share_android, 0, 0, 0);
    }
  }

}
