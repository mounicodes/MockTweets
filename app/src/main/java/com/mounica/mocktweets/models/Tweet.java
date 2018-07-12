package com.mounica.mocktweets.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tweet {

  @SerializedName("coordinates")
  @Expose
  private Object coordinates;
  @SerializedName("truncated")
  @Expose
  private boolean truncated;
  @SerializedName("created_at")
  @Expose
  private String createdAt;
  @SerializedName("favorited")
  @Expose
  private boolean favorited;
  @SerializedName("id_str")
  @Expose
  private String idStr;
  @SerializedName("in_reply_to_user_id_str")
  @Expose
  private Object inReplyToUserIdStr;
  @SerializedName("entities")
  @Expose
  private UserMentionUrl entities;
  @SerializedName("text")
  @Expose
  private String text;
  @SerializedName("contributors")
  @Expose
  private Object contributors;
  @SerializedName("id")
  @Expose
  private int id;
  @SerializedName("retweet_count")
  @Expose
  private int retweetCount;
  @SerializedName("in_reply_to_status_id_str")
  @Expose
  private Object inReplyToStatusIdStr;
  @SerializedName("geo")
  @Expose
  private Object geo;
  @SerializedName("retweeted")
  @Expose
  private boolean retweeted;
  @SerializedName("in_reply_to_user_id")
  @Expose
  private Object inReplyToUserId;
  @SerializedName("place")
  @Expose
  private Object place;
  @SerializedName("source")
  @Expose
  private String source;
  @SerializedName("user")
  @Expose
  private User user;
  @SerializedName("in_reply_to_screen_name")
  @Expose
  private Object inReplyToScreenName;
  @SerializedName("in_reply_to_status_id")
  @Expose
  private Object inReplyToStatusId;
  @SerializedName("possibly_sensitive")
  @Expose
  private boolean possiblySensitive;

  public Object getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(Object coordinates) {
    this.coordinates = coordinates;
  }

  public Tweet withCoordinates(Object coordinates) {
    this.coordinates = coordinates;
    return this;
  }

  public boolean isTruncated() {
    return truncated;
  }

  public void setTruncated(boolean truncated) {
    this.truncated = truncated;
  }

  public Tweet withTruncated(boolean truncated) {
    this.truncated = truncated;
    return this;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public Tweet withCreatedAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public boolean isFavorited() {
    return favorited;
  }

  public void setFavorited(boolean favorited) {
    this.favorited = favorited;
  }

  public Tweet withFavorited(boolean favorited) {
    this.favorited = favorited;
    return this;
  }

  public String getIdStr() {
    return idStr;
  }

  public void setIdStr(String idStr) {
    this.idStr = idStr;
  }

  public Tweet withIdStr(String idStr) {
    this.idStr = idStr;
    return this;
  }

  public Object getInReplyToUserIdStr() {
    return inReplyToUserIdStr;
  }

  public void setInReplyToUserIdStr(Object inReplyToUserIdStr) {
    this.inReplyToUserIdStr = inReplyToUserIdStr;
  }

  public Tweet withInReplyToUserIdStr(Object inReplyToUserIdStr) {
    this.inReplyToUserIdStr = inReplyToUserIdStr;
    return this;
  }

  public UserMentionUrl getEntities() {
    return entities;
  }

  public void setEntities(UserMentionUrl entities) {
    this.entities = entities;
  }

  public Tweet withEntities(UserMentionUrl entities) {
    this.entities = entities;
    return this;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Tweet withText(String text) {
    this.text = text;
    return this;
  }

  public Object getContributors() {
    return contributors;
  }

  public void setContributors(Object contributors) {
    this.contributors = contributors;
  }

  public Tweet withContributors(Object contributors) {
    this.contributors = contributors;
    return this;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Tweet withId(int id) {
    this.id = id;
    return this;
  }

  public int getRetweetCount() {
    return retweetCount;
  }

  public void setRetweetCount(int retweetCount) {
    this.retweetCount = retweetCount;
  }

  public Tweet withRetweetCount(int retweetCount) {
    this.retweetCount = retweetCount;
    return this;
  }

  public Object getInReplyToStatusIdStr() {
    return inReplyToStatusIdStr;
  }

  public void setInReplyToStatusIdStr(Object inReplyToStatusIdStr) {
    this.inReplyToStatusIdStr = inReplyToStatusIdStr;
  }

  public Tweet withInReplyToStatusIdStr(Object inReplyToStatusIdStr) {
    this.inReplyToStatusIdStr = inReplyToStatusIdStr;
    return this;
  }

  public Object getGeo() {
    return geo;
  }

  public void setGeo(Object geo) {
    this.geo = geo;
  }

  public Tweet withGeo(Object geo) {
    this.geo = geo;
    return this;
  }

  public boolean isRetweeted() {
    return retweeted;
  }

  public void setRetweeted(boolean retweeted) {
    this.retweeted = retweeted;
  }

  public Tweet withRetweeted(boolean retweeted) {
    this.retweeted = retweeted;
    return this;
  }

  public Object getInReplyToUserId() {
    return inReplyToUserId;
  }

  public void setInReplyToUserId(Object inReplyToUserId) {
    this.inReplyToUserId = inReplyToUserId;
  }

  public Tweet withInReplyToUserId(Object inReplyToUserId) {
    this.inReplyToUserId = inReplyToUserId;
    return this;
  }

  public Object getPlace() {
    return place;
  }

  public void setPlace(Object place) {
    this.place = place;
  }

  public Tweet withPlace(Object place) {
    this.place = place;
    return this;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public Tweet withSource(String source) {
    this.source = source;
    return this;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Tweet withUser(User user) {
    this.user = user;
    return this;
  }

  public Object getInReplyToScreenName() {
    return inReplyToScreenName;
  }

  public void setInReplyToScreenName(Object inReplyToScreenName) {
    this.inReplyToScreenName = inReplyToScreenName;
  }

  public Tweet withInReplyToScreenName(Object inReplyToScreenName) {
    this.inReplyToScreenName = inReplyToScreenName;
    return this;
  }

  public Object getInReplyToStatusId() {
    return inReplyToStatusId;
  }

  public void setInReplyToStatusId(Object inReplyToStatusId) {
    this.inReplyToStatusId = inReplyToStatusId;
  }

  public Tweet withInReplyToStatusId(Object inReplyToStatusId) {
    this.inReplyToStatusId = inReplyToStatusId;
    return this;
  }

  public boolean isPossiblySensitive() {
    return possiblySensitive;
  }

  public void setPossiblySensitive(boolean possiblySensitive) {
    this.possiblySensitive = possiblySensitive;
  }

  public Tweet withPossiblySensitive(boolean possiblySensitive) {
    this.possiblySensitive = possiblySensitive;
    return this;
  }

}
