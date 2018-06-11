package com.android.recyclerviewmvp.Core;

import android.content.Context;
import android.util.Log;

import com.android.recyclerviewmvp.Model.AllMovieResponse;
import com.android.recyclerviewmvp.Model.Movie;
import com.android.recyclerviewmvp.Model.MovieRes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kamalshree on 6/10/2018.
 */

public class Intractor implements GetDataContract.Interactor {

    private GetDataContract.onGetDataListener mOnGetDatalistener;
    List<MovieRes> allmovies = new ArrayList<>();
    List<String> allMoviesData = new ArrayList<>();

    public Intractor(GetDataContract.onGetDataListener mOnGetDatalistener){
        this.mOnGetDatalistener = mOnGetDatalistener;
    }
    @Override
    public void initRetrofitCall(Context context, String url) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        AllMovieResponse request = retrofit.create(AllMovieResponse.class);
        retrofit2.Call<Movie> call = request.getResults();
        call.enqueue(new retrofit2.Callback<Movie>() {
            @Override
            public void onResponse(retrofit2.Call<Movie> call, retrofit2.Response<Movie> response) {
                Movie jsonResponse = response.body();
                allmovies = jsonResponse.getResults();
                for(int i=0;i<allmovies.size();i++){
                    allMoviesData.add(allmovies.get(i).getTitle());
                }
                Log.d("Data", "Refreshed");
                mOnGetDatalistener.onSuccess("List Size: " + allMoviesData.size(), allmovies);



            }
            @Override
            public void onFailure(retrofit2.Call<Movie> call, Throwable t) {
                Log.v("Error",t.getMessage());
                mOnGetDatalistener.onFailure(t.getMessage());
            }
        });
    }
}
