package com.klein.wetalks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddContactActivity extends AppCompatActivity {

    EditText name, number;
    Button add;
    ContactDAO contactDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        name = findViewById(R.id.editTextName);
        number = findViewById(R.id.editTextNumber);
        add = findViewById(R.id.buttonAddContact);

        contactDAO = new ContactDAO(this);

        add.setOnClickListener(v -> {
            String name = this.name.getText().toString();
            String number = this.number.getText().toString();

            if (name.isEmpty() || number.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            Contact contact = new Contact(name, number);
            contactDAO.addContact(contact);
            Toast.makeText(this, "Contact added successfully", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}