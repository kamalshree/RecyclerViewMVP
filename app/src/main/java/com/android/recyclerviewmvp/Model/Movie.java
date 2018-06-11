package com.android.recyclerviewmvp.Model;

import java.util.List;

/**
 * Created by kamalshree on 6/10/2018.
 */

public class Movie {

    private List<MovieRes> results=null;

    public List<MovieRes> getResults() {
        return results;
    }

    public void setResults(List<MovieRes> results) {
        this.results = results;
    }
}
