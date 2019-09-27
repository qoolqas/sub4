package com.qoolqas.moviesql.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.qoolqas.moviesql.Adapter.MovieAdapter;
import com.qoolqas.moviesql.Data.Movie;
import com.qoolqas.moviesql.Database.FavoriteHelper;
import com.qoolqas.moviesql.R;
import com.qoolqas.moviesql.VM.MovieModel;

import java.util.ArrayList;

public class FavoriteMovie extends Fragment {
    private MovieAdapter movieAdapter;
    private RecyclerView recyclerView;
    private FavoriteHelper favoriteHelper;
    private ArrayList<Movie> movie;

    public FavoriteMovie() {
    }

    View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_favorite_movie, container, false);
//
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        favoriteHelper = FavoriteHelper.getInstance(view.getContext());
        favoriteHelper.open();

        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        movieAdapter = new MovieAdapter(view.getContext());


    }

    @Override
    public void onResume() {
        super.onResume();
        FavoriteHelper item = new FavoriteHelper(getContext());
        item.open();
        movie = favoriteHelper.getAllMovie();
        Log.d("list", String.valueOf(movie));
        movieAdapter.setMlist(movie);
        movieAdapter.setMovie(movie);
        recyclerView.setAdapter(movieAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        favoriteHelper.close();
    }

}
