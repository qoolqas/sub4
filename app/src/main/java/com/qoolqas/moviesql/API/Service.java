package com.qoolqas.moviesql.API;

import com.qoolqas.moviesql.Data.Movie;
import com.qoolqas.moviesql.Data.TvShow;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {
    @GET("movie")
    Call<Movie> getMovie(@Query("api_key") String apiKey);

    @GET("tv")
    Call<TvShow> getShow(@Query("api_key") String apiKey);
}
