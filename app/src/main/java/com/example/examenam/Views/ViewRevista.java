package com.example.examenam.Views;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.examenam.Modelos.Revista;
import com.example.examenam.R;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@Layout(R.layout.load_more_item_view)
public class ViewRevista {

    @View(R.id.titleTxt)
    private TextView titleTxt;

    @View(R.id.captionTxt)
    private TextView captionTxt;

    @View(R.id.imageView)
    private ImageView imageView;

    private Revista revista;
    private Context mContext;

    public ViewRevista(Context context, Revista r) {
        mContext = context;
        revista = r;
    }

    @Resolve
    private void onResolved() {
        titleTxt.setText(revista.getName());
        captionTxt.setText(revista.getDescription());
        Glide.with(mContext).load(revista.getPortada()).into(imageView);
    }

}
