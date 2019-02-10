package com.practice.olegtojgildin.imagepractice_meet_15.data.model;

import com.practice.olegtojgildin.imagepractice_meet_15.ImageItem;
import com.practice.olegtojgildin.imagepractice_meet_15.ImageTypes;

/**
 * Created by olegtojgildin on 09/02/2019.
 */

public class Image implements ImageItem {

    private ImageTypes mImageTypes;
    private String mImageURL;

    public Image(ImageTypes types, String url) {
        this.mImageTypes = types;
        this.mImageURL = url;
    }

    @Override
    public ImageTypes getImageType() {
        return mImageTypes;
    }

    public String getImageUrl() {
        return mImageURL;
    }

}
