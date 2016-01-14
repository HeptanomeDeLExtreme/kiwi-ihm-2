package com.kiwi.kiwi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
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

                //Passer sur la vue détaillée du resto où se trouve l'ami
                Intent intent = new Intent(getActivity(), PageResto.class);
                Resto restoSelect = amiChoisi.getRestaurantActuel();
                intent.putExtra("resto", restoSelect.getNom());
                startActivity(intent);

            }
        });

        ListView list = (ListView) getView().findViewById(R.id.listAmi);
        list.setVisibility(View.INVISIBLE);

        Button boutonFacebook = (Button) view.findViewById(R.id.boutonFacebook);
        boutonFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListView list = (ListView) getView().findViewById(R.id.listAmi);
                list.setVisibility(View.VISIBLE);
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
