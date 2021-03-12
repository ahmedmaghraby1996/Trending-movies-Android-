package com.example.movedatabase.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.movedatabase.MovieDetails;
import com.example.movedatabase.MovieListAdapter;
import com.example.movedatabase.MovieViewModel;
import com.example.movedatabase.R;

import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {
MovieViewModel movieViewModel;

    RecyclerView recyclerView;
    MovieListAdapter adapter;
    public  String CATGORY="top_rated";
    public static final String API_KEY="6c3b01ae1cd074d6f56568dd389f29c3";
    ProgressBar pb;
    Timer timer;

    public HomeFragment() {
        // Required empty public constructor
    }





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_home,container,false);
        movieViewModel= ViewModelProviders.of(this).get(MovieViewModel.class);
        movieViewModel.getTreding();
        pb=view.findViewById(R.id.pb);
    timer= new Timer();
    int counter=0;
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            pb.setProgress(counter);
            if(counter==10)
                timer.cancel();
        }
    };
        recyclerView=view.findViewById(R.id.mrecycler);
        adapter = new MovieListAdapter();
        adapter.setContext(getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        movieViewModel.movieMutableLiveData.observe(this, new Observer<MovieDetails>() {
            @Override
            public void onChanged(MovieDetails movieDetails) {
                adapter.notifyDataSetChanged();
                adapter.setResults(movieDetails.getResults());
                pb.setVisibility(View.INVISIBLE);
            }
        });










return view;
        }
}