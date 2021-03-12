package com.example.movedatabase;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.movedatabase.ui.main.Credits;
import com.example.movedatabase.ui.main.Video;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieViewModel  extends ViewModel {
  public   MutableLiveData <MovieDetails> movieMutableLiveData = new MutableLiveData<>();
    public   MutableLiveData <Video> videoMutableLiveData = new MutableLiveData<>();
    public   MutableLiveData <Credits> creditsMutableLiveData = new MutableLiveData<>();
    public  void  getMovies(String catgory, String apikey){
        MovieClient.getINSTANCE().getMovies(catgory,apikey).enqueue(new Callback<MovieDetails>() {
            @Override
            public void onResponse(Call<MovieDetails> call, Response<MovieDetails> response) {

                    movieMutableLiveData.setValue(response.body());
//                Log.d("xxx", "onResponse: " +movieMutableLiveData.getValue().getPage()+"");
//                Log.d("xxx", "onResponse: "+"https://api.themoviedb.org/3/movie/"+response.body().getResults().get(1).getPoster_path());
                Log.d("xxx", "onResponse: sucsess");
            }

            @Override
            public void onFailure(Call<MovieDetails> call, Throwable t) {
                Log.d("xxx", "onResponse: x"+t.getMessage());

            }
        });
    }

    public void getTreding(){
        MovieClient.getINSTANCE().getTrending().enqueue(new Callback<MovieDetails>() {
            @Override
            public void onResponse(Call<MovieDetails> call, Response<MovieDetails> response) {
                movieMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<MovieDetails> call, Throwable t) {

            }
        });
    }
    public void getTralier(String type,String id ,String apikey){
        MovieClient.getINSTANCE().getTralier(type,id ,apikey).enqueue(new Callback<Video>() {
            @Override
            public void onResponse(Call<Video> call, Response<Video> response) {
                videoMutableLiveData.setValue(response.body());

            }

            @Override
            public void onFailure(Call<Video> call, Throwable t) {
            }
        });

    }
    public void getCredits(String type,String id ,String apikey){
        MovieClient.getINSTANCE().getCredits(type,id,apikey).enqueue(new Callback<Credits>() {
            @Override
            public void onResponse(Call<Credits> call, Response<Credits> response) {
                creditsMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Credits> call, Throwable t) {

            }
        });
    }
}
