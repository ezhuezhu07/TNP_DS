package com.example.tnp_ds;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class uisecurity extends AppCompatActivity {
    private EditText email;
    private EditText pwd;
    private TextView info;
    public static String usr;
    private Button log;
    private int counter = 3;
    private TextView reg;
    private FirebaseAuth mAuth;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uisecurity);
        MyReceiver myReceiver=new MyReceiver();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        registerReceiver(myReceiver,intentFilter);
        email = (EditText) findViewById(R.id.email);
        pwd = (EditText) findViewById(R.id.password);
        info = (TextView) findViewById(R.id.info);
        reg = (TextView) findViewById(R.id.sign);
        log = (Button) findViewById(R.id.login);
        info.setText("No of attempts remaining : 3");
        mAuth = FirebaseAuth.getInstance();
        pd = new ProgressDialog(this);
        FirebaseUser user = mAuth.getCurrentUser();
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!email.getText().toString().equals("") && !pwd.getText().toString().equals("")) {
                    validate(email.getText().toString(), pwd.getText().toString());
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Please enter details",Toast.LENGTH_LONG).show();
                }
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(uisecurity.this, login.class));
            }
        });
    }

    private void validate(final String umail, String upwd) {
        pd.setMessage("Authenticating....!!");
        pd.show();
        mAuth.signInWithEmailAndPassword(umail, upwd)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            pd.dismiss();
                            Toast.makeText(uisecurity.this, "Login Successful",
                                    Toast.LENGTH_SHORT).show();
                            usr=umail;
                            startActivity(new Intent(uisecurity.this, Activity_1.class));

                        } else {
                            Toast.makeText(uisecurity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            counter--;
                            info.setText("No Of Remaining Try..: " + String.valueOf(counter));
                            pd.dismiss();
                            if (counter == 0) {
                                log.setEnabled(false);
                            }
                        }

                        // ...
                    }
                });

    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to quit from app?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        uisecurity.super.onBackPressed();
                        //finish();
                        }

                }).create().show();
    }
}


