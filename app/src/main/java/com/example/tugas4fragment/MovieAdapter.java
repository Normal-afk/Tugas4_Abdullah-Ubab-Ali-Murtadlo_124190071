package com.example.tugas4fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

//    private HomeFragment homeFragment;
//    private ListFragment listFragment;
    private Context context;
    private ArrayList<MovieModel> movieModels;
    private int orientasi = 0;

//    public MovieAdapter(HomeFragment homeFragment) {
//        this.homeFragment = homeFragment;
//        i = 0;
//    }

    public MovieAdapter(Context context, int orientasi) {
        this.context = context;
        this.orientasi = orientasi;
    }

//    public MovieAdapter(ListFragment listFragment) {
//        this.listFragment = listFragment;
//        i = 1;
//    }

    public ArrayList<MovieModel> getMovieModels() {
        return movieModels;
    }

    public void setMovieModels(ArrayList<MovieModel> movieModels) {
        this.movieModels = movieModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemRow = null;
        if ( orientasi == 1){
            itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie_verti,viewGroup,false);
        }
        else itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie_hori,viewGroup,false);

        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if ( orientasi == 1){
            Glide.with(context).load(getMovieModels().get(position).getPoster()).into(holder.ivPoster);
        }
        else Glide.with(context).load(getMovieModels().get(position).getPoster()).into(holder.ivPoster);

        holder.tvJudul.setText(getMovieModels().get(position).getJudul());
    }

    @Override
    public int getItemCount() {
        return getMovieModels().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPoster;
        private TextView tvJudul;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPoster = itemView.findViewById(R.id.iv_poster);
            tvJudul = itemView.findViewById(R.id.tv_judul);
        }
    }
}
