package com.example.adagiom.smsinst;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Device extends Activity {

    private ImageButton lock;
    private ImageButton unlock;
    private ImageButton home;
    private ImageButton sos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);
        this.lock = findViewById(R.id.lock);
        this.unlock = findViewById(R.id.unlock);
        this.home = findViewById(R.id.home);
        this.sos = findViewById(R.id.sos);

        lock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contacto contacto;
                contacto = new Contacto();

                String mensaje = Device.this.getIntent().getExtras().getString("codContacto");
                Cursor cursor = contacto.mostrarNumero(mensaje,Device.this);
                if(cursor.moveToFirst()){
                    mensaje += "#" + getResources().getResourceEntryName(v.getId());
                    Mensaje msj = new Mensaje(Device.this, mensaje, null, cursor.getString(0));

                    String aviso = msj.EnviarMensaje(Device.this,Device.this);
                    Toast.makeText(Device.this,aviso,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Device.this,MainActivity.class);
                    startActivity(intent);
                }

            }
        });

        unlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contacto contacto;
                contacto = new Contacto();

                String mensaje = Device.this.getIntent().getExtras().getString("codContacto");
                Cursor cursor = contacto.mostrarNumero(mensaje,Device.this);
                if(cursor.moveToFirst()){
                    mensaje += "#" + getResources().getResourceEntryName(v.getId());
                    Mensaje msj = new Mensaje(Device.this, mensaje, null, cursor.getString(0));

                    String aviso = msj.EnviarMensaje(Device.this,Device.this);
                    Toast.makeText(Device.this,aviso,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Device.this,MainActivity.class);
                    startActivity(intent);
                }

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contacto contacto;
                contacto = new Contacto();

                String mensaje = Device.this.getIntent().getExtras().getString("codContacto");
                Cursor cursor = contacto.mostrarNumero(mensaje,Device.this);
                if(cursor.moveToFirst()){
                    mensaje += "#" + getResources().getResourceEntryName(v.getId());
                    Mensaje msj = new Mensaje(Device.this, mensaje, null, cursor.getString(0));

                    String aviso = msj.EnviarMensaje(Device.this,Device.this);
                    Toast.makeText(Device.this,aviso,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Device.this,MainActivity.class);
                    startActivity(intent);
                }

            }
        });

        sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contacto contacto;
                contacto = new Contacto();

                String mensaje = Device.this.getIntent().getExtras().getString("codContacto");
                Cursor cursor = contacto.mostrarNumero(mensaje,Device.this);
                if(cursor.moveToFirst()){
                    mensaje += "#" + getResources().getResourceEntryName(v.getId());
                    Mensaje msj = new Mensaje(Device.this, mensaje, null, cursor.getString(0));

                    String aviso = msj.EnviarMensaje(Device.this,Device.this);
                    Toast.makeText(Device.this,aviso,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Device.this,MainActivity.class);
                    startActivity(intent);
                }

            }
        });


    }
    public void volver(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
