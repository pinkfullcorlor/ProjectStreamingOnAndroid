package com.example.searchandview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class videoadapter extends RecyclerView.Adapter<videoadapter.videoViewHolder> implements Filterable {
    private List<videos> listvideos;
    private List<videos> listvideoscu;

    public videoadapter(List<videos> listvideos) {
        this.listvideos = listvideos;

        //khai bao them listvideoscu de luc chua search danh sach van hien thi day du video
        this.listvideoscu = listvideos;
    }

    @NonNull
    @Override
    public videoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_streamer, parent, false);
        return new videoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull videoViewHolder holder, int position) {
        videos videos = listvideos.get(position);
        if (videos == null){
            return;
        }
        holder.imgstream.setImageResource(videos.getImage());
        holder.tvname.setText(videos.getName());
    }

    @Override
    public int getItemCount() {
        if (listvideos != null){
            return listvideos.size();
        }
        return 0;
    }



    public class videoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgstream;
        private TextView tvname;
        public videoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgstream = itemView.findViewById(R.id.image_steamer);
            tvname = itemView.findViewById(R.id.tv_name);
        }
    }
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String strsearch = charSequence.toString();
                if(strsearch.isEmpty()){
                    listvideos = listvideoscu;
                } else {
                    List<videos> list = new ArrayList<>();
                    for (videos videos : listvideoscu){
                        if (videos.getName().toLowerCase().contains(strsearch.toLowerCase())){
                            list.add(videos);
                        }
                    }
                    listvideos = list;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = listvideos;


                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                listvideos = (List<videos>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }


}

