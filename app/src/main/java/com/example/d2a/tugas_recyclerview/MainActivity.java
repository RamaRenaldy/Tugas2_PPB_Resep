package com.example.d2a.tugas_recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    RecyclerView r1;
    private LinkedList<String> s1;
    private LinkedList<String> s2 = new LinkedList<String>();
    private LinkedList<String> s3 = new LinkedList<String>();
    private LinkedList<String> s4 = new LinkedList<String>();
    ResepAdapter adap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s1 = new LinkedList<String>(Arrays.asList(getResources().getStringArray(R.array.judul_resep)));
        s2 = new LinkedList<String>(Arrays.asList(getResources().getStringArray(R.array.deskripsi)));
        s3 = new LinkedList<String>(Arrays.asList(getResources().getStringArray(R.array.bahan2)));
        s4 = new LinkedList<String>(Arrays.asList(getResources().getStringArray(R.array.langkah2)));
        setContentView(R.layout.activity_main);
        r1 = findViewById(R.id.resepRV);
        adap = new ResepAdapter(this,s1,s2,s3,s4);
        r1.setAdapter(adap);
        r1.setLayoutManager(new LinearLayoutManager(this));
    }
    
}
