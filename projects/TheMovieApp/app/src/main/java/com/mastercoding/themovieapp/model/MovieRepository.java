package com.mastercoding.themovieapp.model;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mastercoding.themovieapp.R;
import com.mastercoding.themovieapp.serviceApi.MovieApiService;
import com.mastercoding.themovieapp.serviceApi.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    public Application application;
    public ArrayList<Movie> movies = new ArrayList<Movie>();
    public MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<List<Movie>>();

    public MovieRepository(Application app) {
        this.application = app;
    }

    public MutableLiveData<List<Movie>> getMutableLiveData() {
        MovieApiService movieApiService = RetrofitInstance.getMovieService();
        Call<Results> call = movieApiService.getPopularMovies(application.getApplicationContext().getString(R.string.api_key));

        call.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                Results results = response.body();
                if(results != null && results.getResults()!=null){
                    movies = (ArrayList<Movie>) results.getResults();
                    mutableLiveData.setValue(movies);
                }
            }

            @Override
            public void onFailure(Call<Results> call, Throwable throwable) {

            }
        });
        return  mutableLiveData;
    }
}