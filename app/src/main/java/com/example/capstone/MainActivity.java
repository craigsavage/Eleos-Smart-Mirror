package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView ivAdd, ivMood, ivSettings;
    TextView tvAddWidgets, tvMoods, tvSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Linking variables to their respective id
        ivAdd = findViewById(R.id.ivAdd);
        ivMood = findViewById(R.id.ivMood);
        ivSettings = findViewById(R.id.ivSettings);

        tvAddWidgets = findViewById(R.id.tvAddWidgets);
        tvMoods = findViewById(R.id.tvMoods);
        tvSettings = findViewById(R.id.tvSettings);

        ivMood.setColorFilter(getResources().getColor(R.color.colorPrimary));
    }

    // OnClick buttons
    public void addActivityPage(View v) {
        Toast.makeText(MainActivity.this, "Add Widgets", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this, AddWidgets.class);
        startActivity(intent);
    }

    public void moodsActivityPage(View v) {
        Toast.makeText(MainActivity.this, "Moods", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this, Moods.class);
        startActivity(intent);
    }

    public void settingActivityPage(View v) {
        Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }
}