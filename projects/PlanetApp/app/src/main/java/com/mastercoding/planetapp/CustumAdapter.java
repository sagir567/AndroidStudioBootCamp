package com.mastercoding.planetapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustumAdapter extends ArrayAdapter<Planet> {

    private ArrayList<Planet> planetsList;
    Context context;


    public CustumAdapter(ArrayList<Planet> planetList,Context context ) {
        super(context, R.layout.item_list_layout, planetList);
        this.planetsList= planetList;
        this.context= context;
    }


    private static class ViewHolder{
        TextView planetName;
        TextView moonsCount;
        ImageView planetImage;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView , @NonNull ViewGroup parent){
        Planet planet =  getItem(position);
        if(planet == null )throw  new NullPointerException("expected planet but received null pointer");
        ViewHolder viewHolder;
        final View  result;

        if (convertView == null){
            viewHolder =  new ViewHolder();
            LayoutInflater inflater =  LayoutInflater.from(getContext());
            convertView =  inflater.inflate(R.layout.item_list_layout,parent,false);

            viewHolder.planetName = (TextView) convertView.findViewById(R.id.plantNameTxt);
            viewHolder.moonsCount = (TextView) convertView.findViewById(R.id.MoonCountTxt);
            viewHolder.planetImage = (ImageView) convertView.findViewById(R.id.planetImage);


            convertView.setTag(viewHolder);
        }
        else{viewHolder = (ViewHolder) convertView.getTag();}
        result =  convertView;

        viewHolder.planetName.setText(planet.getPlanetName());
        viewHolder.moonsCount.setText(planet.getMoonCount());
        viewHolder.planetImage.setImageResource(planet.getPlanetImage());


        return result;

    }
}
