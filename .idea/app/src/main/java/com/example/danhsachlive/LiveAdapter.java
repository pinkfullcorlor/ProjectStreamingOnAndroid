package com.example.danhsachlive;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LiveAdapter extends RecyclerView.Adapter<LiveAdapter.LiveViewHolder> {

    private Context mContext;
    private List<Live> mlistLive;

    public LiveAdapter(Context mContext) {
        this.mContext = mContext;

    }

    public void setData(List<Live> list)
    {
        this.mlistLive = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LiveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new LiveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LiveViewHolder holder, int position) {
        Live live = mlistLive.get(position);
        if( live == null){
            return;
        }

        holder.imgLive.setImageResource(live.getResouceImage());
    }

    @Override
    public int getItemCount() {
        if(mlistLive != null)
        {
            return mlistLive.size();
        }
        return 0;
    }

    public class LiveViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgLive;
        public LiveViewHolder(@NonNull View itemView) {
            super(itemView);

            imgLive = itemView.findViewById(R.id.img_live);

        }

    }
}
