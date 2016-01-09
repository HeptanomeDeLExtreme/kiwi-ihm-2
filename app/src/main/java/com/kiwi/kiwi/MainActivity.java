/**
 * Activité principale de l'application, composée de deux fragments
 *
 * @author Ealhad
 */

package com.kiwi.kiwi;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.kiwi.kiwi.model.Avis;
import com.kiwi.kiwi.model.Categorie;
import com.kiwi.kiwi.model.Resto;

import java.util.ArrayList;
import java.util.List;
import com.google.android.gms.maps.model.LatLng;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static List<Resto> listeRestos;
    private FragmentManager mFragmentManager;
    private MainFragment mainFragment;
    private AmisFragment amisFragment;
    private ProfilFragment profilFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mFragmentManager = getSupportFragmentManager();

        mainFragment = new MainFragment();

        listeRestos = genererRestos();

        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.container_view, mainFragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * Gère les clics sur le menu
     *
     * @param item l'élément de menu sélectionné
     * @return true
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        FragmentTransaction transaction = mFragmentManager.beginTransaction();

        if (id == R.id.nav_liste) {
            if (mainFragment == null) mainFragment = new MainFragment();
            transaction.replace(R.id.container_view, mainFragment);
        } else if (id == R.id.nav_amis) {
            if (amisFragment == null) amisFragment = new AmisFragment();
            transaction.replace(R.id.container_view, amisFragment);
        } else if (id == R.id.nav_profil) {
            if (profilFragment == null) profilFragment = new ProfilFragment();
            transaction.replace(R.id.container_view, profilFragment);
        } else if (id == R.id.nav_compte) {
            //TODO
        }

        transaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private List<Resto> genererRestos() {
        List<Resto> restos = new ArrayList<>();
/*        restos.add(new Resto("", "C 'n P", true));
        restos.add(new Resto("", "Snoop", true));
        restos.add(new Resto("", "RU", true));
        restos.add(new Resto("", "Chez Cédric", false));*/

        List<Avis> avisResto1 = new ArrayList<Avis>();
        avisResto1.add(new Avis(0,"Ce n'est pas terrible...","Secret Mathieu"));
        restos.add(new Resto("Castor et Pollux", "CastorEtPollux.jpg", true, "Avenue Jean Capelle", "Carte Etudiant",
                "06 69 69 69 69", "4,20€", "4", "11h30 -14h",
                Categorie.getUniversitaire(), "Universitaire", "Soupe de quinoa", avisResto1,
                45.781206, 4.873504, 3.5,7, "Restaurant universaire bon marché. \n Appelé affectueuse le beurk.", true));

        restos.add(new Resto("Prévert", "Prevert.jpg", true, "Avenue Jean Capelle", "Carte Etudiant",
                        "06 69 69 69 69", "4,20€", "4", "11h30 -14h",
                        Categorie.getUniversitaire(), "Universitaire", "Nouilles", avisResto1,
                        45.781109, 4.873279, 3.5, 7, "Restaurant universaire bon marché. \n", true));
        restos.add(new Resto("Grillon", "Grillon.jpg", true, "Avenue des Arts", "Carte Etudiant",
                    "06 69 69 69 69", "4,20€", "4", "11h30 -14h",
                    Categorie.getUniversitaire(), "Universitaire", "Poisson pânée", avisResto1,
                    45.783876, 4.875049, 3.5,7, "Restaurant universaire bon marché. \n", true));

        restos.add(new Resto("Olivier", "Olivier.jpg", true, "Avenue des Arts", "Carte Etudiant",
                        "06 69 69 69 69", "4,20€", "4", "11h30 -14h",
                        Categorie.getUniversitaire(), "Universitaire", "Millefeuille", avisResto1,
                        45.784249, 4.874854 , 3.5,7, "Restaurant universaire bon marché. \n", true));
        restos.add(new Resto("Jussieu", "Jussieu.jpg", true, "Avenue Albert Einstein", "Carte Etudiant",
                        "06 69 69 69 69", "4,20€", "4", "11h30 -14h",
                        Categorie.getUniversitaire(), "Universitaire", "Glace à la fraise et au chocolat", avisResto1,
                        45.780981, 4.876224, 3.5,7, "Restaurant universaire bon marché. \n Appelé affectueuse le RU.", true));

        restos.add(new Resto("Snack du Campus", "Tacos.jpg", true, "Rue de la Doua", "Carte Etudiant",
                        "06 25 17 86 71", "10,20€", "4", "11h00 - 14h, 18h00 - 23h00",
                        Categorie.getTacos(), "Universitaire", "Tacos", avisResto1,
                        45.777149, 4.874541, 3.5,7, "Restaurant de tacos très bon !", true));
        restos.add(new Resto("Pizzeria Pinocchio", "PizzeriaPinocchio.jpg", true, "Boulevard du 11 Novembre 1918", "Carte Etudiant",
                    "06 69 69 69 69", "4,20€", "4", "11h30 -14h",
                    Categorie.getPizzeria(), "Universitaire", "Pizza au poulpe", avisResto1,
                    45.779272, 4.874409, 3.5,7, "Bonnes pizzas.", true));

        restos.add(new Resto("NoGlu", "NoGlu.jpg", true, "Avenue Jean Capelle", "Carte Etudiant",
                        "06 69 69 69 69", "4,20€", "4", "11h30 -14h",
                        Categorie.getUniversitaire(), "Universitaire", "Soupe de vermicelle", avisResto1,
                        45.778888, 4.874545, 3.5,7, "Restaurant universaire bon marché. \n Appelé affectueuse le noeud.", true));
        restos.add(new Resto("Restaurant U", "RestaurantU.jpg", true, "Avenue Jean Capelle", "Carte Etudiant",
                        "06 69 69 69 69", "4,20€", "4", "11h30 -14h",
                        Categorie.getUniversitaire(), "Universitaire", "Sandwich", avisResto1,
                        45.781110, 4.873504, 3.5,7, "Restaurant universitaire très très bon marché", true));

        restos.add(new Resto("Les milles et une nuits", "MilleEtUneNuits.jpg", true, "Avenue Jean Capelle", "Carte Etudiant",
                        "06 69 69 69 69", "4,20€", "4", "11h30 -14h",
                        Categorie.getOriental(), "Oriental", "Miel et chèvre", avisResto1,
                        45.781206, 4.873508, 3.5,7, "C'est un restaurant oriental.", true));
        restos.add(new Resto("Indiana", "Indiana.jpg", true, "Avenue Jean Capelle", "Carte Etudiant",
                "06 69 69 69 69", "4,20€", "4", "11h30 -14h",
                Categorie.getIndien(), "Indien", "Spécial", avisResto1,
                45.781220, 4.873504, 3.5, 7, "Bonne cuisine indienne.", true));

        restos.add(new Resto("Sandwich'In", "SandwichIn.jpg", true, "Avenue Jean Capelle", "Carte Etudiant",
                "06 69 69 69 69", "4,20€", "4", "11h30 -14h",
                Categorie.getSandwich(), "Sandwicherie", "Sandwich au poulet", avisResto1,
                45.781250, 4.873504, 3.5, 7, "Sandwicherie !", true));


        return restos;
    }


    public void goToResto(View v){
        Log.i("Debug", "go to resto");
        Toast.makeText(getApplicationContext(), "Restaurant !", Toast.LENGTH_SHORT).show();
    }

    public static Context getApplicationContent(){
        return getApplicationContent();
    }
}
