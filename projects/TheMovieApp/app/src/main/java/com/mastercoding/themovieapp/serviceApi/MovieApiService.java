package com.mastercoding.themovieapp.serviceApi;

import com.mastercoding.themovieapp.model.Results;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {


    @GET("movie/popular")
    Call<Results> getPopularMovies(@Query("api_key") String apiKey);



}
