package com.example.d2a.tugas_recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

public class ResepActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resep);
        Intent intent = getIntent();
        String judul = intent.getStringExtra("judulText");
        String bahan = intent.getStringExtra("bahanText");
        String cara = intent.getStringExtra("langkahText");
        TextView title = findViewById(R.id.judulText);
        title.setText(judul);
        TextView tbahan = findViewById(R.id.bahanText);
        tbahan.setText(bahan);
        TextView tcara = findViewById(R.id.langkahText);
        tcara.setText(cara);
    }
}
