/**
 * Activité principale de l'application, composée de deux fragments
 *
 * @author Ealhad
 */

package com.kiwi.kiwi;

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

import com.kiwi.kiwi.model.Ami;
import com.kiwi.kiwi.model.Avis;
import com.kiwi.kiwi.model.Categorie;
import com.kiwi.kiwi.model.Filtre;
import com.kiwi.kiwi.model.Resto;

import java.util.ArrayList;
import java.util.List;
import com.google.android.gms.maps.model.LatLng;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static ArrayList<Resto> listeRestos;
    public static ArrayList<Resto> listeRestosVisibles;
    public static Filtre filtre;

    public static List<Ami> listeAmis;

    private FragmentManager mFragmentManager;
    private MainFragment mainFragment;
    private AmiFragment amisFragment;
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
        listeRestosVisibles = (ArrayList) listeRestos.clone();
        filtre = new Filtre();
        listeAmis = genererAmis();

        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.container_view, mainFragment);
        transaction.commit();
    }

    private List<Ami> genererAmis() {
        List<Resto> restos = MainActivity.listeRestos;
        List<Ami> list = new ArrayList<>();
        list.add(new Ami("Bonfante", "Nicolas", "Bonfante", 3.5, 7, restos.get(0)));
        list.add(new Ami("Nadisic", "Nicolas", "nicolas", 3.5, 7, restos.get(1)));
        list.add(new Ami("Delsaux", "Ophelie", "ophelie", 6, 4, restos.get(2)));
        list.add(new Ami("Chalumeau", "Marion", "marion", 5, 4, restos.get(2)));
        list.add(new Ami("Delacombe", "Charles", "charles", 10, 4, restos.get(7)));
        list.add(new Ami("Boscher", "Cédric", "cedric", 8, 4, restos.get(5)));
        return list;
    }

    @Override
    public void onBackPressed() {
        /*DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }*/

        FragmentTransaction transaction = mFragmentManager.beginTransaction();

        if (mainFragment == null) mainFragment = new MainFragment();
        transaction.replace(R.id.container_view, mainFragment);

        transaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
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
            if (amisFragment == null) amisFragment = new AmiFragment();
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

    private ArrayList<Resto> genererRestos() {
        ArrayList<Resto> restos = new ArrayList<>();

        //TODO aucun sens de donner un temps/distance par ami, on peut le récup dans le resto de l'ami
        Ami ami1 = new Ami("Secret","Mathieu","photo.png",12,13);
        Ami ami2 = new Ami("Andra","Alexis","photo.png",12,13);
        Ami ami3 = new Ami("Fuerte","El Rodriguo","photo.png",12,13);
        

        List<Avis> avisResto1 = new ArrayList<>();
        avisResto1.add(new Avis(0,"Ce n'est pas terrible...",ami1));
        
        List<Avis> avisResto2 = new ArrayList<>();
        avisResto2.add(new Avis(3,"DADADADADAM ! Un coup de barre ? Un tacos et ça repart ! (Le serveur m'insulte à chaque fois.)",ami2));
        avisResto2.add(new Avis(5,"Je n'oublierai jamais les soirées que Snoop Dogg et son crew m'ont fait passer au Snack du Campus !!!",ami2));

		List<Avis> avisResto2 = new ArrayList<>();
		
        restos.add(new Resto("Castor et Pollux", "resto1", true, "Avenue Jean Capelle", Resto.Paiement.INSA,
                "06 69 69 69 69", "€", "4", "11h30 -14h",
                Categorie.UNIVERSITAIRE, "Universitaire", "Soupe de quinoa", avisResto1,
                45.781206, 4.873504, 3.5, 7, "Restaurant universaire bon marché. \n Appelé affectueusement le beurk.",41,true));


        restos.add(new Resto("Prévert", "resto2", true, "Avenue Jean Capelle", Resto.Paiement.INSA,
                "06 69 69 69 69", "€", "4", "11h30 -14h",
                Categorie.UNIVERSITAIRE, "Universitaire", "Nouilles", avisResto1,
                45.781109, 4.873279, 3.5, 7, "Restaurant universaire bon marché. \n",41,true));

        restos.add(new Resto("Grillon", "resto3", true, "Avenue des Arts", Resto.Paiement.INSA,
                "06 69 69 69 69", "€", "4", "11h30 -14h",
                Categorie.UNIVERSITAIRE, "Universitaire", "Poisson pâné", avisResto1,
                45.783876, 4.875049, 6, 7, "Restaurant universaire bon marché. \n",41,true));

        restos.add(new Resto("Olivier", "resto5", true, "Avenue des Arts", Resto.Paiement.INSA,
                "06 69 69 69 69", "€", "4", "11h30 -14h",
                Categorie.UNIVERSITAIRE, "Universitaire", "Millefeuille", avisResto1,
                45.784249, 4.874854, 5, 7, "Restaurant universaire bon marché. \n",41,true));
        restos.add(new Resto("Jussieu", "resto6", false, "Avenue Albert Einstein", Resto.Paiement.IZLY,
                "06 69 69 69 69", "€", "4", "11h30 -14h",
                Categorie.UNIVERSITAIRE, "Universitaire", "Glace à la fraise et au chocolat", avisResto1,
                45.780981, 4.876224, 4, 7, "Restaurant universaire bon marché. \n Appelé affectueusement le RU.",41,true));

        restos.add(new Resto("Snack du Campus", "resto4", true, "Rue de la Doua", Resto.Paiement.CB,
                "06 25 17 86 71", "€€", "4", "11h00 - 14h, 18h00 - 23h00",
                Categorie.TACOS, "Universitaire", "Tacos", avisResto2,
                45.777149, 4.874541, 8, 7, "Restaurant de tacos de qualité ! Appelé affectueusement Chez Snoop",41,true));

        restos.add(new Resto("Pizzeria Pinocchio", "resto9", true, "Boulevard du 11 Novembre 1918", Resto.Paiement.CB,
                "06 69 69 69 69", "€€", "4", "11h30 -14h",
                Categorie.PIZZERIA, "Universitaire", "Pizza au poulpe", avisResto3,
                45.779272, 4.874409, 10, 7, "Bonnes pizzas.",41,true));

        restos.add(new Resto("NoGlu", "resto7", false, "Avenue Jean Capelle", Resto.Paiement.CB,
                "06 69 69 69 69", "€€€", "4", "11h30 -14h",
                Categorie.UNIVERSITAIRE, "Universitaire", "Soupe de vermicelle", avisResto1,
                45.778888, 4.874545, 11, 7, "Restaurant universaire bon marché. \n Appelé affectueusement le noeud.",41,true));


        return restos;
    }


    public void goToResto(View v) {
        Log.i("Debug", "go to resto");
        Toast.makeText(getApplicationContext(), "Restaurant !", Toast.LENGTH_SHORT).show();
    }

}
