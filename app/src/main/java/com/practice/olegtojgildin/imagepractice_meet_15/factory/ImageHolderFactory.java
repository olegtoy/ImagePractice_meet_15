package com.practice.olegtojgildin.imagepractice_meet_15.factory;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by olegtojgildin on 09/02/2019.
 */

public interface ImageHolderFactory {
    RecyclerView.ViewHolder createImageHolder(ViewGroup parent, LayoutInflater inflater);
}
