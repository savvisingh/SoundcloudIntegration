package com.example.savvisingh.soundcloudexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import lubecki.soundcloud.webapi.android.models.Track;

/**
 * Created by Savvi Singh on 10/31/2015.
 */
public class TracksRecyclerViewAdapter  extends RecyclerView.Adapter<TracksRecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private List<Track> tracksList;

    public TracksRecyclerViewAdapter(Context context, List<Track> userList){
        this.context = context;
        this.tracksList = userList;
    }

    @Override
    public TracksRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_view_user_tracks, parent, false);

        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TracksRecyclerViewAdapter.MyViewHolder holder, int position) {

      Track track = tracksList.get(position);
        holder.trackTitle.setText(track.title);
        Glide.with(context).load(track.artwork_url).into(holder.trackImage);
        holder.trackDate.setText(track.release);



    }

    @Override
    public int getItemCount() {
        return tracksList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        private TextView trackTitle, trackDate;
        private ImageView trackImage;

        public MyViewHolder(View itemView) {
            super(itemView);

            trackImage = (ImageView) itemView.findViewById(R.id.track_imageview);
            trackTitle = (TextView) itemView.findViewById(R.id.track_title);
            trackDate = (TextView)itemView.findViewById(R.id.track_date);


        }


        @Override
        public void onClick(View v) {




        }
    }



}
