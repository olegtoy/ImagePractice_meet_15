package com.practice.olegtojgildin.imagepractice_meet_15.binder;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.practice.olegtojgildin.imagepractice_meet_15.data.model.Image;
import com.practice.olegtojgildin.imagepractice_meet_15.ImageItem;
import com.practice.olegtojgildin.imagepractice_meet_15.holder.FrescoImageHolder;
import com.practice.olegtojgildin.imagepractice_meet_15.holder.PicassoImageHolder;

import java.net.URI;

/**
 * Created by olegtojgildin on 09/02/2019.
 */

public class FrescoImageHolderBinder extends ImageHolderBinder {
    private final Image mImage;

    public FrescoImageHolderBinder(final ImageItem imageItem, final int viewType) {
        super(viewType);
        this.mImage=(Image)imageItem;
    }

    @Override
    public void bindViewHolder(RecyclerView.ViewHolder holder) {
        final FrescoImageHolder frescoImageHolder = (FrescoImageHolder) holder;
        frescoImageHolder.mImageView.setImageURI(mImage.getImageUrl());
    }
}
