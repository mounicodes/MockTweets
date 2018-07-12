package com.mounica.mocktweets.adapters;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mounica.mocktweets.R;
import com.mounica.mocktweets.models.Trend;
import java.util.ArrayList;
import java.util.List;

public class TrendsAdapter extends RecyclerView.Adapter<TrendsAdapter.TrendViewHolder> {

  private List<Trend> mTrendsList = new ArrayList<>();

  public TrendsAdapter(List<Trend> trendsList) {
    mTrendsList = trendsList;
  }

  @Override
  public TrendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.holder_rv_trends, parent, true);
    return new TrendViewHolder(view);
  }

  @Override
  public void onBindViewHolder(TrendViewHolder holder, int position) {
    Trend trend = mTrendsList.get(position);
    holder.mCountNumber.setText(String.valueOf(position));
    holder.mTrendName.setText(trend.getName());
    holder.mTweetCount.setText(String.valueOf(trend.getTweetVolume()) + R.string.tweets);
  }

  @Override
  public int getItemCount() {
    return mTrendsList.size();
  }

  public class TrendViewHolder extends ViewHolder {

    private TextView mCountNumber;
    private TextView mTrendName;
    private TextView mTweetCount;

    public TrendViewHolder(View itemView) {
      super(itemView);
      mCountNumber = itemView.findViewById(R.id.text_count_number);
      mTrendName = itemView.findViewById(R.id.text_trend_name);
      mTweetCount = itemView.findViewById(R.id.text_number_of_tweets);
    }
  }

}
