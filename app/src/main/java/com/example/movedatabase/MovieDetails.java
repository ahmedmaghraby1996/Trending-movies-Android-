package com.example.movedatabase;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieDetails {

    private float page;
    ArrayList< Results > results = new ArrayList <> ();
    private float total_pages;
    private float total_results;

    public ArrayList<Results> getResults() {
        return results;
    }

    public void setResults(ArrayList<Results> results) {
        this.results = results;
    }

// Getter Methods

    public float getPage() {
        return page;
    }

    public float getTotal_pages() {
        return total_pages;
    }

    public float getTotal_results() {
        return total_results;
    }

    // Setter Methods

    public void setPage(float page) {
        this.page = page;
    }

    public void setTotal_pages(float total_pages) {
        this.total_pages = total_pages;
    }

    public void setTotal_results(float total_results) {
        this.total_results = total_results;
    }
}
