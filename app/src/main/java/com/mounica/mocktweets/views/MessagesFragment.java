package com.mounica.mocktweets.views;

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
public class MessagesFragment extends Fragment {

  public static MessagesFragment newInstance() {
    MessagesFragment fragment = new MessagesFragment();
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
    View view = inflater.inflate(R.layout.fragment_messages, null);
    return view;
  }
}
