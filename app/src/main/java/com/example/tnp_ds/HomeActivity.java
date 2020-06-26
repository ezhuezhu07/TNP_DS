package com.example.tnp_ds;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.xml.sax.Parser;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<DataSetFire> arrayList;
    private SearchView searchView;
    private FirebaseRecyclerOptions<DataSetFire> options;
    private FirebaseRecyclerAdapter<DataSetFire, FireBaseViewHolder> adapter;
    private DatabaseReference databaseReference1;

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.recyclerview);
        //searchView=findViewById(R.id.searchview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList = new ArrayList<DataSetFire>();
        databaseReference1 = FirebaseDatabase.getInstance().getReference().child("Ds_programs");
        databaseReference1.keepSynced(true);
        options = new FirebaseRecyclerOptions.Builder<DataSetFire>().setQuery(databaseReference1, DataSetFire.class).build();
        adapter = new FirebaseRecyclerAdapter<DataSetFire, FireBaseViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FireBaseViewHolder fireBaseViewHolder, int i, @NonNull final DataSetFire dataSetFire) {
                fireBaseViewHolder.question_name.setText(dataSetFire.getQname());
                fireBaseViewHolder.question_type.setText("Type:"+dataSetFire.getQtype());
                fireBaseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(HomeActivity.this,Programs.class);
                        intent.putExtra("question_name",dataSetFire.getQname());
                        startActivity(intent);
                    }
                });
            }
            @NonNull
            @Override
            public FireBaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new FireBaseViewHolder(LayoutInflater.from(HomeActivity.this).inflate(R.layout.row, parent, false));

            }

        };
        recyclerView.setAdapter(adapter);

    }

}
