package com.example.maciek.hangman_wordschallenge;

import android.content.Intent;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import java.util.List;

public class Game extends AppCompatActivity {
    private TextView  słowo;
    private ImageView score;
    private Button a,aa,b,c,cc,d,e,ee,f,g,h,i,j,k,l,ll,m,n,nn,o,oo,p,r,s,ss,t,u,w,y,z,zz,zzz;
    DBHelper db =new DBHelper(this);
    int pkt = 0;
    Random generator = new Random();
    String slowo;
    String []tab;
    String []tab1;
    int panstwa = 194;
    int imiona=350;
    String kategoria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        słowo = (TextView) findViewById(R.id.slowo);
        score =(ImageView) findViewById(R.id.imageView);
        init();

        Intent intent = getIntent();
        kategoria=intent.getStringExtra("kategoria");
        //slowo.setText("Twój wyraz to: \n"+intent.getStringExtra("slowo"));
        if(intent.getStringExtra("kategoria").equals("panstwa")){
            slowo=db.wyswietlpanstwo(generator.nextInt(panstwa)+1);

        }
        if(intent.getStringExtra("kategoria").equals("imiona")){
            slowo=db.wyswietlimie(generator.nextInt(imiona)+1);

        }
        tab=new String[slowo.length()];
        tab1=new String[slowo.length()];

        for (int i = 0; i < tab.length; i++) {
        String a=""+slowo.charAt(i);
            tab[i]=a;
        }

        for (int i = 0; i < tab1.length; i++) {

            tab1[i] = "_";
        }

