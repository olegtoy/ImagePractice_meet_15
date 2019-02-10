package com.practice.olegtojgildin.imagepractice_meet_15.activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.practice.olegtojgildin.imagepractice_meet_15.ImageItem;
import com.practice.olegtojgildin.imagepractice_meet_15.ImageTypesHelper;
import com.practice.olegtojgildin.imagepractice_meet_15.R;
import com.practice.olegtojgildin.imagepractice_meet_15.adapter.ImagesAdapter;
import com.practice.olegtojgildin.imagepractice_meet_15.data.ApiMapper;
import com.practice.olegtojgildin.imagepractice_meet_15.data.RetrofitHelper;
import com.practice.olegtojgildin.imagepractice_meet_15.data.model.Hit;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private GridLayoutManager mManager;
    private ImagesAdapter mImagesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        new AsyncTaskForecast().execute();

    }

    public void initViews() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mManager);
        mImagesAdapter = new ImagesAdapter();
        mRecyclerView.setAdapter(mImagesAdapter);

    }

    public class AsyncTaskForecast extends AsyncTask<Void, Void, List<Hit>> {
        @Override
        protected List<Hit> doInBackground(Void... voids) {
            ApiMapper mApiMapper = new ApiMapper(new RetrofitHelper());
            return mApiMapper.getImagesSync();
        }

        @Override
        protected void onPostExecute(List<Hit> images) {
            final List<ImageItem> mimages = ImageTypesHelper.maptoImages(images);
            mImagesAdapter.setImages(mimages);

        }
    }
}
