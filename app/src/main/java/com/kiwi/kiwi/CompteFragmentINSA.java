package com.kiwi.kiwi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Vue profil
 */
public class CompteFragmentINSA extends Fragment {

   public static final String tag = "compteINSA_frag";

    public boolean isVisible = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_compte_insa, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView b = (ImageView) view.findViewById(R.id.buttonEdit);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText email = (EditText) getView().findViewById(R.id.emailINSA);
                TextView montant = (TextView) getView().findViewById(R.id.montantINSA);
                TextView date = (TextView) getView().findViewById(R.id.dateINSA);

                if (isVisible) {
                    email.setVisibility(View.INVISIBLE);
                    montant.setVisibility(View.INVISIBLE);
                    date.setVisibility(View.INVISIBLE);
                } else {
                    email.setVisibility(View.VISIBLE);
                    montant.setVisibility(View.VISIBLE);
                    date.setVisibility(View.VISIBLE);
                }
                isVisible = !isVisible;
            }
        });
    }


}
