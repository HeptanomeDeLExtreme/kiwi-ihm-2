package com.kiwi.kiwi;

/**
 * Fragment contenant la liste des restaurants et les informations utiles associées
 *
 * @author Ealhad
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.kiwi.kiwi.model.Ami;
import com.kiwi.kiwi.model.AmiAdapter;
import com.kiwi.kiwi.model.Resto;

import java.util.List;

public class AmiFragment extends Fragment {

    public static final String tag = "liste_frag";

    public AmiFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView mListView = (ListView) view.findViewById(R.id.listAmi);

        List<Ami> amis = MainActivity.listeAmis;

        ListAdapter adapter = new AmiAdapter(getContext(), amis);
        mListView.setAdapter(adapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                List<Ami> amis = MainActivity.listeAmis;
                Ami amiChoisi = amis.get(position);
                Log.i("DEBUG", "Appui sur le " + position + "ème item : " + amiChoisi.getNom());

                //Passer sur la vue détaillée du resto où se trouve l'ami
                Intent intent = new Intent(getActivity(), PageResto.class);
                Resto restoSelect = amiChoisi.getRestaurantActuel();
                intent.putExtra("resto", restoSelect.getNom());
                startActivity(intent);

            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_amis, container, false);
    }


}
