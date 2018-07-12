package com.mounica.mocktweets.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UrlDescription {

  @SerializedName("url")
  @Expose
  private DisplayUrlList url;
  @SerializedName("description")
  @Expose
  private UrlList description;

  public DisplayUrlList getUrl() {
    return url;
  }

  public void setUrl(DisplayUrlList url) {
    this.url = url;
  }

  public UrlDescription withUrl(DisplayUrlList url) {
    this.url = url;
    return this;
  }

  public UrlList getDescription() {
    return description;
  }

  public void setDescription(UrlList description) {
    this.description = description;
  }

  public UrlDescription withDescription(UrlList description) {
    this.description = description;
    return this;
  }

}
