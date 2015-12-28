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

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class CarteFragment extends Fragment implements OnMapReadyCallback {

    //TODO tout

    public static final String tag = "carte_frag";

    public CarteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carte, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.carte);
        mapFragment.getMapAsync(this);
        //Voir un bout de doc ici : https://developers.google.com/maps/documentation/android-api/map#configure_initial_state

        return view;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}
