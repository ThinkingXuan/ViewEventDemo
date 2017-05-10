package com.you.vieweventdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by youxuan on 2017/4/29 0029.
 */

public class adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;

    public adapter(Context context) {
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = new myViewHolder(LinearLayout.inflate(mContext,R.layout.iten,null));

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 100;
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        public myViewHolder(View itemView) {
            super(itemView);
        }
    }
}
