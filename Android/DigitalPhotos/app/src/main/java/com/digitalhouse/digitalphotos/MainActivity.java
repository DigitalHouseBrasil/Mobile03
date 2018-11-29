package com.digitalhouse.digitalphotos;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.digitalhouse.digitalphotos.adapters.RecyclerViewImageAdapter;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private RecyclerView recyclerImages;
    private RecyclerViewImageAdapter adapter;
    private FirebaseStorage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = findViewById(R.id.fab);
        recyclerImages = findViewById(R.id.recycler_images);
        adapter = new RecyclerViewImageAdapter(new ArrayList<>());
        storage = FirebaseStorage.getInstance();

        recyclerImages.setLayoutManager(new LinearLayoutManager(this));


        fab.setOnClickListener(view -> {

        });
    }
}
