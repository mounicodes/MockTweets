package com.mounica.mocktweets.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class DisplayUrl {

  @SerializedName("expanded_url")
  @Expose
  private String expandedUrl;
  @SerializedName("url")
  @Expose
  private String url;
  @SerializedName("indices")
  @Expose
  private List<Integer> indices = null;
  @SerializedName("display_url")
  @Expose
  private String displayUrl;

  public String getExpandedUrl() {
    return expandedUrl;
  }

  public void setExpandedUrl(String expandedUrl) {
    this.expandedUrl = expandedUrl;
  }

  public DisplayUrl withExpandedUrl(String expandedUrl) {
    this.expandedUrl = expandedUrl;
    return this;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public DisplayUrl withUrl(String url) {
    this.url = url;
    return this;
  }

  public List<Integer> getIndices() {
    return indices;
  }

  public void setIndices(List<Integer> indices) {
    this.indices = indices;
  }

  public DisplayUrl withIndices(List<Integer> indices) {
    this.indices = indices;
    return this;
  }

  public String getDisplayUrl() {
    return displayUrl;
  }

  public void setDisplayUrl(String displayUrl) {
    this.displayUrl = displayUrl;
  }

  public DisplayUrl withDisplayUrl(String displayUrl) {
    this.displayUrl = displayUrl;
    return this;
  }

}
