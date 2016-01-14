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
        Intent menuIntent = new Intent(this, PageInscription.class);
        startActivity(menuIntent);
    }

    public void boutonOkListener(View view) {
        EditText pseudoEntre = (EditText) findViewById(R.id.idTextPseudo);
        EditText mdpEntre = (EditText) findViewById(R.id.idTextMdp);
        if ((PSEUDO.equals(pseudoEntre.getText().toString())) && (MDP.equals(mdpEntre.getText().toString()))) {
            Intent menuIntent = new Intent(this, MainActivity.class);
            startActivity(menuIntent);

        } else {
            Toast.makeText(getApplicationContext(), getString(R.string.defaultIDIncorrects), Toast.LENGTH_SHORT).show();
        }
    }
}
