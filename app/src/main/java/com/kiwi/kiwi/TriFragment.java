package com.kiwi.kiwi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;


/**
 * Menu de tri des restaurants
 */
public class TriFragment extends Fragment {

    public static final String tag = "tri_frag";

    private CheckBox checkCB;
    private CheckBox checkINSA;
    private CheckBox checkIZLY;

    private CheckBox checkUniv;
    private CheckBox checkItalien;
    private CheckBox checkTacos;
    private CheckBox checkPizzeria;
    private CheckBox checkOriental;
    private CheckBox checkIndien;
    private CheckBox checkSandwich;

    private CheckBox checkOuvert;

    public TriFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tri, container, false);


        checkCB = (CheckBox) view.findViewById(R.id.check_cb);
        checkCB.setChecked(MainActivity.filtre.getCb());
        checkCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.filtre.setCb(((CheckBox) v).isChecked());
            }
        });

        checkINSA = (CheckBox) view.findViewById(R.id.check_insa);
        checkINSA.setChecked(MainActivity.filtre.getINSA());
        checkINSA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.filtre.setINSA(((CheckBox) v).isChecked());
            }
        });

        checkIZLY = (CheckBox) view.findViewById(R.id.check_izly);
        checkIZLY.setChecked(MainActivity.filtre.getIZLY());
        checkIZLY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.filtre.setIZLY(((CheckBox) v).isChecked());
            }
        });

        checkUniv = (CheckBox) view.findViewById(R.id.check_universitaire);
        checkUniv.setChecked(MainActivity.filtre.getUniversitaire());
        checkUniv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.filtre.setUniversitaire(((CheckBox) v).isChecked());
            }
        });

        checkItalien = (CheckBox) view.findViewById(R.id.check_italien);
        checkItalien.setChecked(MainActivity.filtre.getItalien());
        checkItalien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.filtre.setItalien(((CheckBox) v).isChecked());
            }
        });

        checkTacos = (CheckBox) view.findViewById(R.id.check_tacos);
        checkTacos.setChecked(MainActivity.filtre.getTacos());
        checkTacos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.filtre.setTacos(((CheckBox) v).isChecked());
            }
        });

        checkPizzeria = (CheckBox) view.findViewById(R.id.check_pizzeria);
        checkPizzeria.setChecked(MainActivity.filtre.getPizzeria());
        checkPizzeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.filtre.setPizzeria(((CheckBox) v).isChecked());
            }
        });

        checkOriental = (CheckBox) view.findViewById(R.id.check_oriental);
        checkOriental.setChecked(MainActivity.filtre.getOriental());
        checkOriental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.filtre.setOriental(((CheckBox) v).isChecked());
            }
        });

        checkIndien = (CheckBox) view.findViewById(R.id.check_indien);
        checkIndien.setChecked(MainActivity.filtre.getIndien());
        checkIndien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.filtre.setIndien(((CheckBox) v).isChecked());
            }
        });

        checkSandwich = (CheckBox) view.findViewById(R.id.check_sandwich);
        checkSandwich.setChecked(MainActivity.filtre.getSandwich());
        checkSandwich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.filtre.setSandwich(((CheckBox) v).isChecked());
            }
        });

        checkOuvert = (CheckBox) view.findViewById(R.id.check_ouvert);
        checkOuvert.setChecked(MainActivity.filtre.getOuvert());
        checkOuvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.filtre.setOuvert(((CheckBox) v).isChecked());
            }
        });

        return view;
    }

}
