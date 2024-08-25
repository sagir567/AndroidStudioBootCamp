package com.mastercoding.themovieapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.mastercoding.themovieapp.databinding.ActivityMovieScreenBinding;
import com.mastercoding.themovieapp.model.Movie;

public class MovieScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set up data binding
        ActivityMovieScreenBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_screen);

        // Get the movie object passed from the intent
        Movie movie = (Movie) getIntent().getSerializableExtra("movie");

        // Bind the movie object to the layout
        binding.setMovie(movie);

        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
