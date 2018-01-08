package com.oswald.mascotas.adapters;

import android.app.Activity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.oswald.mascotas.SendingMail;
import com.oswald.mascotas.MainActivity;
import com.oswald.mascotas.R;
import com.oswald.mascotas.db.GeneradorContactos;
import com.oswald.mascotas.pojo.Mascota;

import java.util.ArrayList;

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

            mascotaViewHolder.imgIconoLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    GeneradorContactos generadorContactos = new GeneradorContactos(activity);
                    generadorContactos.insertarLikes(mascota);
                    mascotaViewHolder.cvContadorLikes.setText(String.valueOf(generadorContactos.obtenerLikes(mascota)));

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
