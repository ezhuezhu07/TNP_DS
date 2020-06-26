package com.example.tnp_ds;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.tnp_ds.Constants.FORMATED;

public class Quiztnp  extends AppCompatActivity
{

    public static TextView time,q_1,score,name;
    public static Button a_1,a_2,a_3,a_4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiztnp);
        time = findViewById(R.id.timer);
        q_1 = findViewById(R.id.q_1);
        a_1 = findViewById(R.id.a_1);
        a_2 = findViewById(R.id.a_2);
        a_3 = findViewById(R.id.a_3);
        a_4 = findViewById(R.id.a_4);
        score = findViewById(R.id.score);
        name = findViewById(R.id.name);
        if (!uisecurity.usr.equals(""))
        {
            name.setText(uisecurity.usr);
        }
        Intent intent = new Intent(Quiztnp.this, Timer.class);
        intent.putExtra("sleepTime", 0);
        startService(intent);
    }
}

