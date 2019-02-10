package com.practice.olegtojgildin.imagepractice_meet_15.binder;

import android.support.v7.widget.RecyclerView;

import com.practice.olegtojgildin.imagepractice_meet_15.data.model.Image;
import com.practice.olegtojgildin.imagepractice_meet_15.ImageItem;
import com.practice.olegtojgildin.imagepractice_meet_15.R;
import com.practice.olegtojgildin.imagepractice_meet_15.holder.PicassoImageHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by olegtojgildin on 09/02/2019.
 */

public class PicassoImageHolderBinder extends ImageHolderBinder {
    private final Image mImage;

    public PicassoImageHolderBinder(final ImageItem imageItem, final int viewType) {
        super(viewType);
        this.mImage=(Image)imageItem;

    }

    @Override
    public void bindViewHolder(RecyclerView.ViewHolder holder) {
        final PicassoImageHolder picassoHolder = (PicassoImageHolder) holder;

        Picasso.get()
                .load(mImage.getImageUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(picassoHolder.mImageView);

    }
}
