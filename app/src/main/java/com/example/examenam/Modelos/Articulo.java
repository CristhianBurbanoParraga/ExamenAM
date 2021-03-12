package com.example.examenam.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Articulo {

    private String section;
    private String title;
    private JSONArray authors;
    private JSONArray galeys;

    private String urlPDF;
    private String htmlPDF;
    private String autores;

    public String getUrlPDF() {
        return urlPDF;
    }

    public void setUrlPDF(String urlPDF) {
        this.urlPDF = urlPDF;
    }

    public String getHtmlPDF() {
        return htmlPDF;
    }

    public void setHtmlPDF(String htmlPDF) {
        this.htmlPDF = htmlPDF;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public JSONArray getAuthors() {
        return authors;
    }

    public void setAuthors(JSONArray authors) {
        this.authors = authors;
    }

    public JSONArray getGaleys() {
        return galeys;
    }

    public void setGaleys(JSONArray galeys) {
        this.galeys = galeys;
    }

    public Articulo(JSONObject a) throws JSONException {

        section = a.getString("section").toString();
        title = a.getString("title").toString();;
        authors = a.getJSONArray("authors");
        galeys = a.getJSONArray("galeys");

        urlPDF=getValue(galeys,"PDF");
        htmlPDF=getValue(galeys,"HTML");;
        autores=getAutors(authors);

    }

    public String getValue(JSONArray datos, String type) throws JSONException {

        for (int i = 0; i < datos.length(); i++) {
            JSONObject x = datos.getJSONObject(i);
            String label = x.getString("label");
            label=label.toUpperCase();

            if (label.equals(type)) {
                return x.getString("UrlViewGalley");
            }
        }
        return "";
    }



    public String getAutors(JSONArray datos) throws JSONException {
        String result="";
        for (int i = 0; i < datos.length(); i++) {
            JSONObject x= datos.getJSONObject(i);
            result+= x.get("nombres")+ " , ";
        }
        return result;
    }


    public static ArrayList<Articulo> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Articulo> articulos = new ArrayList<>();

        for (int i = 0; i < datos.length(); i++) {
            articulos.add(new Articulo(datos.getJSONObject(i)));
        }
        return articulos;
    }


}
