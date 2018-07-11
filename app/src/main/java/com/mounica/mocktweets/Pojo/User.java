package com.mounica.mocktweets.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("profile_sidebar_fill_color")
  @Expose
  private String profileSidebarFillColor;
  @SerializedName("profile_background_tile")
  @Expose
  private boolean profileBackgroundTile;
  @SerializedName("profile_sidebar_border_color")
  @Expose
  private String profileSidebarBorderColor;
  @SerializedName("profile_image_url")
  @Expose
  private String profileImageUrl;
  @SerializedName("created_at")
  @Expose
  private String createdAt;
  @SerializedName("location")
  @Expose
  private String location;
  @SerializedName("follow_request_sent")
  @Expose
  private boolean followRequestSent;
  @SerializedName("id_str")
  @Expose
  private String idStr;
  @SerializedName("is_translator")
  @Expose
  private boolean isTranslator;
  @SerializedName("profile_link_color")
  @Expose
  private String profileLinkColor;
  @SerializedName("entities")
  @Expose
  private UrlDescription entities;
  @SerializedName("default_profile")
  @Expose
  private boolean defaultProfile;
  @SerializedName("url")
  @Expose
  private String url;
  @SerializedName("contributors_enabled")
  @Expose
  private boolean contributorsEnabled;
  @SerializedName("favourites_count")
  @Expose
  private int favouritesCount;
  @SerializedName("utc_offset")
  @Expose
  private int utcOffset;
  @SerializedName("profile_image_url_https")
  @Expose
  private String profileImageUrlHttps;
  @SerializedName("id")
  @Expose
  private int id;
  @SerializedName("listed_count")
  @Expose
  private int listedCount;
  @SerializedName("profile_use_background_image")
  @Expose
  private boolean profileUseBackgroundImage;
  @SerializedName("profile_text_color")
  @Expose
  private String profileTextColor;
  @SerializedName("followers_count")
  @Expose
  private int followersCount;
  @SerializedName("lang")
  @Expose
  private String lang;
  @SerializedName("protected")
  @Expose
  private boolean _protected;
  @SerializedName("geo_enabled")
  @Expose
  private boolean geoEnabled;
  @SerializedName("notifications")
  @Expose
  private boolean notifications;
  @SerializedName("description")
  @Expose
  private String description;
  @SerializedName("profile_background_color")
  @Expose
  private String profileBackgroundColor;
  @SerializedName("verified")
  @Expose
  private boolean verified;
  @SerializedName("time_zone")
  @Expose
  private String timeZone;
  @SerializedName("profile_background_image_url_https")
  @Expose
  private String profileBackgroundImageUrlHttps;
  @SerializedName("statuses_count")
  @Expose
  private int statusesCount;
  @SerializedName("profile_background_image_url")
  @Expose
  private String profileBackgroundImageUrl;
  @SerializedName("default_profile_image")
  @Expose
  private boolean defaultProfileImage;
  @SerializedName("friends_count")
  @Expose
  private int friendsCount;
  @SerializedName("following")
  @Expose
  private boolean following;
  @SerializedName("show_all_inline_media")
  @Expose
  private boolean showAllInlineMedia;
  @SerializedName("screen_name")
  @Expose
  private String screenName;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public User withName(String name) {
    this.name = name;
    return this;
  }

  public String getProfileSidebarFillColor() {
    return profileSidebarFillColor;
  }

  public void setProfileSidebarFillColor(String profileSidebarFillColor) {
    this.profileSidebarFillColor = profileSidebarFillColor;
  }

  public User withProfileSidebarFillColor(String profileSidebarFillColor) {
    this.profileSidebarFillColor = profileSidebarFillColor;
    return this;
  }

  public boolean isProfileBackgroundTile() {
    return profileBackgroundTile;
  }

  public void setProfileBackgroundTile(boolean profileBackgroundTile) {
    this.profileBackgroundTile = profileBackgroundTile;
  }

  public User withProfileBackgroundTile(boolean profileBackgroundTile) {
    this.profileBackgroundTile = profileBackgroundTile;
    return this;
  }

  public String getProfileSidebarBorderColor() {
    return profileSidebarBorderColor;
  }

  public void setProfileSidebarBorderColor(String profileSidebarBorderColor) {
    this.profileSidebarBorderColor = profileSidebarBorderColor;
  }

  public User withProfileSidebarBorderColor(String profileSidebarBorderColor) {
    this.profileSidebarBorderColor = profileSidebarBorderColor;
    return this;
  }

  public String getProfileImageUrl() {
    return profileImageUrl;
  }

  public void setProfileImageUrl(String profileImageUrl) {
    this.profileImageUrl = profileImageUrl;
  }

  public User withProfileImageUrl(String profileImageUrl) {
    this.profileImageUrl = profileImageUrl;
    return this;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public User withCreatedAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public User withLocation(String location) {
    this.location = location;
    return this;
  }

  public boolean isFollowRequestSent() {
    return followRequestSent;
  }

  public void setFollowRequestSent(boolean followRequestSent) {
    this.followRequestSent = followRequestSent;
  }

  public User withFollowRequestSent(boolean followRequestSent) {
    this.followRequestSent = followRequestSent;
    return this;
  }

  public String getIdStr() {
    return idStr;
  }

  public void setIdStr(String idStr) {
    this.idStr = idStr;
  }

  public User withIdStr(String idStr) {
    this.idStr = idStr;
    return this;
  }

  public boolean isIsTranslator() {
    return isTranslator;
  }

  public void setIsTranslator(boolean isTranslator) {
    this.isTranslator = isTranslator;
  }

  public User withIsTranslator(boolean isTranslator) {
    this.isTranslator = isTranslator;
    return this;
  }

  public String getProfileLinkColor() {
    return profileLinkColor;
  }

  public void setProfileLinkColor(String profileLinkColor) {
    this.profileLinkColor = profileLinkColor;
  }

  public User withProfileLinkColor(String profileLinkColor) {
    this.profileLinkColor = profileLinkColor;
    return this;
  }

  public UrlDescription getEntities() {
    return entities;
  }

  public void setEntities(UrlDescription entities) {
    this.entities = entities;
  }

  public User withEntities(UrlDescription entities) {
    this.entities = entities;
    return this;
  }

  public boolean isDefaultProfile() {
    return defaultProfile;
  }

  public void setDefaultProfile(boolean defaultProfile) {
    this.defaultProfile = defaultProfile;
  }

  public User withDefaultProfile(boolean defaultProfile) {
    this.defaultProfile = defaultProfile;
    return this;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public User withUrl(String url) {
    this.url = url;
    return this;
  }

  public boolean isContributorsEnabled() {
    return contributorsEnabled;
  }

  public void setContributorsEnabled(boolean contributorsEnabled) {
    this.contributorsEnabled = contributorsEnabled;
  }

  public User withContributorsEnabled(boolean contributorsEnabled) {
    this.contributorsEnabled = contributorsEnabled;
    return this;
  }

  public int getFavouritesCount() {
    return favouritesCount;
  }

  public void setFavouritesCount(int favouritesCount) {
    this.favouritesCount = favouritesCount;
  }

  public User withFavouritesCount(int favouritesCount) {
    this.favouritesCount = favouritesCount;
    return this;
  }

  public int getUtcOffset() {
    return utcOffset;
  }

  public void setUtcOffset(int utcOffset) {
    this.utcOffset = utcOffset;
  }

  public User withUtcOffset(int utcOffset) {
    this.utcOffset = utcOffset;
    return this;
  }

  public String getProfileImageUrlHttps() {
    return profileImageUrlHttps;
  }

  public void setProfileImageUrlHttps(String profileImageUrlHttps) {
    this.profileImageUrlHttps = profileImageUrlHttps;
  }

  public User withProfileImageUrlHttps(String profileImageUrlHttps) {
    this.profileImageUrlHttps = profileImageUrlHttps;
    return this;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public User withId(int id) {
    this.id = id;
    return this;
  }

  public int getListedCount() {
    return listedCount;
  }

  public void setListedCount(int listedCount) {
    this.listedCount = listedCount;
  }

  public User withListedCount(int listedCount) {
    this.listedCount = listedCount;
    return this;
  }

  public boolean isProfileUseBackgroundImage() {
    return profileUseBackgroundImage;
  }

  public void setProfileUseBackgroundImage(boolean profileUseBackgroundImage) {
    this.profileUseBackgroundImage = profileUseBackgroundImage;
  }

  public User withProfileUseBackgroundImage(boolean profileUseBackgroundImage) {
    this.profileUseBackgroundImage = profileUseBackgroundImage;
    return this;
  }

  public String getProfileTextColor() {
    return profileTextColor;
  }

  public void setProfileTextColor(String profileTextColor) {
    this.profileTextColor = profileTextColor;
  }

  public User withProfileTextColor(String profileTextColor) {
    this.profileTextColor = profileTextColor;
    return this;
  }

  public int getFollowersCount() {
    return followersCount;
  }

  public void setFollowersCount(int followersCount) {
    this.followersCount = followersCount;
  }

  public User withFollowersCount(int followersCount) {
    this.followersCount = followersCount;
    return this;
  }

  public String getLang() {
    return lang;
  }

  public void setLang(String lang) {
    this.lang = lang;
  }

  public User withLang(String lang) {
    this.lang = lang;
    return this;
  }

  public boolean isProtected() {
    return _protected;
  }

  public void setProtected(boolean _protected) {
    this._protected = _protected;
  }

  public User withProtected(boolean _protected) {
    this._protected = _protected;
    return this;
  }

  public boolean isGeoEnabled() {
    return geoEnabled;
  }

  public void setGeoEnabled(boolean geoEnabled) {
    this.geoEnabled = geoEnabled;
  }

  public User withGeoEnabled(boolean geoEnabled) {
    this.geoEnabled = geoEnabled;
    return this;
  }

  public boolean isNotifications() {
    return notifications;
  }

  public void setNotifications(boolean notifications) {
    this.notifications = notifications;
  }

  public User withNotifications(boolean notifications) {
    this.notifications = notifications;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public User withDescription(String description) {
    this.description = description;
    return this;
  }

  public String getProfileBackgroundColor() {
    return profileBackgroundColor;
  }

  public void setProfileBackgroundColor(String profileBackgroundColor) {
    this.profileBackgroundColor = profileBackgroundColor;
  }

  public User withProfileBackgroundColor(String profileBackgroundColor) {
    this.profileBackgroundColor = profileBackgroundColor;
    return this;
  }

  public boolean isVerified() {
    return verified;
  }

  public void setVerified(boolean verified) {
    this.verified = verified;
  }

  public User withVerified(boolean verified) {
    this.verified = verified;
    return this;
  }

  public String getTimeZone() {
    return timeZone;
  }

  public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
  }

  public User withTimeZone(String timeZone) {
    this.timeZone = timeZone;
    return this;
  }

  public String getProfileBackgroundImageUrlHttps() {
    return profileBackgroundImageUrlHttps;
  }

  public void setProfileBackgroundImageUrlHttps(String profileBackgroundImageUrlHttps) {
    this.profileBackgroundImageUrlHttps = profileBackgroundImageUrlHttps;
  }

  public User withProfileBackgroundImageUrlHttps(String profileBackgroundImageUrlHttps) {
    this.profileBackgroundImageUrlHttps = profileBackgroundImageUrlHttps;
    return this;
  }

  public int getStatusesCount() {
    return statusesCount;
  }

  public void setStatusesCount(int statusesCount) {
    this.statusesCount = statusesCount;
  }

  public User withStatusesCount(int statusesCount) {
    this.statusesCount = statusesCount;
    return this;
  }

  public String getProfileBackgroundImageUrl() {
    return profileBackgroundImageUrl;
  }

  public void setProfileBackgroundImageUrl(String profileBackgroundImageUrl) {
    this.profileBackgroundImageUrl = profileBackgroundImageUrl;
  }

  public User withProfileBackgroundImageUrl(String profileBackgroundImageUrl) {
    this.profileBackgroundImageUrl = profileBackgroundImageUrl;
    return this;
  }

  public boolean isDefaultProfileImage() {
    return defaultProfileImage;
  }

  public void setDefaultProfileImage(boolean defaultProfileImage) {
    this.defaultProfileImage = defaultProfileImage;
  }

  public User withDefaultProfileImage(boolean defaultProfileImage) {
    this.defaultProfileImage = defaultProfileImage;
    return this;
  }

  public int getFriendsCount() {
    return friendsCount;
  }

  public void setFriendsCount(int friendsCount) {
    this.friendsCount = friendsCount;
  }

  public User withFriendsCount(int friendsCount) {
    this.friendsCount = friendsCount;
    return this;
  }

  public boolean isFollowing() {
    return following;
  }

  public void setFollowing(boolean following) {
    this.following = following;
  }

  public User withFollowing(boolean following) {
    this.following = following;
    return this;
  }

  public boolean isShowAllInlineMedia() {
    return showAllInlineMedia;
  }

  public void setShowAllInlineMedia(boolean showAllInlineMedia) {
    this.showAllInlineMedia = showAllInlineMedia;
  }

  public User withShowAllInlineMedia(boolean showAllInlineMedia) {
    this.showAllInlineMedia = showAllInlineMedia;
    return this;
  }

  public String getScreenName() {
    return screenName;
  }

  public void setScreenName(String screenName) {
    this.screenName = screenName;
  }

  public User withScreenName(String screenName) {
    this.screenName = screenName;
    return this;
  }

}
