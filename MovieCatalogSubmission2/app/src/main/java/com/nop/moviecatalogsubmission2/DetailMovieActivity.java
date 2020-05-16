package com.nop.moviecatalogsubmission2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.nop.moviecatalogsubmission2.model.Movie;

import org.w3c.dom.Text;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "Movie";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        if (movie!=null){
            ImageView imgMovie = findViewById(R.id.img_detail_movie);
            imgMovie.setImageResource(movie.getImg());

            TextView tvTitle = findViewById(R.id.tv_title_movie);
            tvTitle.setText(movie.getTitle());

            TextView tvDesc = findViewById(R.id.tv_desc_movie);
            tvDesc.setText(movie.getDesc());
        }
    }
}
