package com.oswald.mascotas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.oswald.mascotas.adapters.PagerAdapter;
import com.oswald.mascotas.fragments.PerfilFragment;
import com.oswald.mascotas.fragments.RecyclerViewFragment;
import com.oswald.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private ArrayList <Mascota> mascotas;
    private RecyclerView listaMascotas;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();


        if(toolbar!=null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("");
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menuContacto:
                startContacto();
                return true;


            case R.id.menuAcercaDE:
                startAcercade();
                return true;

            case R.id.menuFav:
                startFavoritos();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private  ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;

    }

    private void setUpViewPager() {
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager(),agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_perfil);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);

    }

    private void startContacto (){
        Intent intento = new Intent(this, SendingMail.class);
        startActivity(intento);
    }

    private void startAcercade (){
        Intent intento = new Intent(this, AcercaDe.class);
        startActivity(intento);
    }

    private void startFavoritos (){
        Intent intento = new Intent(this, Favorito.class);
        startActivity(intento);
    }
}
