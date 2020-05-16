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
import com.nop.moviecatalogsubmission2.model.Tv;

import java.util.ArrayList;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.TvViewHolder> {
    private TvAdapter.OnItemClickCallBack onItemClickCallBack;

    public void setOnItemClickCallBack(TvAdapter.OnItemClickCallBack onItemClickCallBack){
        this.onItemClickCallBack = onItemClickCallBack;
    }

    public interface OnItemClickCallBack{
        void onItemClick(Tv data);
    }

    private ArrayList<Tv> listTv;

    public TvAdapter(ArrayList<Tv> listTvku){
        listTv = listTvku;
    }

    @NonNull
    @Override
    public TvAdapter.TvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_show, parent, false);
        return new TvAdapter.TvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvAdapter.TvViewHolder holder, int position) {
        final Tv tv = listTv.get(position);

        holder.imgTv.setImageResource(tv.getImg());
        holder.tvTitleTv.setText(tv.getTitle());
        holder.tvDescTv.setText(tv.getDesc());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallBack.onItemClick(tv);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTv.size();
    }

    public class TvViewHolder extends RecyclerView.ViewHolder{

        ImageView imgTv;
        TextView tvTitleTv, tvDescTv;

        public TvViewHolder(@NonNull View itemView) {
            super(itemView);

            imgTv = itemView.findViewById(R.id.img_show_list);
            tvTitleTv = itemView.findViewById(R.id.name_show_list);
            tvDescTv = itemView.findViewById(R.id.desc_show_list);
        }
    }
}
