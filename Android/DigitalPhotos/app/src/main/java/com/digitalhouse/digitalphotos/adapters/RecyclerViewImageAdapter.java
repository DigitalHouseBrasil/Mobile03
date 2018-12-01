package com.digitalhouse.digitalphotos.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.digitalhouse.digitalphotos.model.Image;
import com.digitalhouse.digitalphotos.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewImageAdapter extends RecyclerView.Adapter<RecyclerViewImageAdapter.ViewHolder> {

    private List<Image> images;

    public RecyclerViewImageAdapter(List<Image> images) {
        this.images = images;
    }

    @NonNull
    @Override
    public RecyclerViewImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewImageAdapter.ViewHolder viewHolder, int i) {
        Image image = images.get(i);
        viewHolder.bind(image);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewImageDescripion;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewImageDescripion = itemView.findViewById(R.id.textView);
        }

        private void bind(Image image) {
            Picasso.get()
                    .load(image.getUrl())
                    .placeholder(R.mipmap.ic_launcher)
                    .into(imageView);
            textViewImageDescripion.setText(image.getDescription());
        }
    }

    public void update(List<Image> images) {
        this.images = images;
        notifyDataSetChanged();
    }
}
