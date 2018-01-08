package com.oswald.mascotas.presentador;

import android.content.Context;


import com.oswald.mascotas.db.GeneradorContactos;
import com.oswald.mascotas.fragments.IRecyclerViewFragmentView;
import com.oswald.mascotas.pojo.Mascota;


import java.util.ArrayList;

/**
 * Created by oswal on 7/1/2018.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private GeneradorContactos generadorContactos;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView1, Context context1) {

        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView1;
        this.context = context1;
        obtenerContactosBDD();
    }

    @Override
    public void obtenerContactosBDD() {
        generadorContactos  = new GeneradorContactos(context);
        mascotas = generadorContactos.obtenerDatos();
        mostrarCOntactosRV();

    }

    @Override
    public void mostrarCOntactosRV() {
        iRecyclerViewFragmentView.InicializarAdaptadorRV(iRecyclerViewFragmentView.crearMascotas(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();

    }
    public IRecyclerViewFragmentView getiRecyclerViewFragmentView() {
        return iRecyclerViewFragmentView;
    }

    public void setiRecyclerViewFragmentView(IRecyclerViewFragmentView iRecyclerViewFragmentView) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public GeneradorContactos getGeneradorContactos() {
        return generadorContactos;
    }

    public void setGeneradorContactos(GeneradorContactos generadorContactos) {
        this.generadorContactos = generadorContactos;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }


}
