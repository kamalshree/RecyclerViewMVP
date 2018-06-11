package com.android.recyclerviewmvp.Model;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by kamalshree on 6/10/2018.
 */

public interface AllMovieResponse {
    // Generate an Api key on https://api.themoviedb.org and add it below.
    @GET("3/discover/movie?sort_by=popularity.desc&api_key=****")
    Call<Movie> getResults();
}
