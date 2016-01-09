package com.kiwi.kiwi;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Vue profil
 */
public class ProfilFragment extends Fragment {

    private static final String PRENOM = "Snoop";
    private static final String NOM = "Dog";
    private static final String PSEUDO = "DOGYDOG";
    private static final String MAIL = "snoop.dog@hotmail.fr";

    private boolean isVegetarien = false;
    private boolean isVegan = false;
    private boolean isAllergicGluten = true;
    private boolean isAllergicLactose = false;
    private boolean isHallal = false;

    private boolean isEdition = false;

    public static final String tag = "profil_frag";

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

        TextView pseudo = (TextView) view.findViewById(R.id.pseudoUser);
        pseudo.setText(PSEUDO);
        //makeEditableTextView(false, pseudo);

        TextView nom = (TextView) view.findViewById(R.id.nomUser);
        nom.setText(NOM);
        //makeEditableTextView(false, nom);

        TextView prenom = (TextView) view.findViewById(R.id.prenomUser);
        prenom.setText(PRENOM);
        //makeEditableTextView(false, prenom);

        TextView mail = (TextView) view.findViewById(R.id.mailUser);
        mail.setText(MAIL);
        //makeEditableTextView(false, mail);

        /* Végétarien */
        CheckBox checkBoxVegetarien = (CheckBox) view.findViewById(R.id.checkBoxVegetarien);
        if(isVegetarien) {
            checkBoxVegetarien.setChecked(true);
        } else {
            checkBoxVegetarien.setChecked(false);
        }
        //makeEditableCheckBox(false, checkBoxVegetarien);

        /* Vegan */
        CheckBox checkBoxVegan = (CheckBox) view.findViewById(R.id.checkBoxVegan);
        if(isVegan) {
            checkBoxVegan.setChecked(true);
        } else {
            checkBoxVegan.setChecked(false);
        }
        //makeEditableCheckBox(false, checkBoxVegan);

        /* Gluten */
        CheckBox checkBoxGluten = (CheckBox) view.findViewById(R.id.checkBoxSansGluten);
        if(isAllergicGluten) {
            checkBoxGluten.setChecked(true);
        } else {
            checkBoxGluten.setChecked(false);
        }
        //makeEditableCheckBox(false, checkBoxGluten);

        /* Lactose */
        CheckBox checkBoxLactose = (CheckBox) view.findViewById(R.id.checkBoxSansLactose);
        if(isAllergicLactose) {
            checkBoxLactose.setChecked(true);
        } else {
            checkBoxLactose.setChecked(false);
        }
        //makeEditableCheckBox(false, checkBoxLactose);

        /* Hallal */
        CheckBox checkBoxHallal = (CheckBox) view.findViewById(R.id.checkBoxHallal);
        if(isHallal) {
            checkBoxHallal.setChecked(true);
        } else {
            checkBoxHallal.setChecked(false);
        }
        //makeEditableCheckBox(false, checkBoxHallal);

        /* Listener */
        checkBoxVegetarien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("debug", "Clic sur la checkbox végétarien !");
                isVegetarien = !isVegetarien;
                CheckBox cb = (CheckBox) getView().findViewById(R.id.checkBoxVegetarien);
                //makeEditableCheckBox(isVegetarien, cb);
                cb.setChecked(isVegetarien);
            }
        });

        checkBoxVegan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("debug", "Clic sur la checkbox vegan !");
                isVegan = !isVegan;
                CheckBox cb = (CheckBox) getView().findViewById(R.id.checkBoxVegan);
                //makeEditableCheckBox(isVegan, cb);
                cb.setChecked(isVegan);
            }
        });

        checkBoxGluten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("debug", "Clic sur la checkbox gluten !");
                isAllergicGluten = !isAllergicGluten;
                CheckBox cb = (CheckBox) getView().findViewById(R.id.checkBoxSansGluten);
                //makeEditableCheckBox(isAllergicGluten, cb);
                cb.setChecked(isAllergicGluten);
            }
        });

        checkBoxLactose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("debug", "Clic sur la checkbox lactose !");
                isAllergicLactose = !isAllergicLactose;
                CheckBox cb = (CheckBox) getView().findViewById(R.id.checkBoxSansLactose);
                //makeEditableCheckBox(isAllergicLactose, cb);
                cb.setChecked(isAllergicLactose);
            }
        });

        checkBoxHallal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("debug", "Clic sur la checkbox gluten !");
                isHallal = !isHallal;
                CheckBox cb = (CheckBox) getView().findViewById(R.id.checkBoxHallal);
                //makeEditableCheckBox(isHallal, cb);
                cb.setChecked(isHallal);
            }
        });

        ImageView edit = (ImageView) getView().findViewById(R.id.editButton);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("debug", "Clic sur le bouton d'édition !");
                isEdition = !isEdition;
                Log.i("debug", "Etat de isEdition : " + isEdition);

                // Does not work
                /*TextView pseudo = (TextView) getView().findViewById(R.id.pseudoUser);
                TextView nom = (TextView) getView().findViewById(R.id.nomUser);
                TextView prenom = (TextView) getView().findViewById(R.id.prenomUser);

                if(isEdition) {
                    Log.i("debug", "isEdition true");
                    makeEditableTextView(true, pseudo);
                    makeEditableTextView(true, prenom);
                    makeEditableTextView(true, nom);
                } else {
                    Log.i("debug", "isEdition false");
                    makeEditableTextView(false, pseudo);
                    makeEditableTextView(false, prenom);
                    makeEditableTextView(false, nom);
                } */
            }
        });
    }

    private void makeEditableTextView(boolean isEditable,TextView tv){
        if(isEditable){
            tv.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            tv.setFocusable(true);
            tv.setEnabled(true);
            tv.setClickable(true);
            tv.setFocusableInTouchMode(true);
        } else {
            tv.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            tv.setFocusable(false);
            tv.setClickable(false);
            tv.setFocusableInTouchMode(false);
            tv.setEnabled(false);
        }
    }

    private void makeEditableCheckBox(boolean isEditable, CheckBox cb) {
        if(isEditable) {
            cb.setFocusable(true);
            cb.setClickable(true);
            cb.setFocusableInTouchMode(true);
            cb.setEnabled(true);
        } else {
            cb.setFocusable(false);
            cb.setClickable(false);
            cb.setFocusableInTouchMode(false);
            cb.setEnabled(false);
        }
    }
}
