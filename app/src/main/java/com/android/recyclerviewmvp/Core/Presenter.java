package com.android.recyclerviewmvp.Core;

import android.content.Context;

import com.android.recyclerviewmvp.Model.MovieRes;

import java.util.List;

/**
 * Created by kamalshree on 6/10/2018.
 */

public class Presenter implements GetDataContract.Presenter, GetDataContract.onGetDataListener{

    private GetDataContract.View mGetDataView;
    private Intractor mIntractor;


    public Presenter(GetDataContract.View mGetDataView){
        this.mGetDataView = mGetDataView;
        mIntractor = new Intractor(this);
    }
    @Override
    public void getDataFromURL(Context context, String url) {
        mIntractor.initRetrofitCall(context,url);
    }

    @Override
    public void onSuccess(String message, List<MovieRes> list) {
        mGetDataView.onSuccess(message,list);
    }

    @Override
    public void onFailure(String message) {
        mGetDataView.onFailure(message);
    }
}