        słowo.setText(Arrays.toString(tab1).replace(",","").replace("[","").replace("]",""));



        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(a.getText().toString());
                a.setEnabled(false);
            }

        });
        aa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(aa.getText().toString());
                aa.setEnabled(false);
            }

        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(b.getText().toString());
                b.setEnabled(false);
            }

        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(c.getText().toString());
                c.setEnabled(false);
            }

        });
        cc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cc.getText().toString());
                cc.setEnabled(false);
            }

        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(d.getText().toString());
                d.setEnabled(false);
            }

        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(e.getText().toString());
                e.setEnabled(false);
            }

        });
        ee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(ee.getText().toString());
                ee.setEnabled(false);
            }

        });
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(f.getText().toString());
                f.setEnabled(false);
            }

        });
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(g.getText().toString());
                g.setEnabled(false);
            }

        });
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(h.getText().toString());
                h.setEnabled(false);
            }

        });
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(i.getText().toString());
                i.setEnabled(false);
            }

        });
        j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(j.getText().toString());
                j.setEnabled(false);
            }

        });
        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(k.getText().toString());
                k.setEnabled(false);
            }

        }); l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(l.getText().toString());
                l.setEnabled(false);
            }

        }); ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(ll.getText().toString());
                ll.setEnabled(false);
            }

        }); m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(m.getText().toString());
                m.setEnabled(false);
            }

        }); n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(n.getText().toString());
                n.setEnabled(false);
            }

        }); nn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(nn.getText().toString());
                nn.setEnabled(false);
            }

        }); o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(o.getText().toString());
                o.setEnabled(false);
            }

        });
        oo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(oo.getText().toString());
                oo.setEnabled(false);
            }

        });
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(p.getText().toString());
                p.setEnabled(false);
            }

        });
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(r.getText().toString());
                r.setEnabled(false);
            }

        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(s.getText().toString());
                s.setEnabled(false);
            }

        });
        ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(ss.getText().toString());
                ss.setEnabled(false);
            }

        });
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(t.getText().toString());
                t.setEnabled(false);
            }

        });
        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(u.getText().toString());
                u.setEnabled(false);
            }

        });
        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(w.getText().toString());
                w.setEnabled(false);
            }

        });
        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(y.getText().toString());
                y.setEnabled(false);
            }

        });
        z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(z.getText().toString());
                z.setEnabled(false);
            }

        });
        zz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(zz.getText().toString());
                zz.setEnabled(false);
            }

        });
       zzz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(zzz.getText().toString());
                zzz.setEnabled(false);
            }

        });
    }
    public void init(){
        a = (Button) findViewById(R.id.button);
        aa = (Button) findViewById(R.id.button2);
        b = (Button) findViewById(R.id.button3);
        c = (Button) findViewById(R.id.button4);
        cc = (Button) findViewById(R.id.button5);
        d = (Button) findViewById(R.id.button7);
        e = (Button) findViewById(R.id.button8);
        ee = (Button) findViewById(R.id.button9);
        f = (Button) findViewById(R.id.button10);
        g = (Button) findViewById(R.id.button11);
        h = (Button) findViewById(R.id.button24);
        i = (Button) findViewById(R.id.button26);
        j = (Button) findViewById(R.id.button25);
        k = (Button) findViewById(R.id.button27);
        l = (Button) findViewById(R.id.button28);
        ll = (Button) findViewById(R.id.button30);
        m = (Button) findViewById(R.id.button29);
        n = (Button) findViewById(R.id.button31);
        nn = (Button) findViewById(R.id.button32);
        o = (Button) findViewById(R.id.button33);
        oo = (Button) findViewById(R.id.button34);
        p = (Button) findViewById(R.id.button36);
        r = (Button) findViewById(R.id.button35);
        s = (Button) findViewById(R.id.button37);
        ss = (Button) findViewById(R.id.button38);
        t = (Button) findViewById(R.id.button40);
        u = (Button) findViewById(R.id.button39);
        w = (Button) findViewById(R.id.button41);
        y = (Button) findViewById(R.id.button42);
        z = (Button) findViewById(R.id.button43);
        zz = (Button) findViewById(R.id.button64);
        zzz = (Button) findViewById(R.id.button65);

    }
    public void check(String litera){
        boolean exist = false;

        for (int i = 0; i < tab.length; i++) {
            //sprawdzanie czy podana litera znajduje sie w wyrazie
            if (tab[i].equals(litera)) {
                String a = "" + litera;
                tab1[i] = a;
                exist = true;

            } else
                //sprawdzanie dla duzej litery
                if (tab[i].equals(litera.toUpperCase())) {
                    String a = "" + litera.toUpperCase();
                    tab1[i] = a;
                    exist = true;

                }
        }

        if(Arrays.equals(tab,tab1)){


            Intent intent = new Intent(getApplicationContext(),win.class);

            intent.putExtra("slowo",Arrays.toString(tab1).replace(",","").replace("[","").replace("]",""));
           if(kategoria.equals("panstwa")){
               Log.i("pans","");
               intent.putExtra("kategoria","panstwa");
           }
            if(kategoria.equals("imiona")){
                intent.putExtra("kategoria","imiona");
            }
            startActivity(intent);
            finish();

        }

        if (exist) {
            } else {
                pkt++;
                img(pkt);
            }
            słowo.setText(Arrays.toString(tab1).replace(",", "").replace("[", "").replace("]", ""));


    }

    public void img(int pkt){
int[] img = {R.drawable.hm1,R.drawable.hm2,R.drawable.hm3,R.drawable.hm4,R.drawable.hm5,R.drawable.hm6,R.drawable.hm7,R.drawable.hm8,R.drawable.hm9,R.drawable.hm10,R.drawable.hm11};
        if(pkt==11){
            Intent intent = new Intent(getApplicationContext(),gameover.class);
            intent.putExtra("slowo",Arrays.toString(tab).replace(",","").replace("[","").replace("]",""));
            if(kategoria.equals("panstwa")){
                Log.i("pans","");
                intent.putExtra("kategoria","panstwa");
            }
            if(kategoria.equals("imiona")){
                intent.putExtra("kategoria","imiona");
            }
            startActivity(intent);
            finish();

        }
        if (pkt<=img.length)
        score.setImageResource(img[pkt - 1]);
    }



}
