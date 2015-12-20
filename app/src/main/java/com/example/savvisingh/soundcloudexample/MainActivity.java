package com.example.savvisingh.soundcloudexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.savvisingh.soundcloudexample.prefrences.ZPreferences;

import java.util.ArrayList;
import java.util.List;

import lubecki.soundcloud.webapi.android.SoundCloudAPI;
import lubecki.soundcloud.webapi.android.SoundCloudAuthenticator;
import lubecki.soundcloud.webapi.android.SoundCloudService;
import lubecki.soundcloud.webapi.android.models.Playlist;
import lubecki.soundcloud.webapi.android.models.Track;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends AppCompatActivity {

    SoundCloudService soundcloud;
    private RecyclerView recList;
    private LinearLayoutManager llm;
    private RecyclerView.Adapter mAdapter;
    private List<Track> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList = new ArrayList<Track>();

        recList = (RecyclerView) findViewById(R.id.recycler_view);
        recList.setHasFixedSize(true);
        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        mAdapter = new TracksRecyclerViewAdapter(MainActivity.this, mList);
        recList.setAdapter(mAdapter);

        if(!ZPreferences.isUserLogIn(this)) {
            SoundCloudAuthenticator.openLoginActivity(MainActivity.this, "com.example.savvisingh.soundcloudexample://soundcloud/redirect", "3594d5ad2a219ca13c5f75d771a5515e");
            finish();
        }
        else{
            SoundCloudAPI api = new SoundCloudAPI("clientId");

           // Few of the SoundCloud Web API endpoints require authorization.
           // If you know you'll require authorization you can add this step.
            api.setToken(ZPreferences.getUserToken(this));

           soundcloud = api.getService();
        }



        if(soundcloud != null){
            soundcloud.getMyTracks(new Callback<List<Track>>() {
                @Override
                public void success(List<Track> tracks, Response response) {
                    Log.d("My App ", tracks.toString());
                    loadTracks(tracks);
                }

                @Override
                public void failure(RetrofitError error) {

                }
            });


        }



    }


    public void loadTracks(List<Track> tracks){
        mList.clear();
        mList.addAll(tracks);
        mAdapter.notifyDataSetChanged();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
