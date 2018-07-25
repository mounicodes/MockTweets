package com.mounica.mocktweets.utils;

import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;

/**
 * Global Constants
 */
public class Constants {

  public static final String BASE_URL_OAUTH_AUTHENTICATE = "https://api.twitter.com/oauth/authenticate/";
  //  public static final String BASE_URL_TWITTER = "https://api.twitter.com/";
  public static final String BASE_URL_TWITTER = "https://api.twitter.com/1.1/";
  public static final String AUTHENTICATION_URL = "oauth2/token";
  public static final String URL_TRENDING = "https://api.twitter.com/1.1/trends/place.json?id=1";
  public static final String URL_ROOT_TWITTER_API = "https://api.twitter.com";
  public static final String URL_AUTHENTICATION = URL_ROOT_TWITTER_API + "/oauth2/token";
  public static final TwitterApiClient TWITTER_API_CLIENT = TwitterCore.getInstance()
      .getApiClient();

  // Media Type constants
  public static final String MEDIA_TYPE_GIF = "gif";
  public static final String MEDIA_TYPE_PHOTO = "photo";
  public static final String MEDIA_TYPE_VIDEO = "video";

  // Intent constants
  public static final String INTENT_USER = "user";
  public static final String INTENT_SCREEN_NAME = "screen_name";
  public static final String INTENT_FOLLOWERS = "followers";
  public static final String INTENT_FOLLOWING = "following";
  public static final String INTENT_BG_IMAGE = "bg_image";
  public static final String INTENT_PROFILE_IMG = "profile_image";
  public static final String INTENT_QUERY = "query";

  // To be implemented
  public static final String TO_BE_IMPLEMENTED = "To be implemented!!!";
}
