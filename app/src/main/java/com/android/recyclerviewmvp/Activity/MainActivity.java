package com.android.recyclerviewmvp.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.recyclerviewmvp.Adapter.MovieAdapter;
import com.android.recyclerviewmvp.Core.GetDataContract;
import com.android.recyclerviewmvp.Core.Presenter;
import com.android.recyclerviewmvp.Model.MovieRes;
import com.android.recyclerviewmvp.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements GetDataContract.View  {

    private Presenter mPresenter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    MovieAdapter movieAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new Presenter(this);
        mPresenter.getDataFromURL(getApplicationContext(), "");
        recyclerView = (RecyclerView)findViewById(R.id.rv_myrecyclerview);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onSuccess(String message, List<MovieRes> list) {
        movieAdapter = new MovieAdapter(getApplicationContext(), list);
        recyclerView.setAdapter(movieAdapter);

    }

    @Override
    public void onFailure(String message) {
        Log.d("Status",message);
    }
}
