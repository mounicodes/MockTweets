package com.mounica.mocktweets.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.mounica.mocktweets.views.HomeFragment;

public class ProfileViewPagerAdapter extends FragmentStatePagerAdapter {

  private int mTabCount = 0;
  private String mScreenName = null;

  public ProfileViewPagerAdapter(FragmentManager fm, int tabCount, String userScreenName) {
    super(fm);
    mTabCount = tabCount;
    mScreenName = userScreenName;
  }

  @Override
  public Fragment getItem(int position) {
    switch (position) {
      case 0:
        Bundle bundle = new Bundle();
        bundle.putString("screen_name",mScreenName);
        return HomeFragment.newInstance("profile",bundle);
      case 1:
      case 2:
      case 3:
      default:
        return null;
    }
  }

  @Override
  public int getCount() {
    return mTabCount;
  }
}
