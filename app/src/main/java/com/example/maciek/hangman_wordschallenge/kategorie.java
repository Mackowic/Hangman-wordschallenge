package com.example.maciek.hangman_wordschallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class kategorie extends AppCompatActivity {
    Button panstwa,imiona;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategorie);

        panstwa = (Button) findViewById(R.id.button13);
        imiona = (Button) findViewById(R.id.button14);


        panstwa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Game.class);
                intent.putExtra("kategoria","panstwa");
                startActivity(intent);
                finish();
            }

        });
        imiona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Game.class);
                intent.putExtra("kategoria","imiona");
                startActivity(intent);
                finish();
            }

        });
    }
}
