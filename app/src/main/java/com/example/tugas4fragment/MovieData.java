package com.example.tugas4fragment;

import java.util.ArrayList;

public class MovieData {
    private static String[] title = new String[] { "Avengers: Infinity War", "The Lord of The Rings", "Harry Potter",
                            "Finding Nemo", "UP", "Charlie and The Chocolate Factory"};
    private static int[] thumbnail = new int[] { R.drawable.infinity_war, R.drawable.loring, R.drawable.heri_potter,
                             R.drawable.nemo, R.drawable.up, R.drawable.charlie };

    public static ArrayList<MovieModel> getMovieListData(){
        MovieModel movieModel = null;
        ArrayList<MovieModel> list = new ArrayList<>();

        for (int i = 0; i < title.length; i++){
            movieModel = new MovieModel();
            movieModel.setJudul(title[i]);
            movieModel.setPoster(thumbnail[i]);
            list.add(movieModel);
        }
        return list;
    }

}
