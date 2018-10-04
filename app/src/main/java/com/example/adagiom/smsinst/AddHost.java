package com.example.adagiom.smsinst;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddHost extends Activity {

    private Contacto contacto;
    private EditText nombre;
    private EditText numero;
    private EditText id;
    private Intent intent;
    private Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_host);
        nombre =  (EditText) findViewById(R.id.nombre);
        numero =  (EditText) findViewById(R.id.celular);
        id =  (EditText) findViewById(R.id.device);
        contacto =  new Contacto();
    }
    public void volver(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void agregarContacto(View v){

        //b = new Bundle();
        //b.putSerializable("contacto",contacto);


        if(numero.getText().toString().isEmpty() || nombre.getText().toString().isEmpty() || id.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Debe completar todos los campos",Toast.LENGTH_LONG).show();
        }else{
            long registro = contacto.registrarContacto(getApplicationContext(),numero.getText().toString(),id.getText().toString(),nombre.getText().toString());
            if(registro != -1) {
                intent = new Intent(this, MainActivity.class);
                //this.intent.putExtras(b);
                Toast.makeText(getApplicationContext(), "El Contacto " + nombre.getText().toString() + " registrado correctamente", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(),"El D.Number ya se encuentra en uso!",Toast.LENGTH_LONG).show();
            }
        }
    }
}
