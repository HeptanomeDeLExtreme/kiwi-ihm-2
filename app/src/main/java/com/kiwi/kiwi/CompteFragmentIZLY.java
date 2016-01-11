package com.kiwi.kiwi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


/**
 * Vue profil
 */
public class CompteFragmentIZLY extends Fragment {

    public static final String tag = "compteIZLY_frag";

    public boolean isVisible = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_compte_izly, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView info = (TextView) getView().findViewById(R.id.infoIZLY);
        info.setText("Pas de compte IZLY configuré !");

        EditText email = (EditText) getView().findViewById(R.id.emailIZLY);
        TextView montant = (TextView) getView().findViewById(R.id.montantIZLY);
        Button con = (Button) getView().findViewById(R.id.connexionIZLY);
        TextView loginText = (TextView) getView().findViewById(R.id.loginTextIZLY);
        TextView mdpText = (TextView) getView().findViewById(R.id.mdpTextIZLY);
        EditText mdp = (EditText) getView().findViewById(R.id.mdpIZLY);

        email.setVisibility(View.INVISIBLE);
        montant.setVisibility(View.INVISIBLE);
        con.setVisibility(View.INVISIBLE);
        info.setVisibility(View.VISIBLE);
        loginText.setVisibility(View.INVISIBLE);
        mdpText.setVisibility(View.INVISIBLE);
        mdp.setVisibility(View.INVISIBLE);

        ImageView b = (ImageView) view.findViewById(R.id.buttonEditIZLY);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText email = (EditText) getView().findViewById(R.id.emailIZLY);
                TextView montant = (TextView) getView().findViewById(R.id.montantIZLY);
                Button con = (Button) getView().findViewById(R.id.connexionIZLY);
                TextView info = (TextView) getView().findViewById(R.id.infoIZLY);
                TextView loginText = (TextView) getView().findViewById(R.id.loginTextIZLY);
                TextView mdpText = (TextView) getView().findViewById(R.id.mdpTextIZLY);
                EditText mdp = (EditText) getView().findViewById(R.id.mdpIZLY);

                if (isVisible) {
                    email.setVisibility(View.INVISIBLE);
                    montant.setVisibility(View.INVISIBLE);
                    con.setVisibility(View.INVISIBLE);
                    info.setVisibility(View.VISIBLE);
                    loginText.setVisibility(View.INVISIBLE);
                    mdpText.setVisibility(View.INVISIBLE);
                    mdp.setVisibility(View.INVISIBLE);
                } else {
                    email.setVisibility(View.VISIBLE);
                    montant.setVisibility(View.VISIBLE);
                    con.setVisibility(View.VISIBLE);
                    info.setVisibility(View.INVISIBLE);
                    loginText.setVisibility(View.VISIBLE);
                    mdpText.setVisibility(View.VISIBLE);
                    mdp.setVisibility(View.VISIBLE);
                    email.setText("");
                    montant.setText("");
                    mdp.setText("");
                }
                isVisible = !isVisible;
            }
        });

        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView montant = (TextView) getView().findViewById(R.id.montantIZLY);

                Random r = new Random();
                int solde = r.nextInt(60 - 0 + 1) + 0;
                montant.setText("Solde restant : "+solde+"€");
            }
        });


    }


}