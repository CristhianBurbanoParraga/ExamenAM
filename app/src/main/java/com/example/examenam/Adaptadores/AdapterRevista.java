package com.example.examenam.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.examenam.Modelos.Revista;
import com.example.examenam.R;

import java.util.ArrayList;


public class AdapterRevista extends ArrayAdapter<Revista> {

    public AdapterRevista(Context context, ArrayList<Revista> datos) {
        super(context, R.layout.load_more_item_view, datos);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.load_more_item_view, null);

        ImageView imgRevista= (ImageView)item.findViewById(R.id.imageView);
        TextView NameRevista = (TextView)item.findViewById(R.id.titleTxt);
        TextView DescriptionRevista = (TextView)item.findViewById(R.id.captionTxt);

        NameRevista.setText(getItem(position).getName());
        DescriptionRevista.setText(getItem(position).getDescription());
        Glide.with(this.getContext()).load(getItem(position).getPortada()).into(imgRevista);
        return(item);
    }

}
