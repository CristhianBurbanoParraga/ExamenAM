package com.example.examenam;

import android.content.Context;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Animate;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.LongClick;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@Animate(Animate.ENTER_BOTTOM_DESC)
@NonReusable
@Layout(R.layout.gallery_item_big)
public class ItemTypeBig {

    @View(R.id.imageView)
    private ImageView imageView;

    private String mUrl;
    private Context mContext;
    private PlaceHolderView mPlaceHolderView;

    public ItemTypeBig(Context context, PlaceHolderView placeHolderView, String url) {

        mContext = context;

        mPlaceHolderView = placeHolderView;

        mUrl = url;

    }

    @Resolve
    private void onResolved() {

        Glide.with(mContext).load(mUrl).into(imageView);


    }

    @LongClick(R.id.imageView)
    private void onLongClick(){

        mPlaceHolderView.removeView(this);


    }

}
