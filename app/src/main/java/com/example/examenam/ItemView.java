package com.example.examenam;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@Layout(R.layout.load_more_item_view)
public class ItemView {

    @View(R.id.titleTxt)
    private TextView titleTxt;

    @View(R.id.captionTxt)
    private TextView captionTxt;

    @View(R.id.abbreviationTxt)
    private TextView abbreviationTxt;

    @View(R.id.imageView)
    private ImageView imageView;

    private Revistas mInfo;
    private Context mContext;

    public ItemView(Context context, Revistas info) {
        mContext = context;
        mInfo = info;
    }

    @Resolve
    private void onResolved() {
        titleTxt.setText(mInfo.getName());
        captionTxt.setText(mInfo.getDescription());
        abbreviationTxt.setText(mInfo.getAbbreviation());
        Glide.with(mContext).load(mInfo.getPortada()).into(imageView);
    }

}
