package com.example.last_try;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Add_Data extends AppCompatActivity {
   private EditText tf;
   private EditText gt;
  FloatingActionButton ff ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__data);
        initView();

        if (getIntent().hasExtra("contact")){
            Contact contact = (Contact) getIntent().getSerializableExtra("contact");
            tf.setText(contact.getName());
            gt.setText(contact.getNumber());

        }



    }
    void initView() {
        tf = findViewById(R.id.edName);
        gt = findViewById(R.id.edNumber);
        ff = findViewById(R.id.bb);
        ff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contact contact = createContact(tf.getText().toString(), gt.getText().toString());
                if (contact != null) {
                    Intent intent = new Intent();
                    intent.putExtra("contact", contact);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
    private Contact createContact(String name, String number) {
        boolean invalid = false;
        if (name == null || name.isEmpty()) {
            invalid = true;
            tf.setError("لا يمكن إضافة مستحدم بدون اسم");
        }
        if (number == null || number.isEmpty()) {
            invalid = true;
            gt.setError("لا يمكن إضافة مستخدم بدون رقم ");
        }
        if (invalid) return null;
        else return new Contact(name, number);
    }


    }

