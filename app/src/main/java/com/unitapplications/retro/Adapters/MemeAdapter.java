package com.unitapplications.retro.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.unitapplications.retro.Models.MemeModel;
import com.unitapplications.retro.R;

import java.util.ArrayList;
import java.util.List;

public class MemeAdapter extends RecyclerView.Adapter<MemeAdapter.myviewholder>{
    Context context;
    List<MemeModel> memeList;


    public MemeAdapter(Context context, List<MemeModel> memeList) {
        this.context = context;
        this.memeList = memeList;
    }


    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        MemeModel model = memeList.get(position);
      holder.title.setText(model.getheader());
        Log.d("tr", "onBindViewHolder: "+model.getheader());
     Glide.with(holder.title.getContext()).load("http://192.168.0.7/meme_api/admin/images/"+memeList.get(position).getImage()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        if(this.memeList!=null)
         return this.memeList.size();
        else
            return 0;
    }

    public class myviewholder extends RecyclerView.ViewHolder
    {
        TextView title;
        ImageView img;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.titleView);
            img=itemView.findViewById(R.id.imageView);
        }
    }
}