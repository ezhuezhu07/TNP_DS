package com.example.tnp_ds;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;

public class Activity_1 extends AppCompatActivity {
    private Button signout;
    //private Layout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        signout=findViewById(R.id.signout);
        //String s=login.user_name;
        //Toast.makeText(getApplicationContext(),""+s,Toast.LENGTH_LONG).show();
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuthUI.getInstance().signOut(Activity_1.this).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        signout.setEnabled(false);
                        Intent i = new Intent(Activity_1.this,uisecurity.class);
                        startActivity(i);
                        //showSignInOptions();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),""+e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


    }
    public void quiz(View view)
    {
        Intent intent=new Intent(this,Quiztnp.class);
        startActivity(intent);
    }
    public void ans(View view)
    {
        Intent intent=new Intent(this,Answertnp.class);
        startActivity(intent);

    }
    public void db (View view)
    {
        Intent intent=new Intent(this,HomeActivity.class);
        startActivity(intent);
    }
    public void review (View view)
    {
        Intent intent=new Intent(this,Feedback.class);
        startActivity(intent);
    }
    public void com  (View view)
    {
        Intent intent=new Intent(this,Complier.class);
        startActivity(intent);
    }



}
