package com.mastercoding.sportsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class  SportsAdapter extends RecyclerView.Adapter<SportsAdapter.SportViewHolder> {
    private List<Sport> sportList;
    public itemClickListener clickListener;

    public SportsAdapter(List<Sport> sportList) {
        this.sportList = sportList;
    }

    public void setClickListener(itemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public SportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_layout,parent,false);

       return  new SportViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull SportViewHolder holder, int position) {
        Sport sport = sportList.get(position);
        holder.sportImg.setImageResource(sport.getSportImage());
        holder.sportName.setText(sport.getSportName());
    }

    @Override
    public int getItemCount() {
        return sportList.size();
    }



    public  class SportViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView sportName;
        ImageView sportImg;

    public SportViewHolder(@NonNull View itemView) {
        super(itemView);
        sportName = itemView.findViewById(R.id.cardTitle);
        sportImg =  itemView.findViewById(R.id.cardImage);
        itemView.setOnClickListener(this);
    }

        @Override
        public void onClick(View view) {
            if(clickListener!= null){
                clickListener.onCLick(view,getAdapterPosition());
            }
        }
    }
}
