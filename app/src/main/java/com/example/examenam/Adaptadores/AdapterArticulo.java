package com.example.examenam.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.examenam.Modelos.Articulo;
import com.example.examenam.R;

import java.util.ArrayList;

public class AdapterArticulo extends ArrayAdapter<Articulo> {

    public AdapterArticulo(Context context, ArrayList<Articulo> datos) {
        super(context, R.layout.load_more_articles, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.load_more_articles, null);


        ImageView imgPDF= (ImageView)item.findViewById(R.id.imgPdf);
        ImageView imgHTML= (ImageView)item.findViewById(R.id.imgHtml);

        TextView txtSeccion = (TextView)item.findViewById(R.id.txtSeccion);
        TextView txtTitulo = (TextView)item.findViewById(R.id.txtTitulo);
        TextView txtAutores = (TextView)item.findViewById(R.id.txtAutores);

        txtSeccion.setText(getItem(position).getSection());
        txtTitulo.setText(getItem(position).getTitle());
        txtAutores.setText(getItem(position).getAutores());


        imgPDF.setTag(getItem(position).getUrlPDF());

        Glide.with(this.getContext()).load("https://luciomsp.files.wordpress.com/2018/05/pdf.png?w=224&h=224").into(imgPDF);
        Glide.with(this.getContext()).load("https://image.flaticon.com/icons/png/512/29/29515.png").into(imgHTML);

        return(item);

    }

}
