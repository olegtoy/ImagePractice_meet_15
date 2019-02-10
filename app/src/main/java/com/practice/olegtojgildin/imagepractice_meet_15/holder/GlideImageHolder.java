package com.practice.olegtojgildin.imagepractice_meet_15.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.practice.olegtojgildin.imagepractice_meet_15.R;

/**
 * Created by olegtojgildin on 09/02/2019.
 */

public class GlideImageHolder extends RecyclerView.ViewHolder{
    public ImageView mImageView;

    public GlideImageHolder(View itemView){
        super(itemView);
        mImageView=itemView.findViewById(R.id.image_view);
    }
}
