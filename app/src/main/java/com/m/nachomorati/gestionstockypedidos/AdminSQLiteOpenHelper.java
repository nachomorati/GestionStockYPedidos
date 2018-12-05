package com.m.nachomorati.gestionstockypedidos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE materiales(" +
                "plant text," +
                "material text primary key," +
                "descripcion text," +
                "batch text," +
                "storage_location text," +
                "status text," +
                "pallets text," +
                "value text," +
                "ff text," +
                "stock int" +
                ")");
        db.execSQL("CREATE TABLE pedidos (" +
                "codigo int primary key," +
                "fecha text," +
                "id_realizo_pedido integer," +
                "id_usuario_retira integer," +
                "pedido text," +
                "estado int," +
                "fecha_cierre text," +
                "comentario text)");
        db.execSQL("CREATE TABLE usuarios (" +
                "id int primary key," +
                "usuario text," +
                "perfil int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
