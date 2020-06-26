package com.example.tnp_ds;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Timer extends Service {
    Random rng = new Random();
    public int i, j = 0,k=0;
    public int ctr = 600;
    public int u = 1;
    public static int score1=0;
    public String q1, a1, a2, a3, a4, ans;
    private static final String TAG = Timer.class.getSimpleName();
    public static String formated;
    int c = 1;
    List<Integer> generated = new ArrayList<Integer>();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate, Thread name " + Thread.currentThread().getName());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i(TAG, "onStartCommand, Thread name " + Thread.currentThread().getName());

        // Perform Tasks [ Short Duration Task: Don't block the UI ]

        int sleepTime = intent.getIntExtra("sleepTime", 1800);

        new MyAsyncTask().execute(sleepTime);

        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        Log.i(TAG, "onBind, Thread name " + Thread.currentThread().getName());
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "onDestroy, Thread name " + Thread.currentThread().getName());
    }

    // AsyncTask class declaration
    @SuppressLint("StaticFieldLeak")
    class MyAsyncTask extends AsyncTask<Integer, String, Void> {
        private final String TAG = MyAsyncTask.class.getSimpleName();
        private TextView time;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            Log.i(TAG, "onPreExecute, Thread name " + Thread.currentThread().getName());
        }

        @Override // Perform our Long Running Task
        protected Void doInBackground(Integer... params) {
            Log.i(TAG, "doInBackground, Thread name " + Thread.currentThread().getName());
            int sleepTime = params[0];
            for (i = 0; i < 20; i++) {
                while (true) {
                    Integer next = rng.nextInt(20) + 1;
                    if (!generated.contains(next)) {
                        generated.add(next);
                        break;
                    }
                }
            }

           // if (c == 1) {

                quiz();
              // c = 0;
                //return null;
            //}

            while (ctr >= sleepTime) {
                publishProgress("" + ctr);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ctr--;
                Quiztnp.a_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // String question = Quiztnp.q_1.getText().toString();
                        k=1;
                        String answer = Quiztnp.a_1.getText().toString();
                        if (answer==ans)
                        {
                            Quiztnp.a_1.setBackgroundColor(Color.GREEN);
                            score1++;

                            Quiztnp.score.setText(String.valueOf(score1));

                        } else {
                            Quiztnp.a_1.setBackgroundColor(Color.RED);

                        }
                    }
                });
                Quiztnp.a_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String question = Quiztnp.q_1.getText().toString();

                        String answer = Quiztnp.a_2.getText().toString();
                        k=1;
                        if (answer.equals(ans))
                        {
                            Quiztnp.a_2.setBackgroundColor(Color.GREEN);
                            score1++;
                            Quiztnp.score.setText(String.valueOf(score1));

                        } else {
                            Quiztnp.a_2.setBackgroundColor(Color.RED);

                        }



                    }
                });
                Quiztnp.a_3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String question = Quiztnp.q_1.getText().toString();
                        String answer = Quiztnp.a_3.getText().toString();
                        k=1;
                        if (answer.equals(ans)) {
                            Quiztnp.a_3.setBackgroundColor(Color.GREEN);
                            score1++;
                            Quiztnp.score.setText(String.valueOf(score1));

                        } else {
                            Quiztnp.a_3.setBackgroundColor(Color.RED);
                        }

                    }
                });
                Quiztnp.a_4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String question = Quiztnp.q_1.getText().toString();
                        String answer = Quiztnp.a_4.getText().toString();
                        k=1;
                        if (answer.equals(ans)) {
                            Quiztnp.a_4.setBackgroundColor(Color.GREEN);
                            score1++;
                            Quiztnp.score.setText(String.valueOf(score1));

                        } else {

                            Quiztnp.a_4.setBackgroundColor(Color.RED);
                            //Thread.sleep(1000);
                        }
                    }
                });
                if(k==1)
                {
                    quiz();
                    k=0;
                }

                //ctr--;
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            int minutes = Integer.parseInt(values[0]) / 60;
            int seconds = Integer.valueOf(values[0]) % 60;
            formated = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
            Quiztnp.time.setText(formated);

            Log.i(TAG, "Counter Value " + values[0] + " onProgressUpdate, Thread name " + Thread.currentThread().getName());
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            stopSelf(); // Destroy the Service from within the Service class itself
            Log.i(TAG, "onPostExecute, Thread name " + Thread.currentThread().getName());

        }


        public void quiz() {
            Quiztnp.a_1.setBackgroundColor(Color.WHITE);
            Quiztnp.a_2.setBackgroundColor(Color.WHITE);
            Quiztnp.a_3.setBackgroundColor(Color.WHITE);
            Quiztnp.a_4.setBackgroundColor(Color.WHITE);


            while (j < 20) {
                int s = generated.get(j);
                //int s =i;
                switch (s) {
                    case 1:
                        q1 = "In a circular linked list";
                        a1 = "A. components are all linked together in some sequential manner";
                        a2 = "B. there is no beginning and no end.";
                        a3 = "C. components are arranged hierarchically.";
                        a4 = "D. forward and backward traversal within the list is permitted.";
                        ans = "B. there is no beginning and no end.";
                        break;
                    case 2:
                        q1 = "The time required to delete a node x from a doubly linked list having n nodes is";
                        a1 = "A. O(n)";
                        a2 = "B. O(log n)";
                        a3 = "C. O(1)";
                        a4 = "D. O(n log n)";
                        ans = "C. O(1)";
                        break;
                    case 3:
                        q1 = "Time taken for addition of element in queue is";
                        a1 = "A. O(1)";
                        a2 = "B. O(n)";
                        a3 = "C. O(log n)";
                        a4 = "D. None of these options";
                        ans= "C. O(log n)";
                        break;
                    case 4:
                        q1 = "A full binary tree with 2n+1 nodes contain";
                        a1 = "A. n leaf nodes";
                        a2 = "B. n non-leaf nodes";
                        a3 = "C. (n-1) leaf nodes";
                        a4 = "D. (n-1) non-leaf nodes";
                        ans = "B. n non-leaf nodes";
                        break;

                    case 5:
                        q1 = "Which of the following algorithmic paradigm is used in the merge sort";
                        a1 = "A. Dynamic Programming ";
                        a2 = "B. BackTracking ";
                        a3 = "C. Greedy method ";
                        a4 = "D. Divide and Conquer ";
                        ans = "D. Divide and Conquer ";
                        break;
                    case 6:
                        q1 = "Convert the infix to postfix for A-(B+C)*(D/E)";
                        a1 = "A. ABC+DE/*- ";
                        a2 = "B. ABC-DE/*- ";
                        a3 = "C. ABC-DE*/- ";
                        a4 = "D. None of the above ";
                        ans = "A. ABC+DE/*-";
                        break;
                    case 7:
                        q1 = "A graph with n vertices will definitely have a parallel edge or self loop of the total number of edges are";
                        a1 = "A. more than n ";
                        a2 = "B. more than n+1 ";
                        a3 = "C. more than (n+1)/2 ";
                        a4 = "D. more than n(n-1)/2 ";
                        ans = "D. more than n(n-1)/2 ";
                        break;
                    case 8:
                        q1 = "A linear collection of data elements where the linear node is given by meQuiztnp.aans of pointer is called";
                        a1 = "A. linked list ";
                        a2 = "B. node list ";
                        a3 = "C. primitive list ";
                        a4 = "D. None of these ";
                        ans = "A. linked list ";
                        break;
                    case 9:
                        q1 = "Which of these are core interfaces in the collection framework. Select the one correct Quiztnp.aanswer.";
                        a1 = "A. Tree ";
                        a2 = "B. Stack ";
                        a3 = "C. Queue ";
                        a4 = "D. Map ";
                        ans = "D. Map ";
                        break;
                    case 10:
                        q1 = "The extra key inserted at the end of the array is called a,";
                        a1 = "A. End key. ";
                        a2 = "B. Stop key. ";
                        a3 = "C. Sentinel. ";
                        a4 = "D. TrQuiztnp.aansposition. ";
                        ans = "C. Sentinel. ";
                        break;
                    case 11:
                        q1="Maximum number of nodes in a binary tree with height k, where root is height 0, is";
                        a1 = "A. 2^k+1 ";
                        a2 = "B. 2^k-1 ";
                        a3 = "C. 2^(k+1)-1";
                        a4 = "D. 2^(k-1)-1";
                        ans = "C. 2^(k+1)-1";
                        break;
                    case 12:
                        q1 = "Graph traversal is different from a tree traversal, because";
                        a1 = "A. trees are not connected ";
                        a2 = "B. graph have a loop. ";
                        a3 = "C. tree is a subset  of graph ";
                        a4 = "D. Trees have root ";
                        ans ="D. Trees have root ";
                        break;
                    case 13:
                        q1 = "node.next -> node.next.next; will make";
                        a1 = "A. node.next inacessible. ";
                        a2 = "B. node.next.next.inacessible. ";
                        a3 = "C. node is inaccesible ";
                        a4 = "D. none of the above ";
                        ans ="A. node.next inacessible. ";
                        break;
                    case 14:
                        q1 =  "In the deletion operation of max heap, the root is replaced by";
                        a1 = "A.next available value in the left sub-tree. ";
                        a2 = "B.next available value in the right sub-tree.";
                        a3 = "C.any random value from the heap.";
                        a4 = "D.last element of the last level";
                        ans=" D.last element of the last level";
                        break;
                    case 15:
                        q1 ="Binary search tree is an example of complete binary tree with special attributes";
                        a1 = "A . BST does not care about complete binary tree properties.";
                        a2 = "B.  BST takes care of complete binary tree properties.";
                        a3 = "C .It depends upon the input.";
                        a4 = "D. none of the above ";
                        ans = "A . BST does not care about complete binary tree properties.";
                        break;
                    case 16:
                        q1 ="A stable sorting alrithm";
                        a1 = "A.does not crash.";
                        a2 = "B.does not run out of memory.";
                        a3 = "C.does not change the sequence of appearance of elements";
                        a4 = "D.none of the above ";
                        ans ="C.does not change the sequence of appearance of elements";
                        break;
                    case 17:
                        q1 ="Which of the following methods can be used to find the largest and smallest number in a linked list?";
                        a1 = "A.Recursion.";
                        a2 = "B.Iteration.";
                        a3 = "C.both recursion and iteration";
                        a4 = "D.Impossible to find the largest and smallest numbers";
                        ans = "C.both recursion and iteration";
                        break;
                    case 18:
                        q1 ="A tree is a tree where for each parent node, there is only one associated child node";
                        a1 = "A.balanced binary tree";
                        a2 = "B.rotated completed binary tree.";
                        a3 = "C.complete binary tree";
                        a4 = "D.degenerate tree";
                        ans = "D.degenerate tree";
                        break;
                    case 19:
                        q1 ="On which principle does stack work?";
                        a1 = "A.FILO";
                        a2 = "B.FIFO";
                        a3 = "C.LILO";
                        a4 = "D.BOTH LIFO AND FILO";
                        ans ="D.BOTH LIFO AND FILO";
                        break;
                    case 20:
                        q1 ="On which principle does queue work?";
                        a1 = "A.LIFO";
                        a2 = "B.FIFO";
                        a3 = "C.LILO";
                        a4 = "D.BOTH LILO AND FILO";
                        ans ="B.FIFO";
                        break;

                    default:
                        break;


                }
                Quiztnp.q_1.setText(String.valueOf(j+1)+". "+q1);
                Quiztnp.a_1.setText(a1);
                Quiztnp.a_2.setText(a2);
                Quiztnp.a_3.setText(a3);
                Quiztnp.a_4.setText(a4);
                j++;
                if(j==20)
                {
                    Quiztnp.q_1.setVisibility(View.INVISIBLE);
                    Quiztnp.a_1.setVisibility(View.INVISIBLE);
                    Quiztnp.a_2.setVisibility(View.INVISIBLE);
                    Quiztnp.a_3.setVisibility(View.INVISIBLE);
                    Quiztnp.a_4.setVisibility(View.INVISIBLE);
                    Quiztnp.time.setVisibility(View.INVISIBLE);
                    //Intent i = new Intent(Quiztnp.this,Activity_1.class);
                }
                break;
            }
        }

    }
}



