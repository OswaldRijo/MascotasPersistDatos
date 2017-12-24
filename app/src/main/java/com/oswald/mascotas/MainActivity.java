package com.oswald.mascotas;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private ArrayList <Mascota> mascotas;
    private RecyclerView listaMascotas;
    MascotaAdapter adapter;
    String val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);


        ImageView favoritos = findViewById(R.id.abFavoritos);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);

        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        Bundle extra = getIntent().getExtras();
        try {
            val = String.valueOf(extra.getInt("val"));
        }catch (Exception e){

        }finally {
            if (!(val == null)) {
                ArrayList<Mascota> mascotasIntento = new ArrayList<>();
                ArrayList<Mascota> masc = (ArrayList<Mascota>) getIntent().getExtras().get("mascotas");

                mascotasIntento.add(new Mascota(R.drawable.ayudante_de_santa, "Ayudante de santa",
                        masc.get(0).getCvContadorLikes(), R.drawable.icons8_dog_bone_50_1, R.drawable.icons8_dog_bone_80));

                mascotasIntento.add(new Mascota(R.drawable.corageperrocobarde, "Corage el perro Cobarde",
                        masc.get(1).getCvContadorLikes(), R.drawable.icons8_dog_bone_50_1, R.drawable.icons8_dog_bone_80));

                mascotasIntento.add(new Mascota(R.drawable.droopy_dog, "Droopy",
                        masc.get(2).getCvContadorLikes(), R.drawable.icons8_dog_bone_50_1, R.drawable.icons8_dog_bone_80));

                mascotasIntento.add(new Mascota(R.drawable.pluto, "Pluto",
                        masc.get(3).getCvContadorLikes(), R.drawable.icons8_dog_bone_50_1, R.drawable.icons8_dog_bone_80));

                mascotasIntento.add(new Mascota(R.drawable.puffy, "Puffy aplicacion",
                        masc.get(4).getCvContadorLikes(), R.drawable.icons8_dog_bone_50_1, R.drawable.icons8_dog_bone_80));

                mascotasIntento.add(new Mascota(R.drawable.ren, "Ren (ren & Stimpy)",
                        masc.get(5).getCvContadorLikes(), R.drawable.icons8_dog_bone_50_1, R.drawable.icons8_dog_bone_80));

                mascotasIntento.add(new Mascota(R.drawable.scoobydoo, "Scooby-doo",
                        masc.get(6).getCvContadorLikes(), R.drawable.icons8_dog_bone_50_1, R.drawable.icons8_dog_bone_80));

                mascotasIntento.add(new Mascota(R.drawable.snoopy, "Snoopy",
                        masc.get(7).getCvContadorLikes(), R.drawable.icons8_dog_bone_50_1, R.drawable.icons8_dog_bone_80));

                mascotasIntento.add(new Mascota(R.drawable.spike, "Spike",
                        masc.get(8).getCvContadorLikes(), R.drawable.icons8_dog_bone_50_1, R.drawable.icons8_dog_bone_80));
                adapter = new MascotaAdapter(mascotasIntento, true,this);
                listaMascotas.setAdapter(adapter);
            } else {
                setMascotas();
                adapter = new MascotaAdapter(mascotas,this);
                listaMascotas.setAdapter(adapter);
            }


            final Intent intento = new
                    Intent(this, Favoritos.class);

            favoritos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (adapter.mascotasFavoritas.size() != 0) {
                        intento.putExtra("favoritos", adapter.mascotasFavoritas);
                        intento.putExtra("mascotas", adapter.mascotas);
                        MainActivity.super.startActivity(intento);
                    }

                }
            });

            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setTitle(R.string.app_name);
        }
    }

    public void setMascotas(){
        mascotas = new ArrayList<>();


        mascotas.add(new Mascota(R.drawable.ayudante_de_santa,"Ayudante de santa",
                "0",R.drawable.icons8_dog_bone_50_1,R.drawable.icons8_dog_bone_80));

        mascotas.add(new Mascota(R.drawable.corageperrocobarde,"Corage el perro Cobarde",
                "0",R.drawable.icons8_dog_bone_50_1,R.drawable.icons8_dog_bone_80));

        mascotas.add(new Mascota(R.drawable.droopy_dog,"Droopy",
                "0",R.drawable.icons8_dog_bone_50_1,R.drawable.icons8_dog_bone_80));

        mascotas.add(new Mascota(R.drawable.pluto,"Pluto",
                "0",R.drawable.icons8_dog_bone_50_1,R.drawable.icons8_dog_bone_80));

        mascotas.add(new Mascota(R.drawable.puffy,"Puffy aplicacion",
                "0",R.drawable.icons8_dog_bone_50_1,R.drawable.icons8_dog_bone_80));

        mascotas.add(new Mascota(R.drawable.ren,"Ren (ren & Stimpy)",
                "0",R.drawable.icons8_dog_bone_50_1,R.drawable.icons8_dog_bone_80));

        mascotas.add(new Mascota(R.drawable.scoobydoo,"Scooby-doo",
                "0",R.drawable.icons8_dog_bone_50_1,R.drawable.icons8_dog_bone_80));

        mascotas.add(new Mascota(R.drawable.snoopy,"Snoopy",
                "0",R.drawable.icons8_dog_bone_50_1,R.drawable.icons8_dog_bone_80));

        mascotas.add(new Mascota(R.drawable.spike,"Spike",
                "0",R.drawable.icons8_dog_bone_50_1,R.drawable.icons8_dog_bone_80));
    }
}
