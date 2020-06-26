package com.example.tnp_ds;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Feedback extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private EditText review,userid,editText;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        review=findViewById(R.id.review);
        userid=findViewById(R.id.userid);
        submit=findViewById(R.id.submit);
        editText=findViewById(R.id.editText3);
        if(!uisecurity.usr.equals(""))
        {
            userid.setText(uisecurity.usr);
        }
        else
        {
            userid.setVisibility(View.INVISIBLE);
        }

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Feedback");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = review.getText().toString();
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("Review",data);
                databaseReference.child(editText.getText().toString()).setValue(hashMap);
                Toast.makeText(getApplicationContext(),"Thank you for your Reaponse",Toast.LENGTH_LONG).show();
            }
        });

    }
}
