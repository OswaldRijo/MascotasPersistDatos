package com.oswald.mascotas.fragments;

import com.oswald.mascotas.adapters.MascotaAdapter;
import com.oswald.mascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by oswal on 7/1/2018.
 */

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdapter crearMascotas(ArrayList<Mascota> mascotas);

    public void InicializarAdaptadorRV(MascotaAdapter adaptador);
}
