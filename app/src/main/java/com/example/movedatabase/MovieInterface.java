package com.example.movedatabase;

import com.example.movedatabase.ui.main.Credits;
import com.example.movedatabase.ui.main.Video;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieInterface {
    @GET("/3/movie/{category}")
    public Call<MovieDetails> getMovies(
            @Path("category") String CATGORY,
            @Query("api_key") String API_KEY

    );
    @GET("/3/trending/all/day?api_key=6c3b01ae1cd074d6f56568dd389f29c3")
    public Call<MovieDetails> getTrending();
    @GET("/3/{type}/{id}/videos")
    public Call<Video>getVideo(
            @Path("type")String type,
            @Path("id")String id,
            @Query("api_key") String API_KEY
    );
    @GET("/3/{type}/{id}/credits")
    public Call<Credits> getCredits(
            @Path("type") String type,
            @Path("id") String id,
            @Query("api_key") String API_KEY
    );
}
