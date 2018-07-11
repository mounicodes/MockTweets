package com.mounica.mocktweets.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mounica.mocktweets.R;

/**
 * To be implemented in next phase
 */

public class NotificationsFragment extends Fragment {

  public static NotificationsFragment newInstance() {

    Bundle args = new Bundle();

    NotificationsFragment fragment = new NotificationsFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_notifications, null);
    return view;
  }
}
