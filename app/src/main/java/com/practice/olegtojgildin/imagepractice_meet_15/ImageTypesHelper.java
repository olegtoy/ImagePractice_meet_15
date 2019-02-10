package com.practice.olegtojgildin.imagepractice_meet_15;

/**
 * Created by olegtojgildin on 09/02/2019.
 */

import com.practice.olegtojgildin.imagepractice_meet_15.data.model.Hit;
import com.practice.olegtojgildin.imagepractice_meet_15.data.model.Image;

import java.util.ArrayList;
import java.util.List;

public final class ImageTypesHelper {

    private static final int TYPE_HTTP = 0;
    private static final int TYPE_PICASSO = 1;
    private static final int TYPE_GLIDE = 2;
    private static final int TYPE_FRESCO = 3;

    public static List<ImageItem> maptoImages(final List<Hit> imageHits) {
        final List<ImageItem> images = new ArrayList<>();
        for (int i = 0; i < imageHits.size(); i++) {
            images.add(maptoImage(i, imageHits.get(i)));
        }
        return images;
    }

    private static ImageItem maptoImage(final int position, final Hit hit) {

        final int type = position % ImageTypes.values().length;
        switch (type) {
            case TYPE_HTTP:
                return new Image(ImageTypes.HTTP, hit.getWebformatURL());
            case TYPE_PICASSO:
                return new Image(ImageTypes.PICASSO, hit.getWebformatURL());
            case TYPE_GLIDE:
                return new Image(ImageTypes.GLIDE, hit.getWebformatURL());
            case TYPE_FRESCO:
                return new Image(ImageTypes.FRESCO, hit.getWebformatURL());
            default:
                return null;
        }
    }
}