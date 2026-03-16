package com.furkanfidanoglu.instagramclone.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.furkanfidanoglu.instagramclone.databinding.RecyclerRowBinding;
import com.furkanfidanoglu.instagramclone.model.Post;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FeedRecyclerAdapter extends RecyclerView.Adapter<FeedRecyclerAdapter.PostHolder> {
    ArrayList<Post> postArrayList;

    public FeedRecyclerAdapter(ArrayList<Post> postArrayList) {
        this.postArrayList = postArrayList;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PostHolder(recyclerRowBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        holder.recyclerRowBinding.recyclerViewUserEmail.setText(postArrayList.get(position).userEmail);
        //Picasso ile görseli çekme
        Picasso.get()
                .load(postArrayList.get(position).downloadUrl)
                .fit() // Performans için: Resmi ImageView boyutuna küçültür
                .centerInside() // Kırpmak yerine, orantılı olarak içine sığdırır
                .into(holder.recyclerRowBinding.recyclerViewImageView);
        holder.recyclerRowBinding.recyclerViewComment.setText(postArrayList.get(position).comment);
    }

    @Override
    public int getItemCount() {
        return postArrayList.size();
    }

    class PostHolder extends RecyclerView.ViewHolder {
        RecyclerRowBinding recyclerRowBinding;

        public PostHolder(RecyclerRowBinding recyclerRowBinding) {
            super(recyclerRowBinding.getRoot());
            this.recyclerRowBinding = recyclerRowBinding;
        }
    }
}
