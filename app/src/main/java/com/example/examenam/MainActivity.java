package com.example.examenam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.mindorks.placeholderview.PlaceHolderView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*PlaceHolderView phvGallery = (PlaceHolderView)findViewById(R.id.phv_gallery);

        phvGallery.getBuilder()
                .setHasFixedSize(false)
                .setItemViewCacheSize(10)
                .setLayoutManager(new LinearLayoutManager(
                        getApplicationContext(),
                        LinearLayoutManager.HORIZONTAL,
                        false));

        phvGallery
                .addView(new GalleryImage(getApplicationContext(), "https://firebasestorage.googleapis.com/v0/b/artesanias-304016.appspot.com/o/images%2Faccesorios.jpg?alt=media&token=2e975a70-f3f5-4642-b130-47e8085e553d"))
                .addView(new GalleryImage(getApplicationContext(), "https://firebasestorage.googleapis.com/v0/b/artesanias-304016.appspot.com/o/images%2Fartesana-as-en-madera.jpg?alt=media&token=c98ebc9b-cccf-41dd-8403-015b2c99e400"))
                .addView(new GalleryImage(getApplicationContext(), "https://firebasestorage.googleapis.com/v0/b/artesanias-304016.appspot.com/o/images%2Fbolsos-artesanales-620x330.jpg?alt=media&token=c34ca617-b6f9-43af-a037-7f61570bfdc2"))
                .addView(new GalleryImage(getApplicationContext(), "https://firebasestorage.googleapis.com/v0/b/artesanias-304016.appspot.com/o/images%2Fcaballomadera.jpg?alt=media&token=d4c7b249-218b-44d7-a4f8-fe2a9c90a097"));*/


        /*PlaceHolderView mGalleryView = (PlaceHolderView)findViewById(R.id.galleryView);
        // (Optional): If customisation is Required then use Builder with the PlaceHolderView // placeHolderView.getBuilder() //

        mGalleryView.getBuilder()
        .setHasFixedSize(false) //
        .setItemViewCacheSize(10) //
        .setLayoutManager(new GridLayoutManager(this, 3));

        mGalleryView

                .addView(new ItemTypeBig(this.getApplicationContext(), mGalleryView, "https://firebasestorage.googleapis.com/v0/b/artesanias-304016.appspot.com/o/images%2Fcaballomadera.jpg?alt=media&token=d4c7b249-218b-44d7-a4f8-fe2a9c90a097"));

                /*.addView(new ImageTypeBig(this.getApplicationContext(), mGalleryView, url2));

                .addView(new ImageTypeBig(this.getApplicationContext(), mGalleryView, url3));

                .addView(new ImageTypeBig(this.getApplicationContext(), mGalleryView, url4));*/


    }
}