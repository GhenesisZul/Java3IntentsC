package com.example.genesiszul.sj_2_17_intents;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    private ImageButton ibAbrirMarcado;
    private ImageButton ibLLamar;
    private ImageButton ibAbreGoogleMaps;
    private ImageButton ibAbrePaginaWeb;
    private ImageButton ibEnviaEmail;
    private ImageButton ibComparteImagen;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ibAbrirMarcado = (ImageButton) findViewById(R.id.ibAbrirMarcado);
        ibLLamar = (ImageButton) findViewById(R.id.ibLlamar);
        ibAbreGoogleMaps = (ImageButton) findViewById(R.id.ibAbreGoogleMaps);
        ibAbrePaginaWeb = (ImageButton) findViewById(R.id.ibAbrePaginaWeb);
        ibEnviaEmail = (ImageButton) findViewById(R.id.ibEnviaEmail);
        ibComparteImagen = (ImageButton) findViewById(R.id.ibComparteImagen);

        ibAbrirMarcado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirMarcadoTelefonico();
            }
        });

        ibLLamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llamar();
            }
        });

        ibAbreGoogleMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirGoogleMaps();
            }
        });

        ibAbrePaginaWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirPaginaWeb();
            }
        });


    }

    public void abrirMarcadoTelefonico(){
        intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:61146624"));
        startActivity(intent);
    }

    public void  llamar(){
        int permissionCheck = ContextCompat.checkSelfPermission(
                this, Manifest.permission.CALL_PHONE);

        intent = new Intent(Intent.ACTION_CALL);
        Uri.parse(("tel:61146624"));
        startActivity(intent);
    }

    public void onRequestPermissionResult(int requestCode, String[] permissions,
                                          int[] grantResults){
        switch (requestCode){
            case 123:
                if ((grantResults.length > 0) &&
                        (grantResults[0]== PackageManager.PERMISSION_GRANTED)){
                  llamar();
                }else{
                    Log.d("TAG", "Permiso de llamada no concedido");
                }
                break;
            default:
                break;
        }
    }

    public void abrirGoogleMaps(){
        intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo: -16.504014, -68.130906"));
        startActivity(intent);
    }

    public void abrirPaginaWeb(){
        intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.gdg.androidbolivia.com"));
        startActivity(intent);
    }



}
