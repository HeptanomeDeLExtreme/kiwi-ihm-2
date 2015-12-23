/**
 * Fragment contenant la localisation des restaurants
 * Intégration Google Maps
 */
package com.kiwi.kiwi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CarteFragment extends Fragment {

    //TODO tout

    public static final String tag = "carte_frag";

    public CarteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

}
