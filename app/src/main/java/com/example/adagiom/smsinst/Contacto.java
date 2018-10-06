package com.example.adagiom.smsinst;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;

import static android.view.View.TEXT_ALIGNMENT_CENTER;

public class Contacto {

    private BDD db;

    public Contacto(){

    }

    public boolean eliminarConctacto_logico(Context context,String id){
        db = new BDD(context);
        String[] device = new String[]{id};
        SQLiteDatabase base = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(db.CAMPO_ESTADO_CONTACTO,"0");
        base.update(db.TABLE_NAME_CONTACTO,values,db.CAMPO_ID_CONTACTO+"=?",device);
        return true;
    }

    public boolean eliminarConctacto_fisico(Context context,String id){
        db = new BDD(context);
        String[] device = new String[]{id};
        SQLiteDatabase base = db.getWritableDatabase();
        base.delete(db.TABLE_NAME_CONTACTO,db.CAMPO_ID_CONTACTO+"=?",device);
        return true;
    }

    public Cursor mostrarConctactos(Context context){
        db = new BDD(context);
        SQLiteDatabase base = db.getReadableDatabase();
        String[] campos = new String[] {BDD.CAMPO_NOMBRE_CONTACTO,BDD.CAMPO_ID_CONTACTO,BDD.CAMPO_CELULAR_CONTACTO};
        String[] filtro = new String[] {db.ESTADO_DISPONIBLE};
        Cursor cursor = base.query(db.TABLE_NAME_CONTACTO, campos, db.CAMPO_ESTADO_CONTACTO+"=?",filtro, null, null, null);
        return cursor;

    }
    public long registrarContacto(Context context,String celular,String id,String nombre){
        db = new BDD(context);
        SQLiteDatabase base = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(db.CAMPO_ID_CONTACTO,id);
        values.put(db.CAMPO_CELULAR_CONTACTO,celular);
        values.put(db.CAMPO_NOMBRE_CONTACTO,nombre);
        values.put(db.CAMPO_ESTADO_CONTACTO,1);

        long registro = base.insert(db.TABLE_NAME_CONTACTO,db.CAMPO_NOMBRE_CONTACTO,values);

        return registro;
    }


}
