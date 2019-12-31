package com.example.hci_demo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MovieAdapterStyleA extends RecyclerView.Adapter<MovieAdapterStyleA.ViewHolder> {
    private Context mContext;
    private ArrayList<MovieModelClass> listMovie;


    public MovieAdapterStyleA(Context mContext, ArrayList<MovieModelClass> listMovie) {
        this.mContext = mContext;
        this.listMovie = listMovie;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView _nameMovie;
        private TextView _timeMovie;
        private ImageView _imageMovie;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            _nameMovie = itemView.findViewById(R.id.txtNameMovie);
            _timeMovie = itemView.findViewById(R.id.txtTimeMovie);
            _imageMovie = itemView.findViewById(R.id.imageBackgroundMovie);
        }
    }

    @NonNull
    @Override
    public MovieAdapterStyleA.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View heroView = inflater.inflate(R.layout.activity_custom_row_style, parent, false);
        ViewHolder viewHolder = new ViewHolder(heroView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapterStyleA.ViewHolder holder, int position) {
        MovieModelClass movie = listMovie.get(position);
        Glide.with(mContext)
                .load(movie.getImageAvatarMovie())
                .into(holder._imageMovie);
        holder._nameMovie.setText(movie.getNameMoive());
        holder._timeMovie.setText(movie.getTimeMovie());
        holder._imageMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, VideoPlayerActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }
}
