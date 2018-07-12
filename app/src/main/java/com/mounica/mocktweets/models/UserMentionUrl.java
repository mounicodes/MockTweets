package com.mounica.mocktweets.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class UserMentionUrl {

  @SerializedName("urls")
  @Expose
  private List<Url> urls = null;
  @SerializedName("hashtags")
  @Expose
  private List<Object> hashtags = null;
  @SerializedName("user_mentions")
  @Expose
  private List<UserMention> userMentions = null;

  public List<Url> getUrls() {
    return urls;
  }

  public void setUrls(List<Url> urls) {
    this.urls = urls;
  }

  public UserMentionUrl withUrls(List<Url> urls) {
    this.urls = urls;
    return this;
  }

  public List<Object> getHashtags() {
    return hashtags;
  }

  public void setHashtags(List<Object> hashtags) {
    this.hashtags = hashtags;
  }

  public UserMentionUrl withHashtags(List<Object> hashtags) {
    this.hashtags = hashtags;
    return this;
  }

  public List<UserMention> getUserMentions() {
    return userMentions;
  }

  public void setUserMentions(List<UserMention> userMentions) {
    this.userMentions = userMentions;
  }

  public UserMentionUrl withUserMentions(List<UserMention> userMentions) {
    this.userMentions = userMentions;
    return this;
  }

}
