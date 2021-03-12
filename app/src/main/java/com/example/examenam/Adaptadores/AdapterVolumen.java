package com.example.examenam.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.examenam.Modelos.Volumen;
import com.example.examenam.R;

import java.util.ArrayList;

public class AdapterVolumen extends ArrayAdapter<Volumen> {

    public AdapterVolumen(Context context, ArrayList<Volumen> datos) {
        super(context, R.layout.load_more_volumen, datos);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.load_more_volumen, null);

        ImageView imgVolumen= (ImageView)item.findViewById(R.id.imgVolumen);
        TextView DOI = (TextView)item.findViewById(R.id.txtDOI);
        TextView txtTittle = (TextView)item.findViewById(R.id.txtTittle);

        DOI.setText(getItem(position).getDoi());
        txtTittle.setText(getItem(position).getTitle());
        Glide.with(this.getContext()).load(getItem(position).getCover()).into(imgVolumen);
        return(item);

    }

}
