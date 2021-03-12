package com.example.movedatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.movedatabase.ui.main.CastListAdapter;
import com.example.movedatabase.ui.main.Credits;
import com.example.movedatabase.ui.main.HomeFragment;
import com.example.movedatabase.ui.main.Video;
import com.squareup.picasso.Picasso;

import java.net.URI;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Url;

public class MainActivity extends AppCompatActivity {
    WebView tralier ;
    TextView title,rating,content;
    RecyclerView cast;
    ImageView pic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        tralier= findViewById(R.id.video);
        title=findViewById(R.id.dtitle);
        content=findViewById(R.id.content);
        cast=findViewById(R.id.cast);
        pic=findViewById(R.id.dposter);
        rating=findViewById(R.id.drating);
        tralier.getSettings().setJavaScriptEnabled(true);
        tralier.setWebViewClient(new WebViewClient());


        Results result = (Results) getIntent().getSerializableExtra("result");
        title.setText(result.getTitle());
        content.setText(result.getOverview());
        rating.setText(result.getVote_average());
        Picasso.get().load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2"+result.getPoster_path()).into(pic);
        MovieViewModel movieViewModel = new MovieViewModel();
        movieViewModel.getTralier(result.getMedia_type(),String.valueOf(result.getId()), HomeFragment.API_KEY);
        movieViewModel.videoMutableLiveData.observe(this, new Observer<Video>() {
            @Override
            public void onChanged(Video video) {

                tralier.loadData("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/"+video.getResults().get(0).getKey()+"\" frameborder=\"0\" allowfullscreen></iframe>","text/html","utf-8");


            }
        } );
     CastListAdapter adapter = new CastListAdapter();
        adapter.setContext(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        cast.setLayoutManager(layoutManager);
        cast.setItemAnimator(new DefaultItemAnimator());
        cast.setAdapter(adapter);
movieViewModel.getCredits(result.getMedia_type(),String.valueOf(result.getId()), HomeFragment.API_KEY);
movieViewModel.creditsMutableLiveData.observe(this, new Observer<Credits>() {
    @Override
    public void onChanged(Credits credits) {
adapter.setResults(credits.getCast());
adapter.notifyDataSetChanged();
    }
});




}}