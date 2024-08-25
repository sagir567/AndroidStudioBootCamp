package com.mastercoding.themovieapp.View;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.mastercoding.themovieapp.R;
import com.mastercoding.themovieapp.databinding.MovieListItemLayoutBinding;
import com.mastercoding.themovieapp.itemClickListener;
import com.mastercoding.themovieapp.model.Movie;
import com.mastercoding.themovieapp.model.MovieRepository;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MovieAdapter  extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private Context context;
    private ArrayList<Movie> movies = new ArrayList<Movie>();
    public itemClickListener clickListener;
    public MovieAdapter(Context context, ArrayList<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieListItemLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.movie_list_item_layout,
                parent,
                false);
        return new MovieViewHolder(binding);
    }

    public void setClickListener(itemClickListener clickListener){
        this.clickListener = clickListener;
    }
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.movieListItemBinding.setMovie(movie);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder  {
        private MovieListItemLayoutBinding movieListItemBinding;

        public MovieViewHolder(MovieListItemLayoutBinding movieListItemLayoutBinding) {
            super(movieListItemLayoutBinding.getRoot());
            this.movieListItemBinding = movieListItemLayoutBinding;


            movieListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(clickListener!= null){
                        clickListener.OnMovieClick(view,getAdapterPosition());
                    }
                }
            });
        }
    }
}
