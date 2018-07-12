package com.mounica.mocktweets.models;

import android.location.Location;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TrendsList {

  @SerializedName("trends")
  @Expose
  private List<Trend> trends = null;
  @SerializedName("as_of")
  @Expose
  private String asOf;
  @SerializedName("created_at")
  @Expose
  private String createdAt;
  @SerializedName("locations")
  @Expose
  private List<Location> locations = null;

  public List<Trend> getTrends() {
    return trends;
  }

  public void setTrends(List<Trend> trends) {
    this.trends = trends;
  }

  public TrendsList withTrends(List<Trend> trends) {
    this.trends = trends;
    return this;
  }

  public String getAsOf() {
    return asOf;
  }

  public void setAsOf(String asOf) {
    this.asOf = asOf;
  }

  public TrendsList withAsOf(String asOf) {
    this.asOf = asOf;
    return this;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public TrendsList withCreatedAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public List<Location> getLocations() {
    return locations;
  }

  public void setLocations(List<Location> locations) {
    this.locations = locations;
  }

  public TrendsList withLocations(List<Location> locations) {
    this.locations = locations;
    return this;
  }

}
