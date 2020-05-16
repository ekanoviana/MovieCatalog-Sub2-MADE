package com.nop.moviecatalogsubmission2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.nop.moviecatalogsubmission2.model.Movie;
import com.nop.moviecatalogsubmission2.model.Tv;

public class DetailTvActivity extends AppCompatActivity {

    public static final String EXTRA_TV = "Tv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv);

        Tv tv = getIntent().getParcelableExtra(EXTRA_TV);

        if (tv!=null){
            ImageView imgMovie = findViewById(R.id.img_detail_tv);
            imgMovie.setImageResource(tv.getImg());

            TextView tvTitle = findViewById(R.id.tv_title_tv);
            tvTitle.setText(tv.getTitle());

            TextView tvDesc = findViewById(R.id.tv_desc_tv);
            tvDesc.setText(tv.getDesc());
        }
    }
}
