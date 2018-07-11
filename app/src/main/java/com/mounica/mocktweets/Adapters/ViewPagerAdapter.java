package com.mounica.mocktweets.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.mounica.mocktweets.Activities.HomeFragment;
import com.twitter.sdk.android.core.TwitterApiClient;

/**
 * Implementation of the Adapter for the ViewPager. Tabs are set to 4 in the MainActivity.
 * New Fragment is loaded based on the tab chosen by the  user.
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
    switch (position) {
      case 0:
        return HomeFragment.newInstance(mTwitterApiClient);
      case 1:
      case 2:
      case 3:
      default:
        return HomeFragment.newInstance(mTwitterApiClient);
    }
  }

  @Override
  public int getCount() {
    return mTabCount;
  }
}
