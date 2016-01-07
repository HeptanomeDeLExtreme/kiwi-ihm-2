/**
 * Fragment contenant la liste des restaurants et les informations utiles associées
 *
 * @author Ealhad
 */
package com.kiwi.kiwi;


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

        ListView mListView = (ListView) view.findViewById(R.id.listView);

        List<Resto> restos = MainActivity.listeRestos;

        ListAdapter adapter = new RestoAdapter(getContext(), restos);
        mListView.setAdapter(adapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                List<Resto> restos = MainActivity.listeRestos;
                Resto restoChoisi = restos.get(position);
                Log.i("DEBUG", "Appui sur le "+position+"ème item : " + restoChoisi.getNom());
            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }


}
