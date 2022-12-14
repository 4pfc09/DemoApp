package com.example.demoapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnToTabbedView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToTabbedView = findViewById(R.id.btnToTabs);
        btnToTabbedView.setOnClickListener(a -> goToTabbedActivity());

    }


    private void goToTabbedActivity() {
        Intent intent = new Intent(this, BuiltInTabbedActivity.class);
        startActivity(intent);
    }
}