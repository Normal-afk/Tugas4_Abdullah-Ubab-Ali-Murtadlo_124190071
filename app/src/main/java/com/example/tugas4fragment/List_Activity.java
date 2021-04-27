package com.example.tugas4fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class List_Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<MovieModel> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_);

        recyclerView = findViewById(R.id.rcv_list);
        list = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        list.addAll(MovieData.getMovieListData());

        showRecyclerList();
    }

    private void showRecyclerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        MovieAdapter movieAdapter = new MovieAdapter(this, 1);
        movieAdapter.setMovieModels(list);
        recyclerView.setAdapter(movieAdapter);
    }
}