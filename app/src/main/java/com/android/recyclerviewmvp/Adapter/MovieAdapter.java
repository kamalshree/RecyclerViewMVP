package com.android.recyclerviewmvp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.recyclerviewmvp.Core.Presenter;
import com.android.recyclerviewmvp.Model.MovieRes;
import com.android.recyclerviewmvp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kamalshree on 6/10/2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    private Context context;
    private List<MovieRes> list = new ArrayList<>();
    public MovieAdapter(Context context, List<MovieRes> list){
        this.context = context;
        this.list = list;
    }
    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MovieAdapter.MyViewHolder holder, final int position) {
        holder.tvMovieName.setText(list.get(position).getTitle());
        holder.tvMovieName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Toast.makeText(context, list.get(position).getTitle(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvMovieName;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvMovieName = (TextView)itemView.findViewById(R.id.tv_listitems);
        }
    }
}