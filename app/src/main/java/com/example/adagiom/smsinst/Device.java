package com.example.adagiom.smsinst;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;
import android.telephony.SmsManager;
public class Device extends Activity {

    private ImageButton lock;
    private  String mensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);
        this.lock = findViewById(R.id.lock);
        lock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensaje = Device.this.getIntent().getExtras().getString("codContacto");
                mensaje += "#" + getResources().getResourceEntryName(v.getId());
                Mensaje msj = new Mensaje(Device.this, mensaje, null, "1161436330");
                msj.EnviarMensaje(Device.this,Device.this);
            }
        });


    }
    public void volver(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String msj){
        this.mensaje = msj ;
    }
}
