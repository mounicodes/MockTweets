package com.mounica.mocktweets.models;

import android.location.Location;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrendLocation {

  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("woeid")
  @Expose
  private int woeid;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TrendLocation withName(String name) {
    this.name = name;
    return this;
  }

  public int getWoeid() {
    return woeid;
  }

  public void setWoeid(int woeid) {
    this.woeid = woeid;
  }

  public TrendLocation withWoeid(int woeid) {
    this.woeid = woeid;
    return this;
  }

}
