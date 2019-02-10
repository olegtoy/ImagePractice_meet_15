package com.practice.olegtojgildin.imagepractice_meet_15.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.practice.olegtojgildin.imagepractice_meet_15.R;

/**
 * Created by olegtojgildin on 09/02/2019.
 */

public class HttpImageHolder extends RecyclerView.ViewHolder{
    private ImageView mImageView;

    public ImageView getImageView(){
        return mImageView;
    }

    public HttpImageHolder(View itemView){
        super(itemView);
        mImageView=itemView.findViewById(R.id.image_view);
    }
}
