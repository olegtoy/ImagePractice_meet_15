package com.practice.olegtojgildin.imagepractice_meet_15.factory;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.practice.olegtojgildin.imagepractice_meet_15.holder.PicassoImageHolder;
import com.practice.olegtojgildin.imagepractice_meet_15.R;

/**
 * Created by olegtojgildin on 09/02/2019.
 */

public class PicassoImageHolderFactory implements ImageHolderFactory {
    @Override
    public RecyclerView.ViewHolder createImageHolder(ViewGroup parent, LayoutInflater inflater) {
        View itemview=inflater.inflate(R.layout.item_image,parent,false);
        return new PicassoImageHolder(itemview);
    }
}
