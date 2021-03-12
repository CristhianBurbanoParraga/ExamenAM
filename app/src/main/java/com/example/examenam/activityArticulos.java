package com.example.examenam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.examenam.Adaptadores.AdapterArticulo;
import com.example.examenam.Modelos.Articulo;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebServices.Asynchtask;
import WebServices.WebService;

public class activityArticulos extends AppCompatActivity implements Asynchtask, AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulos);

        ListView lstOpciones=(ListView)findViewById(R.id.lvListaArticulos);
        lstOpciones.setOnItemClickListener(this);
        getPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        getPermission(Manifest.permission.READ_EXTERNAL_STORAGE);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/pubs.php?i_id="+ getIntent().getStringExtra("idVolumen"), datos, this, this);
        ws.execute("");
    }

    ArrayList<Articulo> listaArticulos;
    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray articulos=  new JSONArray(result);

        listaArticulos=Articulo.JsonObjectsBuild(articulos);

        String x="";
        AdapterArticulo adaptadorArticulos = new AdapterArticulo(this,listaArticulos);
        ListView listaArticulos =(ListView)findViewById(R.id.lvListaArticulos);
        listaArticulos.setAdapter(adaptadorArticulos);
    }

    long enq;
    DownloadManager downloadManager;
    Context contexto;
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        contexto=this.getApplicationContext();

        String url=((Articulo)parent.getItemAtPosition(position)).getUrlPDF()+".pdf";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setDescription("PDF Paper");
        request.setTitle("Pdf Artclee");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "filedownload.pdf");
        DownloadManager manager = (DownloadManager) this.getApplicationContext().getSystemService(Context.DOWNLOAD_SERVICE);
        try {
            enq = manager.enqueue(request);
        } catch (Exception e) {
            Toast.makeText(this.getApplicationContext(),
                    e.getMessage(),
                    Toast.LENGTH_LONG).show();
        }
    }

    public void getPermission(String permission){
        if (Build.VERSION.SDK_INT >= 23) {
            if (!(checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED))
                ActivityCompat.requestPermissions(this, new String[]{permission}, 1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[]
            permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==1)
        {
            Toast.makeText(this.getApplicationContext(),"OK", Toast.LENGTH_LONG).show();
        }
    }
}