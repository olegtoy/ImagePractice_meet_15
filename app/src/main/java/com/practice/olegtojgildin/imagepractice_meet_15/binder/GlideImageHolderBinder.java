package com.practice.olegtojgildin.imagepractice_meet_15.binder;

import android.support.v7.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.practice.olegtojgildin.imagepractice_meet_15.GlideApp;
import com.practice.olegtojgildin.imagepractice_meet_15.data.model.Image;
import com.practice.olegtojgildin.imagepractice_meet_15.ImageItem;
import com.practice.olegtojgildin.imagepractice_meet_15.holder.GlideImageHolder;

/**
 * Created by olegtojgildin on 09/02/2019.
 */

public class GlideImageHolderBinder extends ImageHolderBinder {
    private final Image mImage;

    public GlideImageHolderBinder(final ImageItem imageItem, final int viewType) {
        super(viewType);
        this.mImage = (Image) imageItem;
    }

    @Override
    public void bindViewHolder(final RecyclerView.ViewHolder holder) {
        final GlideImageHolder glideHolder = (GlideImageHolder) holder;

        GlideApp.with(holder.itemView.getContext())
                .load(mImage.getImageUrl())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(glideHolder.mImageView);

    }
}

