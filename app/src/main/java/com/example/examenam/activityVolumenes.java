package com.example.examenam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.examenam.Adaptadores.AdapterVolumen;
import com.example.examenam.Modelos.Volumen;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebServices.Asynchtask;
import WebServices.WebService;

public class activityVolumenes extends AppCompatActivity implements Asynchtask, AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumenes);

        ListView lstOpciones=(ListView)findViewById(R.id.lvListaVolumenes);
        lstOpciones.setOnItemClickListener(this);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/issues.php?j_id="+ getIntent().getStringExtra("idRevista"), datos, this, this);
        ws.execute("");
    }

    ArrayList<Volumen> listaVol;
    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray articulos=  new JSONArray(result);

        listaVol=Volumen.JsonObjectsBuild(articulos);

        AdapterVolumen adaptadorArticulos = new AdapterVolumen(this,listaVol);
        ListView listaArticulos =(ListView)findViewById(R.id.lvListaVolumenes);
        listaArticulos.setAdapter(adaptadorArticulos);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent (view.getContext(), activityArticulos.class);
        //intent.putExtra("volumen",listaRevistas.get(position).getVolumen());
        intent.putExtra("idVolumen",listaVol.get(position).getIssue_id());
        startActivityForResult(intent, 0);
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