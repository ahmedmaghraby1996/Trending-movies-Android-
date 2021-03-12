package com.example.movedatabase;

import com.example.movedatabase.ui.main.Credits;
import com.example.movedatabase.ui.main.Video;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieClient {
    private  static final  String BASE_URL="https://api.themoviedb.org";
    private MovieInterface movieInterface;
    private static MovieClient INSTANCE;
//    public  String CATGORY="top_rated";
//    public  String API_KEY="6c3b01ae1cd074d6f56568dd389f29c3";

    public static MovieClient getINSTANCE() {
        if(null ==INSTANCE)
            INSTANCE= new MovieClient();
        return INSTANCE;
    }

    public MovieClient(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        movieInterface = retrofit.create(MovieInterface.class);


    }
    public Call<MovieDetails> getMovies(String CATGORY,String API_KEY){
        return movieInterface.getMovies(CATGORY,API_KEY);
    }

    public Call<MovieDetails> getTrending(){
        return movieInterface.getTrending();
    }
    public  Call<Video> getTralier(String type,String id,String apikey){
        return movieInterface.getVideo(type,id,apikey);
    }
    public  Call<Credits> getCredits(String type, String id,String apikey){
        return movieInterface.getCredits(type,id,apikey);
    }
}
