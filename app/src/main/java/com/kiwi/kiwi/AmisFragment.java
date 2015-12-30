/**
 * Fragment contenant la liste des restaurants et les informations utiles associées
 *
 * @author Ealhad
 */
package com.kiwi.kiwi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.kiwi.kiwi.model.Ami;
import com.kiwi.kiwi.model.AmiAdapter;
import com.kiwi.kiwi.model.Avis;
import com.kiwi.kiwi.model.Categorie;
import com.kiwi.kiwi.model.Resto;
import com.kiwi.kiwi.model.RestoAdapter;

import java.util.ArrayList;
import java.util.List;

public class AmisFragment extends Fragment {

    public static final String tag = "amis_frag";

    public AmisFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView mListView = (ListView) view.findViewById(R.id.listView);

        List<Ami> amis = genererAmis();

        AmiAdapter adapter = new AmiAdapter(getContext(), amis);
        mListView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    private List<Avis> genererAvis() {
        Avis bonAvis = new Avis(10, "Très bon restaurant", "lolilol");
        Avis mauvaisAvis = new Avis(0, "Restaurant très nul", "plop");
        Avis moyenAvis = new Avis(5, "Restaurant mooyen", "ahMazette");
        Avis encoreUnBonAvis = new Avis(8, "J'ai bien aimé manger ici !", "Croupiong");
        Avis excellentAvis = new Avis(10, "Ah meu Deus do ceu, exelente restaurant !!", "minhaAvo");
        List<Avis> listeAvis1 = new ArrayList<>();
        listeAvis1.add(bonAvis);
        listeAvis1.add(mauvaisAvis);
        listeAvis1.add(moyenAvis);
        listeAvis1.add(encoreUnBonAvis);
        listeAvis1.add(excellentAvis);
        return listeAvis1;
    }

    private List<Ami> genererAmis() {
        List<Ami> amis = new ArrayList<>();
        List<Avis> listeAvis = genererAvis();
        Resto ru = new Resto("RU", "", true, "3 rue du Chêne 69100 VILLEURBANNE", "CB", 1,
                1, 1, "11h-15h", new Categorie("","tout"), "Très bon menu", listeAvis);
        Resto beurk = new Resto("Beurk", "", true, "4 rue du Campus de la Doua 69100 VILLEURBANNE",
                "CB, IZLY", 1, 2, 2, "11h-15h", new Categorie("","tout"), "Très bon menu", listeAvis);
        amis.add(new Ami("0001", "Cailloux", ru, ""));
        amis.add(new Ami("0002", "rotiroti", beurk, ""));
        amis.add(new Ami("0003", "niosega", beurk, ""));
        return amis;
    }

}
