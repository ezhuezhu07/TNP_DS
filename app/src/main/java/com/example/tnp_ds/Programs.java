package com.example.tnp_ds;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;

public class Programs extends AppCompatActivity {

    private TextView textView,textView1;
    private EditText editText;
    private ImageView imageView,imageView1,imageView8;
    //private EditText textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs);
        textView=findViewById(R.id.textView3);
        textView1=findViewById(R.id.textView4);
        editText=findViewById(R.id.edit);
        imageView=findViewById(R.id.imageView);
        imageView1=findViewById(R.id.imageView4);
        imageView8=findViewById(R.id.imageView8);
       textView.setMovementMethod(new ScrollingMovementMethod());
        textView1.setMovementMethod(new ScrollingMovementMethod());
        String ques;
        Intent i = getIntent();
        ques=i.getStringExtra("question_name");
        //textView.setText(ques);
        final DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("ProgramView");
        db.child(ques).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.child("program").getValue().toString();
                textView.setText(value.replace("%n","\n"));
                textView1.setText(value.replace("%n","\n"));
                editText.setText(value.replace("%n","\n"));
                editText.setVisibility(View.INVISIBLE);
                textView1.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(getApplicationContext(),"Loading Error",Toast.LENGTH_LONG).show();
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(View.VISIBLE);
                editText.setVisibility(View.INVISIBLE);
                textView1.setVisibility(View.INVISIBLE);
            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setVisibility(View.INVISIBLE);
                textView1.setVisibility(View.INVISIBLE);
                editText.setVisibility(View.VISIBLE);
            }
        });
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setVisibility(View.INVISIBLE);
                textView1.setVisibility(View.VISIBLE);
                editText.setVisibility(View.INVISIBLE);
            }
        });



    }

}
