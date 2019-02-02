package com.example.maciek.hangman_wordschallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class gameover extends AppCompatActivity {
Button tryagain,exit;
    TextView slowo;
    DBHelper db =new DBHelper(this);
    static String kategoria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);

        tryagain = (Button) findViewById(R.id.button6);
        exit = (Button) findViewById(R.id.button12);
        slowo = (TextView)findViewById(R.id.textView3);

        Intent intent = getIntent();
        kategoria=intent.getStringExtra("kategoria");
        slowo.setText("Twój wyraz to: \n"+intent.getStringExtra("slowo"));

        int[] tab=db.wyswietldane();
        db.ustawprzegrane(tab[1]+1);

        tryagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Game.class);
                if(kategoria.equals("panstwa")){
                    intent.putExtra("kategoria","panstwa");
                }
                if(kategoria.equals("imiona")){
                    intent.putExtra("kategoria","imiona");
                }
                startActivity(intent);
                finish();
            }

        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }

        });
    }
}
