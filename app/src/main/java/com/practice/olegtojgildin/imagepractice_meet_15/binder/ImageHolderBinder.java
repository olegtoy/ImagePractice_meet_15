package com.practice.olegtojgildin.imagepractice_meet_15.binder;

import android.support.v7.widget.RecyclerView;

/**
 * Created by olegtojgildin on 09/02/2019.
 */

public abstract class ImageHolderBinder {
    protected final int mViewType;

    public ImageHolderBinder(int viewType){
        this.mViewType=viewType;
    }
    public abstract void bindViewHolder(RecyclerView.ViewHolder holder);

    public int getViewType(){
        return mViewType;
    }
}
