package com.example.movedatabase.ui.main;

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

import com.example.movedatabase.MainActivity;
import com.example.movedatabase.R;
import com.example.movedatabase.Results;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CastListAdapter extends RecyclerView.Adapter<CastListAdapter.MovieViewHolder>  {
    private   ArrayList<Cast> results = new ArrayList<>();
    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Cast> getResults() {

        return results;

    }

    public void setResults(ArrayList<Cast> results) {

        this.results = results;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CastListAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CastListAdapter.MovieViewHolder holder, int position) {
        Picasso.get().load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2"+results.get(position).getProfile_path()).into(holder.picture);
        holder.title.setText(results.get(position).getName());
        holder.realsedate.setText(results.get(position).getCharacter());


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
            rate.setVisibility(View.INVISIBLE);
            title=itemView.findViewById(R.id.mtitle);
            realsedate=itemView.findViewById(R.id.realasedate);

        }
    }

}



