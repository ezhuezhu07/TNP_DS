package com.example.tnp_ds;


import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FireBaseViewHolder extends RecyclerView.ViewHolder {

    public TextView question_name,question_type;
    public FireBaseViewHolder(@NonNull View itemView) {
        super(itemView);
        question_name=itemView.findViewById(R.id.question_name);
        question_type=itemView.findViewById(R.id.question_type);
    }
}
