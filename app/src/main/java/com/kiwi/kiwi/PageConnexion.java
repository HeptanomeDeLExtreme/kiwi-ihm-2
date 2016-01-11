package com.kiwi.kiwi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PageConnexion extends AppCompatActivity {
    private final String PSEUDO = "user";
    private final String MDP = "pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_connexion);
    }

    public void boutonRetourListener(View view) {
        Log.i("debug", "Appui sur le bouton Retour !");
        Intent menuIntent = new Intent(this, PageInscription.class);
        startActivity(menuIntent);
    }

    public void boutonOkListener(View view) {
        Log.i("debug", "Appui sur le bouton OK !");
        EditText pseudoEntre = (EditText) findViewById(R.id.idTextPseudo);
        EditText mdpEntre = (EditText) findViewById(R.id.idTextMdp);
        Log.i("debug", "Le pseudo entré par l'utilisateur est : " + pseudoEntre.getText() + " !");
        Log.i("debug", "Le mot de passe entré par l'utilisateur est : " + mdpEntre.getText() + " !");
        if ((PSEUDO.equals(pseudoEntre.getText().toString())) && (MDP.equals(mdpEntre.getText().toString()))) {
            Log.i("debug", "Identifiants et mot de passe corrects !");
            MainActivity.isConnected = true;
            Intent menuIntent = new Intent(this, MainActivity.class);
            startActivity(menuIntent);

        } else {
            Log.i("debug", "Identifiants et mot de passe incorrects !");
            Toast.makeText(getApplicationContext(), getString(R.string.defaultIDIncorrects), Toast.LENGTH_SHORT).show();
        }
    }
}
