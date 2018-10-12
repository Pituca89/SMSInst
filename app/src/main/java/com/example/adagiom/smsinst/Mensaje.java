package com.example.adagiom.smsinst;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class Mensaje {
    private String mensaje;
    private String emisor;
    private String receptor;
    SmsManager sms;
    BDD base;

    public Mensaje(Context context,String msj, String emisor, String receptor){
        base = new BDD(context);
        this.mensaje = msj;
        this.emisor = emisor;
        this.receptor = receptor;
        this.sms = SmsManager.getDefault();
    }

    public String EnviarMensaje(Context context,Activity activity){

        try {
            int permissionCheck = ContextCompat.checkSelfPermission(context, Manifest.permission.SEND_SMS);
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                //Toast.makeText(context,"No se tiene permiso para enviar SMS.",Toast.LENGTH_LONG).show();
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.SEND_SMS}, 225);
                return "No se tiene permiso para enviar SMS.";
            } else {
                Log.i("Mensaje", "Se tiene permiso para enviar SMS!");
            }
            this.sms.sendTextMessage(this.receptor,null,this.mensaje,null,null);
            //Toast.makeText(context,"Mensaje Enviado",Toast.LENGTH_SHORT).show();
            return "Mensaje Enviado";
        }catch (Exception e){
            //Toast.makeText(context,"Verifique los permisos",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

        return "Verifique los permisos";
    }


}
