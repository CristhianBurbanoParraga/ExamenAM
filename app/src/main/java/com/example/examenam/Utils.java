package com.example.examenam;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    private static final String TAG = "Utils";

    public static List<Revistas> loadInfiniteFeeds(JSONObject datos) throws JSONException {
        ArrayList<Revistas> revistas = new ArrayList<>();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        JSONArray array   = new JSONArray(datos);
        try {
            for (int i = 0; i < array .length(); i++) {
                Revistas feed = gson.fromJson(array.getString(i), Revistas.class);
                revistas.add(feed);
            }
            return revistas;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}
