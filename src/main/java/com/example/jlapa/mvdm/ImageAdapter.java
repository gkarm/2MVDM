package com.example.jlapa.mvdm;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private Context mContext;
    private List<Capture> mCaptures;


    public ImageAdapter(Context context, List<Capture> captures) {
        mContext = context;
        mCaptures = captures;

    }

    public ImageAdapter(EditFragment editFragment, List<Capture> mCaptures) {
        // constructor created for EditFragment
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.image_item, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        Capture captureCurrent = mCaptures.get(position);
        holder.textViewName.setText(captureCurrent.getmName());
        Picasso.with(mContext)
                .load(captureCurrent.getImageUrl())
                .placeholder(R.mipmap.ic_launcher)
                .fit()
                .centerCrop()
                .into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return (mCaptures == null) ? 0 : mCaptures.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public ImageView imageView;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.text_view_name);
            imageView = itemView.findViewById(R.id.image_view_upload);

        }
    }
}
