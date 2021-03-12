package com.example.examenam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.mindorks.placeholderview.InfinitePlaceHolderView;
import com.mindorks.placeholderview.PlaceHolderView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import WebServices.Asynchtask;
import WebServices.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    private InfinitePlaceHolderView mLoadMoreView;
    List<Revistas> feedList;
    Map<String, String> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLoadMoreView = (InfinitePlaceHolderView)findViewById(R.id.loadMoreView);
        datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/journals.php", datos, this, this);
        ws.execute("");
    }

    private void setupView() {
        //feedList = Utils.loadInfiniteFeeds(this.getApplicationContext());
        Log.d("DEBUG", "LoadMoreView.LOAD_VIEW_SET_COUNT " + LoadMoreView.LOAD_VIEW_SET_COUNT);
        for(int i = 0; i < LoadMoreView.LOAD_VIEW_SET_COUNT; i++){
            mLoadMoreView.addView(new ItemView(this.getApplicationContext(), feedList.get(i)));
        }
        mLoadMoreView.setLoadMoreResolver(new LoadMoreView(mLoadMoreView, feedList));
    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONObject revistas=  new JSONObject(result);
        feedList = Utils.loadInfiniteFeeds(revistas);
        //listaPaises = Paises.JsonObjectsBuild(pais);
        setupView();
    }
}