package com.example.luchobolivar.tapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.luchobolivar.tapp.Entidades.Rutas;
import com.example.luchobolivar.tapp.HttpURLConnection.HttpConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class RutasActivity extends AppCompatActivity {

    private String enlaceRutas;
    private Spinner rutas;
    private String ip;

    HttpConnection connection;

    List<Rutas> listaRutas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutas);

        rutas = (Spinner) findViewById(R.id.cbRutas);
        ip = DireccionIP.getIp();

        connection = new HttpConnection();

        llenarRutas();


    }

    public void llenarRutas (){
        enlaceRutas = "http://" + ip + "/servcioWebTAPP/ListarRutas.php";
        new listarRutas().execute(enlaceRutas);


    }

    class listarRutas extends AsyncTask<String, Float, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String resultado) {
            super.onPostExecute(resultado);
            int r = obtenerDatosJSONRutas(resultado);
            if (r > 0) {
                ArrayAdapter<Rutas> spinnerArrayAdapter = new ArrayAdapter<Rutas>(getApplicationContext(),
                        android.R.layout.simple_spinner_item, listaRutas);
                rutas.setAdapter(spinnerArrayAdapter);
            } else {
                Toast.makeText(getApplicationContext(), "No hay Rutas disponibles en este momento", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected String doInBackground(String... strings) {
            String resultado = connection.enviarDatosGet(enlaceRutas);
            return resultado;
        }
    }

    public int obtenerDatosJSONRutas(String respuesta) {
        Log.e("Respuesta", respuesta);
        int resultado = 0;
        try {
            JSONArray json = new JSONArray(respuesta);
            //Verficamos que el tamaño del json sea mayor que 0
            if (json.length() > 0) {
                resultado = 1;
                for (int i = 0; i < json.length(); i++) {
                    JSONObject row = json.getJSONObject(i);

                    String id = row.getString("id");
                    String numRuta = row.getString("numero_ruta");
                    String nomRuta = row.getString("nombre_ruta");

                    Rutas ruta = new Rutas(id, nomRuta, numRuta);
                    listaRutas.add(ruta);

                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return resultado;
    }






}
