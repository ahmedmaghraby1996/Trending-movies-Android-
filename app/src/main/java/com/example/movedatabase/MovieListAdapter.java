package com.example.movedatabase;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>  {
    private   ArrayList<Results> results = new ArrayList<>();
    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Results> getResults() {

        return results;

    }

    public void setResults(ArrayList<Results> results) {

        this.results = results;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieListAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListAdapter.MovieViewHolder holder, int position) {

        String rating=results.get(position).getVote_average(),rdate=results.get(position).getRelease_date(),mtitle=results.get(position).getTitle();
        if(rdate==null)
            rdate="comming soon";
        if(rating==null)
            rating="";
        if(mtitle==null)
            mtitle=results.get(position).getOriginal_name();
        holder.rate.setText(rating);
        holder.title.setText(mtitle);
        holder.realsedate.setText(rdate);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(results.get(position));
            }
        });


        Log.d("xxx", "onBindViewHolder: "+"https://www.themoviedb.org/t/p/w600_and_h900_bestv2"+results.get(position).getPoster_path());
        Picasso.get().load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2"+results.get(position).getPoster_path()).into(holder.picture);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout container;
        ImageView picture;
        TextView rate,title,realsedate;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            container=itemView.findViewById(R.id.container);
            picture = itemView.findViewById(R.id.moviepic);
            rate=itemView.findViewById(R.id.rate);
            title=itemView.findViewById(R.id.mtitle);
            realsedate=itemView.findViewById(R.id.realasedate);

        }
    }
    public void startActivity(Results results) {
        Intent intent = new Intent(getContext(), MainActivity.class);
        intent.putExtra("result",results);


        getContext().startActivity(intent);
    }
}



