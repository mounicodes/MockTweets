package com.mounica.mocktweets.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class UrlList {

  @SerializedName("urls")
  @Expose
  private List<Object> urls = null;

  public List<Object> getUrls() {
    return urls;
  }

  public void setUrls(List<Object> urls) {
    this.urls = urls;
  }

  public UrlList withUrls(List<Object> urls) {
    this.urls = urls;
    return this;
  }

}
