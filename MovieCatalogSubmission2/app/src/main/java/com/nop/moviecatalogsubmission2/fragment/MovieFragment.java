package com.nop.moviecatalogsubmission2.fragment;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nop.moviecatalogsubmission2.DetailMovieActivity;
import com.nop.moviecatalogsubmission2.R;
import com.nop.moviecatalogsubmission2.adapter.MovieAdapter;
import com.nop.moviecatalogsubmission2.model.Movie;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

//    private ArrayList<Movie> list = new ArrayList<>();


    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rvMovie = view.findViewById(R.id.rv_movie);
        rvMovie.setLayoutManager(new LinearLayoutManager(view.getContext()));

        MovieAdapter movieAdapter = new MovieAdapter(getMovieList());
        rvMovie.setAdapter(movieAdapter);

        movieAdapter.setOnItemClickCallBack(new MovieAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClick(Movie data) {
                view.getContext().startActivity(new Intent(view.getContext(), DetailMovieActivity.class)
                        .putExtra(DetailMovieActivity.EXTRA_MOVIE, data));
            }
        });
    }

    private ArrayList<Movie> getMovieList() {
        TypedArray dataImage = getResources().obtainTypedArray(R.array.data_photo_movies);
        String[] dataTitle = getResources().getStringArray(R.array.data_name_movies);
        String[] dataDesc = getResources().getStringArray(R.array.data_desc_movies);

        ArrayList<Movie> listMovie = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            Movie movie = new Movie();
            movie.setImg(dataImage.getResourceId(i, -1));
            movie.setTitle(dataTitle[i]);
            movie.setDesc(dataDesc[i]);
            listMovie.add(movie);
        }
        return listMovie;
    }
}
