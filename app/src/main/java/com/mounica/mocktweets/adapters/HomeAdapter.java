package com.mounica.mocktweets.adapters;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;
import com.bumptech.glide.Glide;
import com.mounica.mocktweets.R;
import com.mounica.mocktweets.TweetClickableEntitites;
import com.mounica.mocktweets.utils.Constants;
import com.twitter.sdk.android.core.models.HashtagEntity;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.MentionEntity;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.UrlEntity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Implementation of the Adapter for Home Timeline.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.BaseViewHolder> {

  private static final int MEDIA_TYPE_DEFAULT_INT = 0;
  private static final int MEDIA_TYPE_GIF_INT = 1;
  private static final int MEDIA_TYPE_PHOTO_INT = 2;
  private static final int MEDIA_TYPE_VIDEO_INT = 3;

  private static final String TAG = "HomeAdapter";
  private List<Tweet> mHomeTimeLine = new ArrayList<>();

  public HomeAdapter(List<Tweet> homeTimeLine) {
    mHomeTimeLine = homeTimeLine;
  }

  @Override
  public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    switch (viewType) {
      case MEDIA_TYPE_PHOTO_INT:
        TimeLinePhotoViewHolder viewHolder = new TimeLinePhotoViewHolder(
            LayoutInflater.from(parent.getContext())
                .inflate(R.layout.holder_rv_home, parent, false));
        viewHolder.mMediaView = (ImageView) viewHolder.mViewStub.inflate();
        return viewHolder;
      case MEDIA_TYPE_GIF_INT:
      case MEDIA_TYPE_VIDEO_INT:
      default:
        return new BaseViewHolder(LayoutInflater.from(parent.getContext())
            .inflate(R.layout.holder_rv_home, parent, false));
    }
  }

  @Override
  public void onBindViewHolder(BaseViewHolder holder, int position) {

    List<UrlEntity> urlEntityList;
    List<HashtagEntity> hashtagEntityList;
    List<MentionEntity> mentionEntityList;
    List<MediaEntity> mediaEntityList;
    int startIndex;
    int endIndex;

    Tweet tweet = mHomeTimeLine.get(position);
    Glide.with(holder.mUserImage.getContext())
        .load(tweet.user.profileImageUrlHttps.replaceFirst("_normal.", "."))
        .fitCenter()
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

    // Get Date
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM");
    Date date = new Date(tweet.createdAt);
    holder.mTimeAgo.setText(simpleDateFormat.format(date));

    userNameBuilder.append(" @" + tweet.user.screenName);
    holder.mUserName.setText(userNameBuilder);

    // Text processing with hashtags/urls/mentions
    urlEntityList = tweet.entities.urls;
    hashtagEntityList = tweet.entities.hashtags;
    mentionEntityList = tweet.entities.userMentions;
    SpannableStringBuilder textBuilder = new SpannableStringBuilder(tweet.text);
    if (urlEntityList != null && urlEntityList.size() > 0) {
      for (UrlEntity entity : urlEntityList) {
        startIndex = entity.indices.get(0);
        endIndex = entity.indices.get(1);
        textBuilder
            .setSpan(new TweetClickableEntitites(entity.url, holder.mTweetText.getContext()),
                startIndex, endIndex, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
      }
    }

    if (hashtagEntityList.size() > 0) {
      for (HashtagEntity hashtagEntity : hashtagEntityList) {
        startIndex = hashtagEntity.indices.get(0);
        endIndex = hashtagEntity.indices.get(1);
        textBuilder.setSpan(
            new TweetClickableEntitites("#" + hashtagEntity.text, holder.mTweetText.getContext()),
            startIndex, endIndex, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
      }
    }

    if (mentionEntityList.size() > 0) {
      for (MentionEntity mentionEntity : mentionEntityList) {
        startIndex = mentionEntity.indices.get(0);
        endIndex = mentionEntity.indices.get(1);
        textBuilder.setSpan(new TweetClickableEntitites("@" + mentionEntity.screenName,
                holder.mTweetText.getContext()), startIndex, endIndex,
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
      }
    }

    holder.mTweetText.setText(textBuilder);
    holder.mTweetText.setMovementMethod(LinkMovementMethod.getInstance());

    // Media processing
    mediaEntityList = tweet.entities.media;
    if (mediaEntityList.size() > 0) {
      for (MediaEntity mediaEntity : mediaEntityList) {
        switch (mediaEntity.type) {
          case Constants.MEDIA_TYPE_PHOTO:
            int height = mediaEntity.sizes.medium.h;
            int width = mediaEntity.sizes.medium.w;
            Glide.with(((TimeLinePhotoViewHolder) holder).mMediaView.getContext())
                .load(mediaEntity.mediaUrlHttps)
                .fitCenter()
                .into(((TimeLinePhotoViewHolder) holder).mMediaView);
            break;
          case Constants.MEDIA_TYPE_GIF:
          case Constants.MEDIA_TYPE_VIDEO:
          default:
            break;
        }
      }
    }
    holder.mRetweet.setText(String.valueOf(tweet.retweetCount));
    holder.mFavourite.setText(String.valueOf(tweet.favoriteCount));
    holder.mShare.setText("");
  }

  @Override
  public int getItemViewType(int position) {
    String mediaType = "";
    if (mHomeTimeLine.get(position).entities.media.size() > 0) {
      mediaType = mHomeTimeLine.get(position).entities.media.get(0).type;
    }
    switch (mediaType) {
      case Constants.MEDIA_TYPE_GIF:
        return MEDIA_TYPE_GIF_INT;
      case Constants.MEDIA_TYPE_PHOTO:
        return MEDIA_TYPE_PHOTO_INT;
      case Constants.MEDIA_TYPE_VIDEO:
        return MEDIA_TYPE_VIDEO_INT;
      default:
        return MEDIA_TYPE_DEFAULT_INT;
    }
  }

  @Override
  public int getItemCount() {
    return mHomeTimeLine == null ? 0 : mHomeTimeLine.size();
  }

  protected class BaseViewHolder extends ViewHolder {

    private ImageView mUserImage;
    private TextView mUserName;
    private TextView mTimeAgo;
    private TextView mTweetText;
    private TextView mComment;
    private TextView mRetweet;
    private TextView mFavourite;
    private TextView mShare;

    public BaseViewHolder(View itemView) {
      super(itemView);
      mUserImage = itemView.findViewById(R.id.image_user);
      mUserName = itemView.findViewById(R.id.text_username);
      mTimeAgo = itemView.findViewById(R.id.text_timeago);
      mTweetText = itemView.findViewById(R.id.text_tweet);
      mComment = itemView.findViewById(R.id.text_comment);
      mRetweet = itemView.findViewById(R.id.text_retweet);
      mFavourite = itemView.findViewById(R.id.text_favourite);
      mShare = itemView.findViewById(R.id.text_share);
    }
  }

  public class TimeLinePhotoViewHolder extends BaseViewHolder {

    private ViewStub mViewStub;
    private ImageView mMediaView;

    public TimeLinePhotoViewHolder(View itemView) {
      super(itemView);
      mViewStub = itemView.findViewById(R.id.frame_holder);
    }
  }

  public class TimeLineVideoViewHolder extends BaseViewHolder {

    private VideoView mMediaView;

    public TimeLineVideoViewHolder(View itemView) {
      super(itemView);
      mMediaView = (VideoView) itemView.findViewById(R.id.frame_holder);
    }
  }
}
