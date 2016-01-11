/**
 * Fragment contenant la localisation des restaurants
 * Intégration Google Maps
 */
package com.kiwi.kiwi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.kiwi.kiwi.model.Resto;

import java.util.List;

public class CarteFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener{


    public static final String tag = "carte_frag";
    private static final LatLng INSA = new LatLng(45.781206, 4.873504);
    List<Resto> ListeRestos = MainActivity.listeRestos;
    private Marker SelectedMarker;


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
    public void onMapReady(GoogleMap map) {

        // Positionne la caméra au dessus du campus
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(INSA) // Sets the center of the map to INSA
                .zoom(15)                   // Sets the zoom
                .bearing(0) // Sets the orientation of the camera to north
                .tilt(0)    // Sets the tilt of the camera to 0 degrees
                .build();    // Creates a CameraPosition from the builder
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


        // Affiche les marqueurs
        for (Resto resto : ListeRestos){
            map.addMarker(new MarkerOptions()
                    .position(resto.getPositionGPS())
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                    .title(resto.getNom())
                    .snippet(resto.getNiveauTarif() + " - " + resto.getListeAmi().size() + " amis")
                    .visible(true));
        }

        map.setOnInfoWindowClickListener(this);


    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Toast.makeText(this.getContext(), "Info window clicked",
                Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getActivity(), PageResto.class);
        Resto restoSelect = trouverRestoParNom(marker.getTitle());
        intent.putExtra("resto", restoSelect.getNom());
        startActivity(intent);

    }

    // Méthode sale pour choper le resto depuis le marker
    public Resto trouverRestoParNom(String nom){
        Resto resto = new Resto();
        for (Resto r : ListeRestos){
            if(r.getNom().equals(nom)){
                resto = r;
            }
        }
        return resto;
    }


}
