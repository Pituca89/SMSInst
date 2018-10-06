package com.example.adagiom.smsinst;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.ClientInfoStatus;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDD extends SQLiteOpenHelper {

    public static final int VERSION = 2;
    public static final String DB_NAME = "bddMensajeria.db";
    public static final String TABLE_NAME_CONTACTO = "Cliente";
    public static final String CAMPO_ID_CONTACTO = "id";
    public static final String CAMPO_NOMBRE_CONTACTO = "nombre";
    public static final String CAMPO_CELULAR_CONTACTO = "celular";
    public static final String CAMPO_ESTADO_CONTACTO = "estado";
    public static final String TABLE_NAME_MENSAJE = "Mensaje";

    public static final String CAMPO_ID_MENSAJE = "id";
    public static final String CAMPO_NOMBRE_MENSAJE = "nombre";
    public static final String CAMPO_EMISOR_MENSAJE = "emisor";
    public static final String CAMPO_REMITENTE_MENSAJE = "remitente";
    public static final String CAMPO_ESTADO_MENSAJE = "estado";

    public static final String ESTADO_DISPONIBLE = "1";

    public static final String CREAR_TABLA_CONTACTO = "CREATE TABLE "+TABLE_NAME_CONTACTO+" ("
            +CAMPO_ID_CONTACTO+" TEXT PRIMARY KEY NOT NULL, "
            +CAMPO_NOMBRE_CONTACTO+" TEXT, "
            +CAMPO_CELULAR_CONTACTO+" TEXT, "
            +CAMPO_ESTADO_CONTACTO+" INTEGER)";

    public static final String CREAR_TABLA_MENSAJE = "CREATE TABLE "+TABLE_NAME_MENSAJE+" ("
            +CAMPO_ID_MENSAJE+" TEXT PRIMARY KEY NOT NULL, "
            +CAMPO_NOMBRE_MENSAJE+" TEXT, "
            +CAMPO_EMISOR_MENSAJE+" TEXT, "
            +CAMPO_REMITENTE_MENSAJE+" TEXT, "
            +CAMPO_ESTADO_MENSAJE+" INTEGER)";

    public BDD(Context context) {

        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREAR_TABLA_CONTACTO);
        db.execSQL(CREAR_TABLA_MENSAJE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_CONTACTO);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_MENSAJE);
        onCreate(db);
    }

}
