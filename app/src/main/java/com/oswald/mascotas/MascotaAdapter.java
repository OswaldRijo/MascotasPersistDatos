package com.oswald.mascotas;

import android.app.Activity;
import android.content.Intent;
import android.opengl.Visibility;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by oswal on 24/12/2017.
 */

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    ArrayList<Mascota> mascotasFavoritas;
    Activity activity;

    boolean b;


    public MascotaAdapter (ArrayList<Mascota> mascotas, boolean b,Activity activity){
        this.mascotas = mascotas;
        mascotasFavoritas = new ArrayList<>();
        this.activity= activity;
        this.b = b;
    }


    public MascotaAdapter (ArrayList<Mascota> mascotas,Activity activity){
        this.mascotas = mascotas;
        mascotasFavoritas = new ArrayList<>();
        this.b = false;
        this.activity= activity;
    }


    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflater = LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.cardview_mascotaliked,parent,false);
        return new MascotaViewHolder(inflater);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, final int position) {

            final Mascota mascota = mascotas.get(position);
            mascotaViewHolder.cvContadorLikes.setText(mascota.getCvContadorLikes());
            mascotaViewHolder.cvIconoLike.setImageResource(mascota.getCvIconoLike());
            mascotaViewHolder.imgIconoLike.setImageResource(mascota.getImgIconoLike());
            mascotaViewHolder.imgFotoMascota.setImageResource(mascota.getImgFotoMascota());
            mascotaViewHolder.cvNombre.setText(mascota.getCvNombre());
        if (activity instanceof Favoritos){
            mascotaViewHolder.imgIconoLike.setVisibility(View.GONE);
        }else{
            mascotaViewHolder.imgIconoLike.setVisibility(View.VISIBLE);
        }
        if(b){
            mascotaViewHolder.cvContadorLikes.setVisibility(View.VISIBLE);
            mascotaViewHolder.cvIconoLike.setVisibility(View.VISIBLE);
        }

        mascotaViewHolder.imgIconoLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int aux = 0;
                aux = Integer.valueOf(mascota.getCvContadorLikes().toString());
                aux++;
                mascota.setCvContadorLikes(String.valueOf(aux));
                mascotaViewHolder.cvContadorLikes.setText(String.valueOf(aux));
                mascotaViewHolder.cvContadorLikes.setVisibility(View.VISIBLE);
                mascotaViewHolder.cvIconoLike.setVisibility(View.VISIBLE);
                if (activity instanceof MainActivity){

                    if(mascotasFavoritas.contains(mascota)){
                        mascotasFavoritas.remove(mascota);
                    }
                    mascotasFavoritas.add(mascota);
                    if(mascotasFavoritas.size()>5){
                       mascotasFavoritas.remove(0);
                    }
                }


            }
        });

    }



    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFotoMascota;
        private ImageView imgIconoLike;
        private AppCompatTextView cvContadorLikes;
        private AppCompatTextView cvNombre;
        private ImageView cvIconoLike;



        public MascotaViewHolder(View itemView) {
            super(itemView);

            this.imgFotoMascota    = (ImageView) itemView.findViewById(R.id.imgFotoMascota);
            this.imgIconoLike      = (ImageView) itemView.findViewById(R.id.imgIconoLike);
            this.cvContadorLikes   = (AppCompatTextView) itemView.findViewById(R.id.cvContadorLikes);
            this.cvNombre          = (AppCompatTextView) itemView.findViewById(R.id.cvNombre);
            this.cvIconoLike       = (ImageView) itemView.findViewById(R.id.cvIconoLike);



        }

    }
}
