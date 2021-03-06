package com.practice.olegtojgildin.imagepractice_meet_15.data;

import com.google.gson.annotations.SerializedName;
import com.practice.olegtojgildin.imagepractice_meet_15.data.model.Hit;

import java.util.List;

/**
 * Created by olegtojgildin on 09/02/2019.
 */

public class ResponsePixabay {
    @SerializedName("hits")
    private List<Hit> imageHits;

    @SerializedName("total")
    private int total;

    @SerializedName("totalHits")
    private int totalHits;

    public List<Hit> getImageHits(){
        return imageHits;
    }

    public int getTotal(){
        return total;
    }

    public int getTotalHits(){
        return totalHits;
    }
}
