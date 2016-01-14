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

        TextView info = (TextView) getView().findViewById(R.id.infoINSA);
        info.setText("Pas de compte INSA configuré !");

        EditText email = (EditText) getView().findViewById(R.id.emailINSA);
        TextView montant = (TextView) getView().findViewById(R.id.montantINSA);
        TextView date = (TextView) getView().findViewById(R.id.dateINSA);
        Button con = (Button) getView().findViewById(R.id.connexionINSA);
        TextView loginText = (TextView) getView().findViewById(R.id.loginTextINSA);
        TextView mdpText = (TextView) getView().findViewById(R.id.mdpTextINSA);
        EditText mdp = (EditText) getView().findViewById(R.id.mdpINSA);

        email.setVisibility(View.INVISIBLE);
        montant.setVisibility(View.INVISIBLE);
        date.setVisibility(View.INVISIBLE);
        con.setVisibility(View.INVISIBLE);
        info.setVisibility(View.VISIBLE);
        loginText.setVisibility(View.INVISIBLE);
        mdpText.setVisibility(View.INVISIBLE);
        mdp.setVisibility(View.INVISIBLE);

        ImageView b = (ImageView) view.findViewById(R.id.buttonEditIZLY);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText email = (EditText) getView().findViewById(R.id.emailINSA);
                TextView montant = (TextView) getView().findViewById(R.id.montantINSA);
                TextView date = (TextView) getView().findViewById(R.id.dateINSA);
                Button con = (Button) getView().findViewById(R.id.connexionINSA);
                TextView loginText = (TextView) getView().findViewById(R.id.loginTextINSA);
                TextView mdpText = (TextView) getView().findViewById(R.id.mdpTextINSA);
                EditText mdp = (EditText) getView().findViewById(R.id.mdpINSA);

                TextView info = (TextView) getView().findViewById(R.id.infoINSA);

                if (isVisible) {
                    email.setVisibility(View.INVISIBLE);
                    montant.setVisibility(View.INVISIBLE);
                    date.setVisibility(View.INVISIBLE);
                    con.setVisibility(View.INVISIBLE);
                    info.setVisibility(View.VISIBLE);
                    loginText.setVisibility(View.INVISIBLE);
                    mdpText.setVisibility(View.INVISIBLE);
                    mdp.setVisibility(View.INVISIBLE);
                } else {
                    email.setVisibility(View.VISIBLE);
                    montant.setVisibility(View.VISIBLE);
                    date.setVisibility(View.VISIBLE);
                    con.setVisibility(View.VISIBLE);
                    info.setVisibility(View.INVISIBLE);
                    loginText.setVisibility(View.VISIBLE);
                    mdpText.setVisibility(View.VISIBLE);
                    mdp.setVisibility(View.VISIBLE);
                    email.setText("");
                    montant.setText("");
                    date.setText("");
                    mdp.setText("");
                }
                isVisible = !isVisible;
            }
        });

        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView montant = (TextView) getView().findViewById(R.id.montantINSA);
                TextView date = (TextView) getView().findViewById(R.id.dateINSA);

                Random r = new Random();
                int solde = r.nextInt(60 - 0 + 1) + 0;
                int jour = r.nextInt(31 - 0 + 1) + 0;
                int mois = r.nextInt(12 - 0 + 1) + 0;

                montant.setText("Solde restant : " + solde + "€");
                date.setText("Expiration : " + jour + "/" + mois + "/2013");
            }
        });


    }


}