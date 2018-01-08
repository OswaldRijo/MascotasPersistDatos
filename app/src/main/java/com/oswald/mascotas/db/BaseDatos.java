package com.oswald.mascotas.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.oswald.mascotas.R;
import com.oswald.mascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by oswal on 7/1/2018.
 */

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;


    public BaseDatos(Context context) {
        super(context, ConstantesBDD.DATABASE_NAME, null, ConstantesBDD.DATAbASE_VERSION);
        this.context = context;

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascotas = "CREATE TABLE " + ConstantesBDD.TABLE_MASCOTAS + "(" +
                ConstantesBDD.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBDD.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                ConstantesBDD.TABLE_MASCOTAS_FOTO + " INTEGER"
                +")";

        String queryCrearUltimoLikes = "CREATE TABLE " + ConstantesBDD.TABLE_MASCOTAS_ULTIMOS_LIKE + "("+
                ConstantesBDD.TABLE_MASCOTAS_ULTIMOS_LIKE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBDD.TABLE_MASCOTAS_ULTIMOS_LIKE_ID_MASCOTA + " INTEGER, "+
                ConstantesBDD.TABLE_MASCOTAS_ULTIMOS_LIKE_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBDD.TABLE_MASCOTAS_ULTIMOS_LIKE_ID_MASCOTA + ") " +
                "REFERENCES " + ConstantesBDD.TABLE_MASCOTAS + "(" + ConstantesBDD.TABLE_MASCOTAS_ID + ")"
                + ")";


        db.execSQL(queryCrearTablaMascotas);
        db.execSQL(queryCrearUltimoLikes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBDD.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBDD.TABLE_MASCOTAS_ULTIMOS_LIKE);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBDD.TABLE_MASCOTAS;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros = db.rawQuery(query,null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setCvNombre(registros.getString(1));
            mascotaActual.setImgFotoMascota(registros.getInt(2));
            mascotaActual.setCvContadorLikes("0");
            mascotaActual.setCvIconoLike(R.drawable.icons8_dog_bone_50_1);
            mascotaActual.setImgIconoLike(R.drawable.icons8_dog_bone_80);
            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public ArrayList<Mascota> obtenerFavMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT DISTINCT " + ConstantesBDD.TABLE_MASCOTAS + ".*" +  ", "+
                        ConstantesBDD.TABLE_MASCOTAS_ULTIMOS_LIKE+ "." + ConstantesBDD.TABLE_MASCOTAS_ULTIMOS_LIKE_LIKES +
                        " FROM " + ConstantesBDD.TABLE_MASCOTAS +"," +
                        ConstantesBDD.TABLE_MASCOTAS_ULTIMOS_LIKE +
                        " WHERE " + ConstantesBDD.TABLE_MASCOTAS + "." + ConstantesBDD.TABLE_MASCOTAS_ID + "=" +
                                    ConstantesBDD.TABLE_MASCOTAS_ULTIMOS_LIKE + "." + ConstantesBDD.TABLE_MASCOTAS_ULTIMOS_LIKE_ID_MASCOTA +
                        " ORDER BY " + ConstantesBDD.TABLE_MASCOTAS + ".id DESC LIMIT 5";
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros = db.rawQuery(query,null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setCvNombre(registros.getString(1));
            mascotaActual.setImgFotoMascota(registros.getInt(2));
            mascotaActual.setCvContadorLikes(String.valueOf(registros.getInt(3)));
            mascotaActual.setCvIconoLike(R.drawable.icons8_dog_bone_50_1);
            mascotaActual.setImgIconoLike(R.drawable.icons8_dog_bone_80);
            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues content){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBDD.TABLE_MASCOTAS,null,content);
        db.close();
    }

    public void insertarLikeMascota(ContentValues content) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBDD.TABLE_MASCOTAS_ULTIMOS_LIKE, null, content);
        db.close();
    }

    public int obtenerLike(Mascota mascota){
        int likes=0;

        String query = "SELECT COUNT(" + ConstantesBDD.TABLE_MASCOTAS_ULTIMOS_LIKE_LIKES + ")" +
                        " FROM " + ConstantesBDD.TABLE_MASCOTAS_ULTIMOS_LIKE +
                        " WHERE " + ConstantesBDD.TABLE_MASCOTAS_ULTIMOS_LIKE_ID + "= " + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros = db.rawQuery(query,null);

        if (registros.moveToNext()){
           likes = registros.getInt(0);
        }
        db.close();
        return likes;
    }
}


