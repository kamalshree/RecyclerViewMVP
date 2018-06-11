package com.android.recyclerviewmvp.Core;

import android.content.Context;

import com.android.recyclerviewmvp.Model.MovieRes;

import java.util.List;

/**
 * Created by kamalshree on 6/10/2018.
 */

public interface GetDataContract {

    interface View{
        void onSuccess(String message, List<MovieRes> list);
        void onFailure(String message);
    }

    interface Presenter{
        void getDataFromURL(Context context, String url);
    }

    interface Interactor{
        void initRetrofitCall(Context context, String url);
    }

    interface onGetDataListener {
        void onSuccess(String message, List<MovieRes> list);
        void onFailure(String message);
    }
}
