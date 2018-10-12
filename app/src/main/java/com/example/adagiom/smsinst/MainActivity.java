package com.example.adagiom.smsinst;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import static android.support.v7.app.AlertDialog.*;
import static android.view.View.TEXT_ALIGNMENT_CENTER;


public class MainActivity extends AppCompatActivity {


    LinearLayout vert;
    /**Esta parte deberia ir en otra pantalla, pero para probar lo pongo aca**/
    Contacto  contacto;
    Agenda agenda;
    Bundle bundle;
    BDD db;
    int contador = 0;
    @SuppressLint("InlinedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // referencia al LY Vertical en donde se iran cargando los contactos
        vert = (LinearLayout) findViewById(R.id.lyVert);
        db = new BDD(this);
        bundle = new Bundle();
        bundle = this.getIntent().getExtras();
        contacto = new Contacto();
        //Recibo el objeto de la pantalla Addhost
        //contacto =(Contacto) bundle.getSerializable("contacto");
        Cursor cursor = contacto.mostrarConctactos(this);

        if(cursor.moveToFirst()){

            do{
                //Creo un LY Horizontal para dar formato al contacto
                LinearLayout ly = new LinearLayout(this);
                ly.setOrientation(LinearLayout.HORIZONTAL);

                //Creo un objeto EditText que ira dentro del LY
                TextView nombre = new TextView(this);
                ImageButton cruz = new ImageButton(this);
                ImageButton edit = new ImageButton(this);
                ImageButton msj = new ImageButton(this);

                cruz.setTag(cursor.getString(1));
                edit.setTag(cursor.getString(1));
                msj.setTag(cursor.getString(1));

                cruz.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder dialog =  new AlertDialog.Builder(MainActivity.this, R.style.Theme_AppCompat_Dialog_MinWidth);
                        dialog.setTitle("Atencion!");
                        dialog.setMessage("Desea eliminar el contacto de manera permanente?");
                        final View vista= v;
                        dialog.setPositiveButton("Aceptar",new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(contacto.eliminarConctacto_fisico(getApplicationContext(),vista.getTag().toString()))
                                    finish();
                                   startActivity(getIntent());
                            }
                        });
                        dialog.setNegativeButton("Cancelar",new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                    dialog.show();
                    }
                });

                msj.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Bundle bundle = new Bundle();
                        //bundle.putString("codContacto",v.getTag().toString());
                        Intent intent = new Intent(MainActivity.this,Device.class);
                        intent.putExtra("codContacto",v.getTag().toString());
                        startActivity(intent);
                    }
                });
                cruz.setImageResource(R.mipmap.icon_delete);
                edit.setImageResource(R.mipmap.editiconmin);
                msj.setImageResource(R.mipmap.icon_msj);
                cruz.setLayoutParams(new LinearLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,FrameLayout.LayoutParams.MATCH_PARENT,1));
                edit.setLayoutParams(new LinearLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,FrameLayout.LayoutParams.MATCH_PARENT,1));
                msj.setLayoutParams(new LinearLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,FrameLayout.LayoutParams.MATCH_PARENT,1));
                nombre.setLayoutParams(new LinearLayout.LayoutParams(200,FrameLayout.LayoutParams.MATCH_PARENT,15));

                cruz.setBackground(getDrawable(R.drawable.boton_contacto));
                edit.setBackground(getDrawable(R.drawable.boton_contacto));
                msj.setBackground(getDrawable(R.drawable.boton_contacto));
                nombre.setBackground(getDrawable(R.drawable.boton_contacto));

                nombre.setTextAppearance(this, R.style.formatoNombre);
                nombre.setTextAlignment(TEXT_ALIGNMENT_CENTER);
                nombre.setText(cursor.getString(0));
                ly.addView(cruz);
                ly.addView(edit);
                ly.addView(nombre);
                ly.addView(msj);
                vert.addView(ly);

            }while(cursor.moveToNext());
        }
    }

     public void irAddHost(View v){

         Intent intent = new Intent(this,AddHost.class);
         startActivity(intent);
    }

    @Override
    public void onBackPressed() {

        if(contador == 0){
            Toast.makeText(getApplicationContext(),"Presione nuevamente para salir",Toast.LENGTH_SHORT).show();
            contador++;
        }else{
            //super.onBackPressed();
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

        new CountDownTimer(3000,1000){

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                contador=0;
            }
        }.start();
    }
}
