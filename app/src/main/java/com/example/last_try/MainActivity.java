package com.example.last_try;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    final int ADD_REQUEST_CODE = 1;
    final int Edit_REQUEST_CODE = 2;
    ArrayList<Contact> contact =new ArrayList<>();
    Adapter_View.OnClickItemListner Op = new Adapter_View.OnClickItemListner() {
        @Override
        public void c(Contact contact, int position) {
            Intent i = new Intent(MainActivity.this,Add_Data.class);
            i.putExtra("contact",contact);
            // i.putExtra("position",position);
            startActivityForResult(i,Edit_REQUEST_CODE);

        }

        @Override
        public void delete(Contact contact, int position) {

        }
    };{

    }
    Adapter_View adapter = new Adapter_View(Op);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        adapter.contacts=contact;


    }
    void initViews() {
        rv = findViewById(R.id.recycler);
        rv.setAdapter(adapter);
        FloatingActionButton fab = findViewById(R.id.btnFabAdd);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Add_Data.class);
                startActivityForResult(i,ADD_REQUEST_CODE);


            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            contact.add((Contact) data.getSerializableExtra("contact"));
            adapter.notifyDataSetChanged();
        }else if (requestCode==Edit_REQUEST_CODE&&resultCode==Activity.RESULT_OK){

            contact.set(data.getIntExtra("position", 0), (Contact) data.getSerializableExtra("contact"));
            adapter.notifyDataSetChanged();

        }}}
