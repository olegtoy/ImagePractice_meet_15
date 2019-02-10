package com.practice.olegtojgildin.imagepractice_meet_15;

/**
 * Created by olegtojgildin on 09/02/2019.
 */

public enum ImageTypes {
    HTTP(0), PICASSO(1), GLIDE(2), FRESCO(3);
    private int mType;

    ImageTypes(int type) {
        this.mType = type;
    }

    public int getType() {
        return mType;
    }

}
