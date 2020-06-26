package com.example.tnp_ds;



import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class question extends Fragment {
    private  String q;
    private TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_question, container, false);
        textView = v.findViewById(R.id.textview);
        textView.setMovementMethod(new ScrollingMovementMethod());
        Bundle bundle = getArguments();
        final int question_number = bundle.getInt(Constants.QUESTION_NUM, 1);
        if(question_number>=1)
        {


            switch (question_number)
            {
                case 1:
                    q = "1.What is data structures?";
                    break;
                case 2:
                    q="2.What are the types of data structures?";
                    break;
                case 3:
                    q="3.What is linear data structure?";
                    break;
                case 4 :
                    q="4.What is non linear data structure?";
                    break;
                case 5:
                    q="5.What is a stack?";
                    break;
                case 6 :
                    q="6.Which data structures are used for BFS and DFS of a graph?";
                    break;
                case 7 :
                    q="7.Can doubly linked be implemented using a single pointer variable in every node?";
                    break;
                case 8 :
                    q="8.Explain Binary Search Tree";
                    break;
                case 9 :
                    q="9.What are multidimensional arrays?";
                    break;
                case 10 :
                    q="10.Are linked lists considered linear or non-linear data structures?";
                    break;
                case 11:
                    q="11.How does dynamic memory allocation help in managing data?";
                    break;
                case 12:
                    q="12.What is FIFO?";
                    break;
                case 13:
                    q="13.What is an ordered list?";
                    break;
                case 14:
                    q="14.What is merge sort?";
                    break;
                case 15:
                    q="15.Differentiate NULL and VOID";
                    break;
                case 16:
                    q="16.What is the difference between a PUSH and a POP?";
                    break;
                case 17:
                    q="17.Do all declaration statements result in a fixed reservation in memory?";
                    break;
                case 18:
                    q="18.What is a linear search?";
                    break;
                case 19:
                    q="19.What is a postfix expression?";
                    break;
                case 20:
                    q="20.What is Data abstraction?";
                    break;
                case 21:
                    q="21.How do you insert a new item in a binary search tree?";
                    break;
                case 22:
                    q="22.How do signed and unsigned numbers affect memory?";
                    //question_number=1;
                    break;

            }
        }
        MyInterface myInterface = (MyInterface) getActivity();
        myInterface.ques(q);
        textView.setText(q);
        return v;
    }



}
