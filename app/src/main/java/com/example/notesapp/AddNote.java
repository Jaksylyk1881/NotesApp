package com.example.notesapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;

public class AddNote extends AppCompatActivity {
    private EditText editTextTitle;
    private EditText editTextDescription;
    private Spinner spinnerDays;
    private RadioGroup radioGroupPriority;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        editTextTitle =findViewById(R.id.editTextTitle);
        editTextDescription =findViewById(R.id.editTextDescription);
        spinnerDays = findViewById(R.id.spinnerDays);
        radioGroupPriority = findViewById(R.id.radioGroup);

    }

    public void onClickAddItemToNote(View view) {
        String title = editTextTitle.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();
        int day = spinnerDays.getSelectedItemPosition()+1;
        int buttonId = radioGroupPriority.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(buttonId);
        int priority = Integer.parseInt(radioButton.getText().toString());
        if (isFilled(title,description)) {
            Notes note = new Notes(title,description,day,priority);
            viewModel.InsertNote(note);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(this, R.string.warning_fill_all_fields, Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isFilled(String title,String description){
        return !title.isEmpty() && !description.isEmpty();
    }
}