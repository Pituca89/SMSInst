package com.example.adagiom.smsinst;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.ClientInfoStatus;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDD extends SQLiteOpenHelper{

    public static final int VERSION = 1;
    public static final String DB_NAME = "bddMensajeria.db";
    public static final String TABLE_NAME = "Cliente";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_CELULAR = "celular";
    public static final String CAMPO_ESTADO = "estado";
    public static final String ESTADO_DISPONIBLE = "1";
    public static final String CREAR_TABLA_CONTACTO = "CREATE TABLE "+TABLE_NAME+" ("
            +CAMPO_ID+" TEXT PRIMARY KEY NOT NULL, "
            +CAMPO_NOMBRE+" TEXT, "
            +CAMPO_CELULAR+" TEXT, "
            +CAMPO_ESTADO+" INTEGER)";

    public BDD(Context context) {

        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA_CONTACTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

}
