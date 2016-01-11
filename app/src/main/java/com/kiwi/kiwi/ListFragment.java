/**
 * Fragment contenant la liste des restaurants et les informations utiles associées
 *
 * @author Ealhad
 */
package com.kiwi.kiwi;

import android.content.Intent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.kiwi.kiwi.model.Resto;
import com.kiwi.kiwi.model.RestoAdapter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* Bonfante,
Il y a deux blocs de commentaires. Le premier, c'était un début de solution qui utilise
ListFragment car il y a une méthode dedans qui permet de connaître très facilement
l'item sur lequel on a cliqué. Par contre, je n'arrive pas à la mettre en place.

Le second bloc, c'est ta solution que je n'ai pas réussi à faire fonctionner.
Zoub !
 */



/*
public class ListFragment extends android.app.ListFragment {
    public static final String tag = "liste_frag";

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, Shakespeare.TITLES));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Log.i("FragmentList", "Item clicked: " + id);
    }
}
*/



public class ListFragment extends Fragment {

    public static final String tag = "liste_frag";
    final String EXTRA_RESTO = "resto";
    public ListAdapter adapter;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("DEBUG", view + "trui");
        final ListView mListView = (ListView) view.findViewById(R.id.listView);

        List<Resto> restos = MainActivity.listeRestosVisibles;

        ListAdapter adapter = new RestoAdapter(getContext(), restos);
        mListView.setAdapter(adapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3) {
                Intent intent = new Intent(getActivity(), PageResto.class);
                Resto restoSelect = (Resto) (mListView.getItemAtPosition(position));
                intent.putExtra(EXTRA_RESTO, restoSelect.getNom());
                startActivity(intent);
            }
        });


    }

    private int compteOccurence(String s, char c){
        int toRet = 0;
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)==c){
                toRet++;
            }
        }
        return toRet;
    }

    public void triPrix(){
        Collections.sort(MainActivity.listeRestosVisibles, new Comparator<Resto>() {
            @Override
            public int compare(Resto lhs, Resto rhs) {
                int prixResto1 = compteOccurence(lhs.getNiveauTarif(), '€');
                int prixResto2 = compteOccurence(rhs.getNiveauTarif(), '€');
                return prixResto1 - prixResto2;
            }
        });
        updateList();
    }

    public void triAttente(){
        Collections.sort(MainActivity.listeRestosVisibles, new Comparator<Resto>() {
            @Override
            public int compare(Resto lhs, Resto rhs) {
                int prixResto1 = Integer.parseInt(lhs.getTempsAttente());
                int prixResto2 = Integer.parseInt(rhs.getTempsAttente());
                return prixResto1 - prixResto2;
            }
        });
        updateList();
    }

    public void triAller(){
        Collections.sort(MainActivity.listeRestosVisibles, new Comparator<Resto>() {
            @Override
            public int compare(Resto lhs, Resto rhs) {
                int prixResto1 = compteOccurence(lhs.getNiveauTarif(), '€');
                int prixResto2 = compteOccurence(rhs.getNiveauTarif(), '€');
                return prixResto1 - prixResto2;
            }
        });
        updateList();
    }

    private void updateList(){
        List<Resto> restos = MainActivity.listeRestosVisibles;
        ListView mListView = (ListView) getView().findViewById(R.id.listView);
        adapter = new RestoAdapter(getContext(), restos);
        mListView.setAdapter(adapter);
        Log.i("DEBUG", "update");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }


}
