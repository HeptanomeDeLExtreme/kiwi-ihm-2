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
import android.view.MenuItem;

import com.kiwi.kiwi.model.Ami;
import com.kiwi.kiwi.model.Avis;
import com.kiwi.kiwi.model.Categorie;
import com.kiwi.kiwi.model.Filtre;
import com.kiwi.kiwi.model.Resto;

import java.util.ArrayList;
import java.util.List;


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

    private CompteFragmentINSA compteFragmentINSA;
    private CompteFragmentIZLY compteFragmentIZLY;

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
        NavigationView navigationViewRight = (NavigationView) findViewById(R.id.nav_view_right);
        navigationViewRight.setNavigationItemSelectedListener(this);

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

        Ami ami1 = new Ami("Bonfante", "Nicolas", "bonfante", 3, 7, restos.get(1));
        restos.get(1).ajouteAmi(ami1);
        list.add(ami1);

        Ami ami2 = new Ami("Nadisic", "Nicolas", "nicolas", 4, 7, restos.get(1));
        restos.get(1).ajouteAmi(ami2);
        list.add(ami2);

        Ami ami3 = new Ami("Delsaux", "Ophelie", "ophelie", 6, 4, restos.get(2));
        restos.get(2).ajouteAmi(ami3);
        list.add(ami3);

        Ami ami4 = new Ami("Chalumeau", "Marion", "marion", 5, 4, restos.get(2));
        restos.get(2).ajouteAmi(ami4);
        list.add(ami4);

        Ami ami5 = new Ami("Delacombe", "Charles", "charles", 10, 4, restos.get(7));
        restos.get(7).ajouteAmi(ami5);
        list.add(ami5);

        Ami ami6 = new Ami("Boscher", "Cédric", "cedric", 8, 4, restos.get(2));
        restos.get(2).ajouteAmi(ami6);
        list.add(ami6);
        return list;
    }

    @Override
    public void onBackPressed() {

        FragmentTransaction transaction = mFragmentManager.beginTransaction();

        if (mainFragment == null) mainFragment = new MainFragment();
        transaction.replace(R.id.container_view, mainFragment);

        transaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

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
        } else if (id == R.id.nav_prix) {
            mainFragment.triPrix();
            item.setCheckable(true);
            item.setChecked(true);
            updateView();
        } else if (id == R.id.nav_attente) {
            mainFragment.triAttente();
            item.setCheckable(true);
            item.setChecked(true);
            updateView();
        } else if (id == R.id.nav_aller) {
            mainFragment.triAller();
            item.setCheckable(true);
            item.setChecked(true);
            updateView();
        } else if (id == R.id.nav_compteINSA) {
            if (compteFragmentINSA == null) compteFragmentINSA = new CompteFragmentINSA();
            transaction.replace(R.id.container_view, compteFragmentINSA);
        } else if (id == R.id.nav_compteIZLY) {
            if (compteFragmentIZLY == null) compteFragmentIZLY = new CompteFragmentIZLY();
            transaction.replace(R.id.container_view, compteFragmentIZLY);
        }


        transaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void updateView() {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();

        if (mainFragment == null) mainFragment = new MainFragment();
        transaction.replace(R.id.container_view, mainFragment);

        transaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    private ArrayList<Resto> genererRestos() {
        ArrayList<Resto> restos = new ArrayList<>();

        Ami ami1 = new Ami("Secret", "Mathieu", "user43", 12, 13);
        Ami ami2 = new Ami("Andra", "Alexis", "user43", 12, 13);
        Ami ami3 = new Ami("Fuerte", "El Rodriguo", "user43" +
                "" +
                "", 12, 13);


        List<Avis> avisResto1 = new ArrayList<>();
        avisResto1.add(new Avis(0, "Ce n'est pas terrible...", ami1));

        List<Avis> avisResto2 = new ArrayList<>();
        avisResto2.add(new Avis(3, "DADADADADAM ! Un coup de barre ? Un tacos et ça repart ! (Le serveur m'insulte à chaque fois.)", ami3));
        avisResto2.add(new Avis(5, "Je n'oublierai jamais les soirées que Snoop Dogg et son crew m'ont fait passer au Snack du Campus !!!", ami2));

        List<Avis> avisResto3 = new ArrayList<>();

        restos.add(new Resto("Castor et Pollux", "resto1", true, "Avenue Jean Capelle", Resto.Paiement.INSA,
                "06 69 69 69 69", "€", "1", "11h30 -14h",
                Categorie.INSA, "Généraliste", "Soupe de quinoa", avisResto1,
                45.781206, 4.873504, 3.5, 8, "Restaurant universaire bon marché. \n Appelé affectueusement le beurk.", 41, true));

        restos.add(new Resto("Prévert", "resto2", true, "Avenue Jean Capelle", Resto.Paiement.INSA,
                "06 69 69 69 69", "€", "2", "11h30 -14h",
                Categorie.INSA, "Fast food", "Nouilles", avisResto1,
                45.781109, 4.873279, 3.5, 7, "Restaurant universaire bon marché. \n", 41, true));

        restos.add(new Resto("Grillon", "resto3", true, "Avenue des Arts", Resto.Paiement.INSA,
                "06 69 69 69 69", "€", "3", "11h30 -14h",
                Categorie.INSA, "Viandes grillées", "Poisson pâné", avisResto1,
                45.783876, 4.875049, 6.0, 6, "Restaurant universaire bon marché. \n", 41, true));

        restos.add(new Resto("Olivier", "resto5", true, "Avenue des Arts", Resto.Paiement.INSA,
                "06 69 69 69 69", "€", "4", "11h30 -14h",
                Categorie.INSA, "Italien", "Millefeuille", avisResto1,
                45.784249, 4.874854, 5.0, 5, "Restaurant universaire bon marché. \n", 41, true));
        restos.add(new Resto("Jussieu", "resto6", true, "Avenue Albert Einstein", Resto.Paiement.IZLY,
                "06 69 69 69 69", "€", "5", "11h30 -14h",
                Categorie.UNIVERSITAIRE, "Généraliste", "Glace à la fraise et au chocolat", avisResto1,
                45.780981, 4.876224, 4.0, 4, "Restaurant universaire bon marché. \n Appelé affectueusement le RU.", 41, true));

        restos.add(new Resto("Snack du Campus", "resto4", true, "Rue de la Doua", Resto.Paiement.CB,
                "06 25 17 86 71", "€€", "6", "11h00 - 14h, 18h00 - 23h00",
                Categorie.TACOS, "Externe", "Tacos", avisResto2,
                45.777149, 4.874541, 8.0, 3, "Restaurant de tacos de qualité ! Appelé affectueusement Chez Snoop", 41, true));

        restos.add(new Resto("Pizzeria Pinocchio", "resto9", false, "Boulevard du 11 Novembre 1918", Resto.Paiement.CB,
                "06 69 69 69 69", "€€", "7", "11h30 -14h",
                Categorie.PIZZERIA, "Externe", "Pizza au poulpe", avisResto3,
                45.779272, 4.874409, 10.0, 2, "Bonnes pizzas.", 41, true));

        restos.add(new Resto("NoGlu", "resto7", false, "Avenue Jean Capelle", Resto.Paiement.CB,
                "06 69 69 69 69", "€€€", "8", "11h30 -14h",
                Categorie.UNIVERSITAIRE, "Sans gluten", "Soupe de vermicelle", avisResto1,
                45.778888, 4.874545, 11.0, 1, "Restaurant universaire bon marché. \n Appelé affectueusement le noeud.", 41, true));

        return restos;
    }


}
