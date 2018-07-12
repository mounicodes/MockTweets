package com.mounica.mocktweets.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Trend {

  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("url")
  @Expose
  private String url;
  @SerializedName("promoted_content")
  @Expose
  private Object promotedContent;
  @SerializedName("query")
  @Expose
  private String query;
  @SerializedName("tweet_volume")
  @Expose
  private Object tweetVolume;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Trend withName(String name) {
    this.name = name;
    return this;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Trend withUrl(String url) {
    this.url = url;
    return this;
  }

  public Object getPromotedContent() {
    return promotedContent;
  }

  public void setPromotedContent(Object promotedContent) {
    this.promotedContent = promotedContent;
  }

  public Trend withPromotedContent(Object promotedContent) {
    this.promotedContent = promotedContent;
    return this;
  }

  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public Trend withQuery(String query) {
    this.query = query;
    return this;
  }

  public Object getTweetVolume() {
    return tweetVolume;
  }

  public void setTweetVolume(Object tweetVolume) {
    this.tweetVolume = tweetVolume;
  }

  public Trend withTweetVolume(Object tweetVolume) {
    this.tweetVolume = tweetVolume;
    return this;
  }

}
