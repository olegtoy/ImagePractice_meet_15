package com.practice.olegtojgildin.imagepractice_meet_15.binder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.practice.olegtojgildin.imagepractice_meet_15.ImageItem;
import com.practice.olegtojgildin.imagepractice_meet_15.data.model.Image;
import com.practice.olegtojgildin.imagepractice_meet_15.holder.HttpImageHolder;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by olegtojgildin on 09/02/2019.
 */

public class HttpImageHolderBinder extends ImageHolderBinder {
    private Image mImage;
    Bitmap bitmapImage;
    HttpImageHolder httpImageHolder;

    public HttpImageHolderBinder(final ImageItem imageItem, final int viewType) {
        super(viewType);
        this.mImage = (Image) imageItem;
    }

    @Override
    public void bindViewHolder(RecyclerView.ViewHolder holder) {
        httpImageHolder = (HttpImageHolder) holder;
      //  new HttpLoaderAsycTask().execute(mImage.getImageUrl());
       Thread thread= new Thread(){
            @Override
            public void run() {
                bitmapImage=getImage(mImage.getImageUrl());
            }
        };

       thread.start();
        try {
            thread.join();
            httpImageHolder.getImageView().setImageBitmap(bitmapImage);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static Bitmap getImage(String imageUrl) {
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) getUrl(imageUrl).openConnection();
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode == 200)
                return BitmapFactory.decodeStream(connection.getInputStream());
            else
                return null;

        } catch (IOException ex) {
            return null;
        } finally {
            if (connection != null)
                connection.disconnect();
        }
    }

    public static URL getUrl(String imageUrl) {
        URL url;
        try {
            url = new URL(imageUrl);
            return url;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public class HttpLoaderAsycTask extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... strings) {
            return getImage(strings[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {

            httpImageHolder.getImageView().setImageBitmap(bitmap);
        }
    }
}
