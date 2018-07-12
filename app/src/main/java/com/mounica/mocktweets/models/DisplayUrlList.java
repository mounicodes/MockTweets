package com.mounica.mocktweets.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class DisplayUrlList {

  @SerializedName("urls")
  @Expose
  private List<DisplayUrl> urls = null;

  public List<DisplayUrl> getUrls() {
    return urls;
  }

  public void setUrls(List<DisplayUrl> urls) {
    this.urls = urls;
  }

  public DisplayUrlList withUrls(List<DisplayUrl> urls) {
    this.urls = urls;
    return this;
  }

}
