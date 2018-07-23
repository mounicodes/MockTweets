package com.mounica.mocktweets.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import com.mounica.mocktweets.views.HomeFragment;
import com.mounica.mocktweets.views.NotificationsFragment;
import com.mounica.mocktweets.views.TrendsFragment;
import com.twitter.sdk.android.core.TwitterApiClient;

/**
 * Implementation of the Adapter for the ViewPager. Tabs are set to 4 in the MainActivity.
 * New Fragment is loaded based on the tab_selector.xml chosen by the  user.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

  private static final String TAG = "ViewPagerAdapter";
  private static TwitterApiClient mTwitterApiClient;
  private final int mTabCount;

  public ViewPagerAdapter(FragmentManager fm, TwitterApiClient twitterApiClient, int tabCount) {
    super(fm);
    mTwitterApiClient = twitterApiClient;
    mTabCount = tabCount;
  }

  @Override
  public Fragment getItem(int position) {
    Fragment fragment = null;
    switch (position) {
      case 0:
        Log.i(TAG, "getItem: " + "in tab0");
        fragment = HomeFragment.newInstance(mTwitterApiClient);
        break;
      case 1:
        Log.i(TAG, "getItem: " + "in tab1");
        fragment = TrendsFragment.newInstance();
        break;
      case 2:
        Log.i(TAG, "getItem: " + "in tab2");
        fragment = NotificationsFragment.newInstance();
        break;
      case 3:
        Log.i(TAG, "getItem: " + "in tab3");
        fragment = NotificationsFragment.newInstance();
        break;
    }
    return fragment;
  }

  @Override
  public int getCount() {
    return mTabCount;
  }
}
