package com.oswald.mascotas.db;

import android.content.ContentValues;
import android.content.Context;

import com.oswald.mascotas.R;
import com.oswald.mascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by oswal on 7/1/2018.
 */

public class GeneradorContactos {

    private Context context;

    public GeneradorContactos(Context context) {

        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        BaseDatos db = new BaseDatos(context);
        insertMascota(db);
        return db.obtenerMascotas();
    }

    public ArrayList<Mascota> obtenerFav(){
        BaseDatos db = new BaseDatos(context);

        return db.obtenerFavMascotas();
    }

    public int obtenerLikes(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLike(mascota);
    }

    public void insertMascota(BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBDD.TABLE_MASCOTAS_NOMBRE, "Ayudante de santa");
        contentValues.put(ConstantesBDD.TABLE_MASCOTAS_FOTO, R.drawable.ayudante_de_santa);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBDD.TABLE_MASCOTAS_NOMBRE, "Corage");
        contentValues.put(ConstantesBDD.TABLE_MASCOTAS_FOTO, R.drawable.corageperrocobarde);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBDD.TABLE_MASCOTAS_NOMBRE,"Droopy");
        contentValues.put(ConstantesBDD.TABLE_MASCOTAS_FOTO, R.drawable.droopy_dog);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBDD.TABLE_MASCOTAS_NOMBRE, "Pluto");
        contentValues.put(ConstantesBDD.TABLE_MASCOTAS_FOTO, R.drawable.pluto);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBDD.TABLE_MASCOTAS_NOMBRE, "Puffy");
        contentValues.put(ConstantesBDD.TABLE_MASCOTAS_FOTO, R.drawable.puffy);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBDD.TABLE_MASCOTAS_NOMBRE, "Ren");
        contentValues.put(ConstantesBDD.TABLE_MASCOTAS_FOTO, R.drawable.ren);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBDD.TABLE_MASCOTAS_NOMBRE, "Scooby-Doo");
        contentValues.put(ConstantesBDD.TABLE_MASCOTAS_FOTO, R.drawable.scoobydoo);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBDD.TABLE_MASCOTAS_NOMBRE, "Snoopy");
        contentValues.put(ConstantesBDD.TABLE_MASCOTAS_FOTO, R.drawable.snoopy);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBDD.TABLE_MASCOTAS_NOMBRE, "Spike");
        contentValues.put(ConstantesBDD.TABLE_MASCOTAS_FOTO, R.drawable.spike);
        db.insertarMascota(contentValues);
    }

    public void insertarLikes(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBDD.TABLE_MASCOTAS_ULTIMOS_LIKE_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBDD.TABLE_MASCOTAS_ULTIMOS_LIKE_LIKES, 1);
        db.insertarLikeMascota(contentValues);
    }
}
