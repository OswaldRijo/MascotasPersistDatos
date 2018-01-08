package com.oswald.mascotas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.oswald.mascotas.adapters.MascotaAdapter;
import com.oswald.mascotas.db.GeneradorContactos;
import com.oswald.mascotas.pojo.Mascota;

import java.util.ArrayList;


public class Favorito extends AppCompatActivity {
    private MascotaAdapter adapter;
    private RecyclerView listaMascotas;
    private GeneradorContactos generadorContactos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorito);
        Toolbar toolbar = findViewById(R.id.miFavActionBar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(R.string.app_name);

        listaMascotas = findViewById(R.id.rvFavoritos);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        generadorContactos = new GeneradorContactos(this);

        ArrayList<Mascota> mascotas = generadorContactos.obtenerFav();

        adapter =  new MascotaAdapter(mascotas,true,this);
        listaMascotas.setAdapter(adapter);

    }
}
