package com.mounica.mocktweets.network;

import com.mounica.mocktweets.models.Trend;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TwitterInterface {

  @GET ("trends/place.json")
  Call<List<Trend>> getTrends(@Query("id") Integer woeid);

}
