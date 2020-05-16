package com.nop.moviecatalogsubmission2.fragment;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nop.moviecatalogsubmission2.DetailMovieActivity;
import com.nop.moviecatalogsubmission2.DetailTvActivity;
import com.nop.moviecatalogsubmission2.R;
import com.nop.moviecatalogsubmission2.adapter.MovieAdapter;
import com.nop.moviecatalogsubmission2.adapter.TvAdapter;
import com.nop.moviecatalogsubmission2.model.Movie;
import com.nop.moviecatalogsubmission2.model.Tv;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvFragment extends Fragment {


    public TvFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rvTv = view.findViewById(R.id.rv_tv);
        rvTv.setLayoutManager(new LinearLayoutManager(view.getContext()));

        TvAdapter tvAdapter = new TvAdapter(getTvList());
        rvTv.setAdapter(tvAdapter);

        tvAdapter.setOnItemClickCallBack(new TvAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClick(Tv data) {
                view.getContext().startActivity(new Intent(view.getContext(), DetailTvActivity.class)
                        .putExtra(DetailTvActivity.EXTRA_TV, data));
            }
        });
    }

    private ArrayList<Tv> getTvList() {
        TypedArray dataImage = getResources().obtainTypedArray(R.array.data_photo_show);
        String[] dataTitle = getResources().getStringArray(R.array.data_name_show);
        String[] dataDesc = getResources().getStringArray(R.array.data_desc_show);

        ArrayList<Tv> listTv = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            Tv tv = new Tv();
            tv.setImg(dataImage.getResourceId(i, -1));
            tv.setTitle(dataTitle[i]);
            tv.setDesc(dataDesc[i]);
            listTv.add(tv);
        }
        return listTv;
    }

}
