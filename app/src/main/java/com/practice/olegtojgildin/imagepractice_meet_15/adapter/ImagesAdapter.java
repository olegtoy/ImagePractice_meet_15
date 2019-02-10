package com.practice.olegtojgildin.imagepractice_meet_15.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.practice.olegtojgildin.imagepractice_meet_15.ImageItem;
import com.practice.olegtojgildin.imagepractice_meet_15.ImageTypes;
import com.practice.olegtojgildin.imagepractice_meet_15.factory.FrescoImageHolderFactory;
import com.practice.olegtojgildin.imagepractice_meet_15.factory.GlideImageHolderFactory;
import com.practice.olegtojgildin.imagepractice_meet_15.factory.HttpImageHolderFactory;
import com.practice.olegtojgildin.imagepractice_meet_15.factory.ImageHolderFactory;
import com.practice.olegtojgildin.imagepractice_meet_15.factory.PicassoImageHolderFactory;
import com.practice.olegtojgildin.imagepractice_meet_15.binder.FrescoImageHolderBinder;
import com.practice.olegtojgildin.imagepractice_meet_15.binder.GlideImageHolderBinder;
import com.practice.olegtojgildin.imagepractice_meet_15.binder.HttpImageHolderBinder;
import com.practice.olegtojgildin.imagepractice_meet_15.binder.ImageHolderBinder;
import com.practice.olegtojgildin.imagepractice_meet_15.binder.PicassoImageHolderBinder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by olegtojgildin on 09/02/2019.
 */

public class ImagesAdapter extends RecyclerView.Adapter {
    private final List<ImageHolderBinder> mImageBinders;
    private SparseArray<ImageHolderFactory> mImageFactories;

    public ImagesAdapter() {
        mImageBinders = new ArrayList<>();
        initFactory();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        ImageHolderFactory factory = mImageFactories.get(i);
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return factory.createImageHolder(parent, inflater);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ImageHolderBinder binder = mImageBinders.get(i);
        if (binder != null)
            binder.bindViewHolder(viewHolder);
    }

    @Override
    public int getItemCount() {
        return mImageBinders.size();
    }

    public void initFactory() {
        mImageFactories = new SparseArray<>();
        mImageFactories.put(ImageTypes.HTTP.getType(), new HttpImageHolderFactory());
        mImageFactories.put(ImageTypes.PICASSO.getType(), new PicassoImageHolderFactory());
        mImageFactories.put(ImageTypes.FRESCO.getType(), new FrescoImageHolderFactory());
        mImageFactories.put(ImageTypes.GLIDE.getType(), new GlideImageHolderFactory());
    }

    @Override
    public int getItemViewType(int position) {
        return mImageBinders.get(position).getViewType();
    }

    public void setImages(List<ImageItem> items) {
        mImageBinders.clear();
        for (ImageItem item : items)
            mImageBinders.add(generateBinder(item));
        notifyDataSetChanged();
    }

    public ImageHolderBinder generateBinder(ImageItem item) {
        switch (item.getImageType()) {
            case HTTP:
                return new HttpImageHolderBinder(item, ImageTypes.HTTP.getType());
            case PICASSO:
                return new PicassoImageHolderBinder(item, ImageTypes.PICASSO.getType());
            case GLIDE:
                return new GlideImageHolderBinder(item, ImageTypes.GLIDE.getType());
            case FRESCO:
                return new FrescoImageHolderBinder(item, ImageTypes.FRESCO.getType());
            default:
                return null;
        }
    }
}
