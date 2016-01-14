package com.kiwi.kiwi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;


public class ProfilFragment extends Fragment {

    public static final String tag = "profil_frag";
    private static final String PRENOM = "Bruce";
    private static final String NOM = "Wayne";
    private static final String PSEUDO = "Batman";
    private static final String MAIL = "bruce.wayne@wayne-enterprise.com";
    private boolean isVegetarien = false;
    private boolean isVegan = false;
    private boolean isAllergicGluten = true;
    private boolean isAllergicLactose = false;
    private boolean isHallal = false;
    private boolean isEdition = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profil, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button buttonOK = (Button) getView().findViewById(R.id.buttonProfilOk);
        buttonOK.setVisibility(View.INVISIBLE);

        EditText pseudo = (EditText) view.findViewById(R.id.pseudoUser);
        pseudo.setText(PSEUDO);
        pseudo.setEnabled(false);

        EditText nom = (EditText) view.findViewById(R.id.nomUser);
        nom.setText(NOM);
        nom.setEnabled(false);

        EditText prenom = (EditText) view.findViewById(R.id.prenomUser);
        prenom.setText(PRENOM);
        prenom.setEnabled(false);

        EditText mail = (EditText) view.findViewById(R.id.mailUser);
        mail.setText(MAIL);
        mail.setEnabled(false);

        /* Végétarien */
        CheckBox checkBoxVegetarien = (CheckBox) view.findViewById(R.id.checkBoxVegetarien);
        if (isVegetarien) {
            checkBoxVegetarien.setChecked(true);
        } else {
            checkBoxVegetarien.setChecked(false);
        }
        checkBoxVegetarien.setEnabled(false);

        /* Vegan */
        CheckBox checkBoxVegan = (CheckBox) view.findViewById(R.id.checkBoxVegan);
        if (isVegan) {
            checkBoxVegan.setChecked(true);
        } else {
            checkBoxVegan.setChecked(false);
        }
        checkBoxVegan.setEnabled(false);

        /* Gluten */
        CheckBox checkBoxGluten = (CheckBox) view.findViewById(R.id.checkBoxSansGluten);
        if (isAllergicGluten) {
            checkBoxGluten.setChecked(true);
        } else {
            checkBoxGluten.setChecked(false);
        }
        checkBoxGluten.setEnabled(false);

        /* Lactose */
        CheckBox checkBoxLactose = (CheckBox) view.findViewById(R.id.checkBoxSansLactose);
        if (isAllergicLactose) {
            checkBoxLactose.setChecked(true);
        } else {
            checkBoxLactose.setChecked(false);
        }
        checkBoxLactose.setEnabled(false);

        /* Hallal */
        CheckBox checkBoxHallal = (CheckBox) view.findViewById(R.id.checkBoxHallal);
        if (isHallal) {
            checkBoxHallal.setChecked(true);
        } else {
            checkBoxHallal.setChecked(false);
        }
        checkBoxHallal.setEnabled(false);

        /* Listener */
        checkBoxVegetarien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEdition) {
                    isVegetarien = !isVegetarien;
                    CheckBox cb = (CheckBox) getView().findViewById(R.id.checkBoxVegetarien);
                    cb.setChecked(isVegetarien);

                }
            }
        });

        checkBoxVegan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isVegan = !isVegan;
                CheckBox cb = (CheckBox) getView().findViewById(R.id.checkBoxVegan);
                cb.setChecked(isVegan);
            }
        });

        checkBoxGluten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAllergicGluten = !isAllergicGluten;
                CheckBox cb = (CheckBox) getView().findViewById(R.id.checkBoxSansGluten);
                cb.setChecked(isAllergicGluten);
            }
        });

        checkBoxLactose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAllergicLactose = !isAllergicLactose;
                CheckBox cb = (CheckBox) getView().findViewById(R.id.checkBoxSansLactose);
                cb.setChecked(isAllergicLactose);
            }
        });

        checkBoxHallal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isHallal = !isHallal;
                CheckBox cb = (CheckBox) getView().findViewById(R.id.checkBoxHallal);
                cb.setChecked(isHallal);
            }
        });

        ImageView edit = (ImageView) getView().findViewById(R.id.editButton);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isEdition = !isEdition;

                EditText pseudo = (EditText) getView().findViewById(R.id.pseudoUser);
                EditText nom = (EditText) getView().findViewById(R.id.nomUser);
                EditText prenom = (EditText) getView().findViewById(R.id.prenomUser);
                CheckBox cbVegetarien = (CheckBox) getView().findViewById(R.id.checkBoxVegetarien);
                CheckBox cbVegan = (CheckBox) getView().findViewById(R.id.checkBoxVegan);
                CheckBox cbGluten = (CheckBox) getView().findViewById(R.id.checkBoxSansGluten);
                CheckBox cbLactose = (CheckBox) getView().findViewById(R.id.checkBoxSansLactose);
                CheckBox cbHallal = (CheckBox) getView().findViewById(R.id.checkBoxHallal);
                ImageView edit = (ImageView) getView().findViewById(R.id.editButton);
                Button buttonOK = (Button) getView().findViewById(R.id.buttonProfilOk);

                if (isEdition) {
                    edit.setVisibility(View.INVISIBLE);
                    buttonOK.setVisibility(View.VISIBLE);
                    pseudo.setEnabled(true);
                    nom.setEnabled(true);
                    prenom.setEnabled(true);
                    cbVegetarien.setEnabled(true);
                    cbVegan.setEnabled(true);
                    cbGluten.setEnabled(true);
                    cbLactose.setEnabled(true);
                    cbHallal.setEnabled(true);
                }
            }
        });

        Button boutonOK = (Button) getView().findViewById(R.id.buttonProfilOk);
        boutonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isEdition = !isEdition;

                EditText pseudo = (EditText) getView().findViewById(R.id.pseudoUser);
                EditText nom = (EditText) getView().findViewById(R.id.nomUser);
                EditText prenom = (EditText) getView().findViewById(R.id.prenomUser);
                CheckBox cbVegetarien = (CheckBox) getView().findViewById(R.id.checkBoxVegetarien);
                CheckBox cbVegan = (CheckBox) getView().findViewById(R.id.checkBoxVegan);
                CheckBox cbGluten = (CheckBox) getView().findViewById(R.id.checkBoxSansGluten);
                CheckBox cbLactose = (CheckBox) getView().findViewById(R.id.checkBoxSansLactose);
                CheckBox cbHallal = (CheckBox) getView().findViewById(R.id.checkBoxHallal);
                ImageView edit = (ImageView) getView().findViewById(R.id.editButton);
                Button buttonOK = (Button) getView().findViewById(R.id.buttonProfilOk);

                if (!isEdition) {
                    edit.setVisibility(View.VISIBLE);
                    buttonOK.setVisibility(View.INVISIBLE);
                    pseudo.setEnabled(false);
                    nom.setEnabled(false);
                    prenom.setEnabled(false);
                    cbVegetarien.setEnabled(false);
                    cbVegan.setEnabled(false);
                    cbGluten.setEnabled(false);
                    cbLactose.setEnabled(false);
                    cbHallal.setEnabled(false);
                }
            }
        });
    }
}