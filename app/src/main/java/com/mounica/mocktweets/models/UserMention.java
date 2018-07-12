package com.mounica.mocktweets.Pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserMention {

  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("id_str")
  @Expose
  private String idStr;
  @SerializedName("id")
  @Expose
  private int id;
  @SerializedName("indices")
  @Expose
  private List<Integer> indices = null;
  @SerializedName("screen_name")
  @Expose
  private String screenName;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UserMention withName(String name) {
    this.name = name;
    return this;
  }

  public String getIdStr() {
    return idStr;
  }

  public void setIdStr(String idStr) {
    this.idStr = idStr;
  }

  public UserMention withIdStr(String idStr) {
    this.idStr = idStr;
    return this;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public UserMention withId(int id) {
    this.id = id;
    return this;
  }

  public List<Integer> getIndices() {
    return indices;
  }

  public void setIndices(List<Integer> indices) {
    this.indices = indices;
  }

  public UserMention withIndices(List<Integer> indices) {
    this.indices = indices;
    return this;
  }

  public String getScreenName() {
    return screenName;
  }

  public void setScreenName(String screenName) {
    this.screenName = screenName;
  }

  public UserMention withScreenName(String screenName) {
    this.screenName = screenName;
    return this;
  }

}