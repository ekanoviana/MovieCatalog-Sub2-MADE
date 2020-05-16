package com.nop.moviecatalogsubmission2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nop.moviecatalogsubmission2.R;
import com.nop.moviecatalogsubmission2.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private OnItemClickCallBack onItemClickCallBack;

    public void setOnItemClickCallBack(OnItemClickCallBack onItemClickCallBack){
        this.onItemClickCallBack = onItemClickCallBack;
    }

    public interface OnItemClickCallBack{
        void onItemClick(Movie data);
    }

    private ArrayList<Movie> listMovie;

    public MovieAdapter(ArrayList<Movie> listMovieku){
        listMovie = listMovieku;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        final Movie movie = listMovie.get(position);

        holder.imgMovie.setImageResource(movie.getImg());
        holder.tvTitleMovie.setText(movie.getTitle());
        holder.tvDescMovie.setText(movie.getDesc());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallBack.onItemClick(movie);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{

        ImageView imgMovie;
        TextView tvTitleMovie, tvDescMovie;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            imgMovie = itemView.findViewById(R.id.img_movie);
            tvTitleMovie = itemView.findViewById(R.id.tv_name_movie);
            tvDescMovie = itemView.findViewById(R.id.tv_desc_movie);
        }
    }
}
