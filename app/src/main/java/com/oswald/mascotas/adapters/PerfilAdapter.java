package com.oswald.mascotas.adapters;

import android.app.Activity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.oswald.mascotas.R;
import com.oswald.mascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by oswal on 31/12/2017.
 */

public class PerfilAdapter extends RecyclerView.Adapter<PerfilAdapter.PerfilViewHolder>{

        ArrayList<Mascota> mascotas;

        Activity activity;

        boolean b;


    public PerfilAdapter(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;

        this.b = false;
        this.activity= activity;
    }


    @Override
    public PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflater = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.cardview_mascotaliked,parent,false);
        return new PerfilViewHolder(inflater);
    }

    @Override
    public void onBindViewHolder(final PerfilViewHolder mascotaViewHolder, final int position) {

        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.cvContadorLikes.setText(mascota.getCvContadorLikes());
        mascotaViewHolder.cvContadorLikes.setVisibility(View.VISIBLE);
        mascotaViewHolder.cvIconoLike.setImageResource(mascota.getCvIconoLike());
        mascotaViewHolder.cvIconoLike.setVisibility(View.VISIBLE);
        mascotaViewHolder.imgIconoLike.setImageResource(mascota.getImgIconoLike());
        mascotaViewHolder.imgIconoLike.setVisibility(View.GONE);
        mascotaViewHolder.imgFotoMascota.setImageResource(mascota.getImgFotoMascota());
        mascotaViewHolder.cvNombre.setText(mascota.getCvNombre());
        mascotaViewHolder.cvNombre.setVisibility(View.GONE);


    }



    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public class PerfilViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFotoMascota;
        private ImageView imgIconoLike;
        private AppCompatTextView cvContadorLikes;
        private AppCompatTextView cvNombre;
        private ImageView cvIconoLike;



        public PerfilViewHolder(View itemView) {
            super(itemView);

            this.imgFotoMascota    = (ImageView) itemView.findViewById(R.id.imgFotoMascota);
            this.imgIconoLike      = (ImageView) itemView.findViewById(R.id.imgIconoLike);
            this.cvContadorLikes   = (AppCompatTextView) itemView.findViewById(R.id.cvContadorLikes);
            this.cvNombre          = (AppCompatTextView) itemView.findViewById(R.id.cvNombre);
            this.cvIconoLike       = (ImageView) itemView.findViewById(R.id.cvIconoLike);

        }
    }
}

