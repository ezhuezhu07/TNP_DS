package com.example.tnp_ds;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Answertnp extends AppCompatActivity implements MyInterface  {
    public static FragmentManager manager;
    public static FragmentTransaction transaction;
    public String copyText,Ques;
    public int a=1;
    ClipboardManager clipboardManager;
    ClipData clipData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answertnp);
        fr();
    }
    public  void fr()
    {

        int question_number = a;
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.QUESTION_NUM,question_number);
        question Question = new question();
        Question.setArguments(bundle);
        transaction.add(R.id.frag2,Question,null);
        transaction.commit();

    }
    public void clip(View view)
    {
        clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        if(copyText!="")
        {
            clipData= ClipData.newPlainText("text",copyText);
            clipboardManager.setPrimaryClip(clipData);
            Toast.makeText(Answertnp.this,"Copied",Toast.LENGTH_LONG).show();
        }
    }
    public void btn(View view)
    {
        manager = getSupportFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.QUESTION_QUES,Ques);
        first f = new first();
        f.setArguments(bundle);
        transaction = manager.beginTransaction();
        transaction.add(R.id.frag, f, "frag");
        transaction.commit();
    }
    public void Next(View v)
    {
        if(a<23) {
            a++;
            int question_number = a;
            Fragment fragment = manager.findFragmentById(R.id.frag);
            if(fragment!=null)
            {
                transaction=manager.beginTransaction();
                transaction.remove(fragment);
                transaction.commit();
            }
            Bundle bundle = new Bundle();
            bundle.putInt(Constants.QUESTION_NUM, question_number);
            question Question = new question();
            Question.setArguments(bundle);
            transaction = manager.beginTransaction();
            transaction.add(R.id.frag2, Question, "second");
            transaction.commit();
        }
        if(a==22)
        {
            a=0;
        }
    }
    public void Prev(View v)
    {
        if(a>1) {
            a--;
            int question_number = a;
            Fragment fragment = manager.findFragmentById(R.id.frag);
            if(fragment!=null)
            {
                transaction=manager.beginTransaction();
                transaction.remove(fragment);
                transaction.commit();
            }
            Bundle bundle = new Bundle();
            bundle.putInt(Constants.QUESTION_NUM, question_number);
            question Question = new question();
            Question.setArguments(bundle);
            transaction = manager.beginTransaction();
            transaction.add(R.id.frag2, Question, "second");
            transaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Fragment fragment = manager.findFragmentById(R.id.frag);
        if(fragment!=null)
        {
            transaction=manager.beginTransaction();
            transaction.remove(fragment);
            transaction.commit();
        }
    }
    @Override
    public void ques(String quest)
    {
        Ques=quest;
    }
    @Override
    public void copy(String txt)
    {
        copyText=txt;
    }
}
