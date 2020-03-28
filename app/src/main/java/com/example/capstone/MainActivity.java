package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView ivAddWidgets, ivProfile, ivSetup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Linking variables to their respective id
        ivAddWidgets = findViewById(R.id.ivAddWidgets);
        ivProfile = findViewById(R.id.ivProfile);
        ivSetup = findViewById(R.id.ivSetup);

        //ivSetup.setColorFilter(getResources().getColor(R.color.colorAccent)); // changes colours
    }

    // OnClick buttons
    public void addActivityPage(View v) {
        Intent intent = new Intent(MainActivity.this, AddWidgets.class);
        startActivity(intent);
    }

    public void profileActivityPage(View v) {
        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

    public void settingActivityPage(View v) {
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }
}