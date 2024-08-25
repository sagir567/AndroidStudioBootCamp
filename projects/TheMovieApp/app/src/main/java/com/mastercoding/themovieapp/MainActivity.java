package com.mastercoding.themovieapp;

import static com.mastercoding.themovieapp.BR.movie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.mastercoding.themovieapp.View.MovieAdapter;
import com.mastercoding.themovieapp.ViewModel.MainActivityViewModel;
import com.mastercoding.themovieapp.databinding.ActivityMainBinding;
import com.mastercoding.themovieapp.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  itemClickListener{

    private ArrayList<Movie> movies;
    private RecyclerView recyclerView;
    private MainActivityViewModel viewModel;
    private MovieAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        binding =  DataBindingUtil.setContentView(this,R.layout.activity_main);

        movies = new ArrayList<Movie>();
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        getPopularMovies();

        swipeRefreshLayout = binding.swipeLayout;
        swipeRefreshLayout.setColorSchemeResources(R.color.black);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPopularMovies();
            }
        });



    }

    public void getPopularMovies(){
        viewModel.getMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> LiveDataMovies) {
                movies = (ArrayList<Movie>) LiveDataMovies;
                displayMoviesOnRecyclerView();
            }
        });
    }
    public void displayMoviesOnRecyclerView(){
        recyclerView = binding.recyclerview;
        adapter = new MovieAdapter(this,movies);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new GridLayoutManager(this ,2));

        adapter.notifyDataSetChanged();
    }

    @Override
    public void OnMovieClick(View v, int pos) {
        Movie movie = movies.get(pos);
        Intent intent = new Intent(MainActivity.this,MovieScreenActivity.class);
        intent.putExtra("movie",movie);

        startActivity(intent);

    }
}