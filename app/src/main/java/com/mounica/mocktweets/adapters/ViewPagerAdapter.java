package com.mounica.mocktweets.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.mounica.mocktweets.views.HomeFragment;
import com.mounica.mocktweets.views.MessagesFragment;
import com.mounica.mocktweets.views.NotificationsFragment;
import com.mounica.mocktweets.views.TrendsFragment;

/**
 * Implementation of the Adapter for the ViewPager. Tabs are set to 4 in the MainActivity.
 * New Fragment is loaded based on the tab_selector.xml chosen by the  user.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

  private static final String TAG = "ViewPagerAdapter";
  private final int mTabCount;

  public ViewPagerAdapter(FragmentManager fm, int tabCount) {
    super(fm);
    mTabCount = tabCount;
  }

  @Override
  public Fragment getItem(int position) {
    switch (position) {
      case 0:
        return HomeFragment.newInstance("home", null);
      case 1:
        return TrendsFragment.newInstance();
      case 2:
        return NotificationsFragment.newInstance();
      case 3:
        return MessagesFragment.newInstance();
      default:
        return HomeFragment.newInstance("home", null);
    }
  }

  @Override
  public int getCount() {
    return mTabCount;
  }
}
