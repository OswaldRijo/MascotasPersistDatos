package com.oswald.mascotas.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oswald.mascotas.R;
import com.oswald.mascotas.adapters.MascotaAdapter;
import com.oswald.mascotas.adapters.PerfilAdapter;
import com.oswald.mascotas.pojo.Mascota;

import java.util.ArrayList;
import java.util.Random;


public class PerfilFragment extends Fragment {


    public PerfilFragment() {
        super();
    }
    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private PerfilAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvPerfil);

        GridLayoutManager llm = new GridLayoutManager(getActivity(),3);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        setMascotas();
        adapter = new PerfilAdapter(mascotas,getActivity());
        listaMascotas.setAdapter(adapter);

        return v;
    }

    public void setMascotas(){
        mascotas = new ArrayList<>();

        int random = (int) (Math.random() * 10) + 1;
        for(int i = 0; i<random;i++){
            int randomLike = (int) (Math.random() * 21);
            mascotas.add(new Mascota(R.drawable.snoopy,"Snoopy",
                String.valueOf(randomLike),R.drawable.icons8_dog_bone_50_1,R.drawable.icons8_dog_bone_80));
        }


    }

}
