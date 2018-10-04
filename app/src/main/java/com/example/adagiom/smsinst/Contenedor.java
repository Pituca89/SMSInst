package com.example.adagiom.smsinst;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.jar.Attributes;

public class Contenedor extends LinearLayout {

    private ImageButton eliminar;
    private ImageButton editar;
    private ImageButton mensaje;
    private EditText nombre;

    public Contenedor(Context context,AttributeSet attributeSet){
        super(context,attributeSet);
    }

    public void setEliminar(ImageButton eliminar) {
        this.eliminar = eliminar;
    }

    public void setEditar(ImageButton editar){
        this.editar = editar;
    }

    public void setMensaje(ImageButton mensaje) {
        this.mensaje = mensaje;
    }

    public void setNombre(String nombre) {
        this.nombre.setText(nombre);
    }
}
