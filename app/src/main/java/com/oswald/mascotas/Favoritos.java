package com.oswald.mascotas;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Favoritos extends AppCompatActivity {
    private MascotaAdapter adapter;
    private RecyclerView listaMascotas;
    TextView tv;
    Intent intento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        Toolbar toolbar = findViewById(R.id.miFavActionBar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(R.string.app_name);


        listaMascotas = (RecyclerView) findViewById(R.id.rvFavoritos);
        LinearLayoutManager llm = new LinearLayoutManager(this);

        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        adapter =  new MascotaAdapter((ArrayList<Mascota>) getIntent().getExtras().get("favoritos"),true,this);
        adapter.mascotasFavoritas = (ArrayList<Mascota>) getIntent().getExtras().get("mascotas");
        listaMascotas.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        int val=1;
        intento = new Intent();
        intento.putExtra("favoritos", adapter.mascotas);
        intento.putExtra("mascotas", adapter.mascotasFavoritas);
        intento.putExtra("val",val);
        setResult(RESULT_OK, intento);
        super.onBackPressed();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
